package com.cba.api.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cba.api.dto.CustomerDTO;
import com.cba.api.dto.CustomerDealerDTO;
import com.cba.api.dto.DealerDTO;
import com.cba.api.dto.EmployeeDTO;
import com.cba.api.dto.GSTParamsDTO;
import com.cba.api.dto.SubscriptionDTO;
import com.cba.api.exceptions.PackageCodeNotFound;
import com.cba.api.helper.CoreBillingAPIHelper;
import com.cba.api.repository.CustomerRepository;
import com.cba.api.repository.DealerRepository;
import com.cba.api.repository.EmployeeRepository;
import com.cba.api.repository.PackageTypeRepository;
import com.cba.api.repository.SubscriptionRepository;
import com.cba.api.repository.UsersRepository;
import com.cba.api.services.CoreBillingServices;
import com.cba.entity.Customer;
import com.cba.entity.Dealer;
import com.cba.entity.Employee;
import com.cba.entity.PackageType;
import com.cba.entity.Subscription;
import com.cba.entity.Users;

/**
 * {@link com.cba.api.services.CoreBillingServices}
 * 
 * @author manikandan.rajendran
 *
 */
@Transactional
@Service
public class CoreBillingServicesImpl implements CoreBillingServices {

	@SuppressWarnings("unused")
	private final Logger logger=LoggerFactory.getLogger(CoreBillingServicesImpl.class);
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	DealerRepository dealerRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	PackageTypeRepository packageTypeRepository;
	@Autowired
	ConnectCarServicesImpl connectCarServices;

	CoreBillingAPIHelper objectEntityMapper = new CoreBillingAPIHelper();

	public Users addUsers(Users userObj) {
		return usersRepository.save(userObj);
	}

	public Customer addCustomer(Customer customerObj) {
		return customerRepository.save(customerObj);
	}

	public Dealer addDealer(Dealer dealerObj) {
		return dealerRepository.save(dealerObj);
	}

	public Employee addEmployee(Employee employeeObj) {
		return employeeRepository.save(employeeObj);

	}

	public Subscription addSubscription(Subscription subscriptionObj) {
		return subscriptionRepository.save(subscriptionObj);

	}

	public List<PackageType> listAllPackages() {
		if (packageTypeRepository.findAll().isEmpty()) {
			throw new PackageCodeNotFound("PackageType", "listAllPackages", listAllPackages());
		}
		return packageTypeRepository.findAll();
	}


	public String save(CustomerDealerDTO customerDealerdto) throws Exception {
		Date date = new Date();
		CustomerDTO customerinfo = customerDealerdto.getCustomerinfo();
		DealerDTO dealerinfo = customerDealerdto.getDealerinfo();
		EmployeeDTO empinfo = customerDealerdto.getEmployeeinfo();
		Subscription subscriptionObj = new Subscription();

		String customerNbr = customerinfo.getCustomerNbr();
		String empNbr = empinfo.getEmpNbr();

		Optional<String> customerNumber = Optional.of("customerNbr");
		Optional<String> employeeNumber = Optional.of("empNbr");

		List<Users> adminUser = usersRepository.findByuserType("User");
		int createbyUser = adminUser.get(0).getUserId().intValue();
		System.out.println("createbyUser" + createbyUser);

		if (customerNumber.isPresent()) {
			boolean exists = customerRepository.existsCustomerBycustomerNbr(customerNbr);
			if (!exists) {

				Users userentity = objectEntityMapper.getUserEntity(customerinfo);
				userentity.setCreatedBy(createbyUser);
				userentity.setLogin(customerNbr);
				userentity.setCreatedDate(date);
				userentity.setUpdatedBy(createbyUser);
				addUsers(userentity);

				Customer customerentity = objectEntityMapper.getCustomerEntity(customerinfo);
				customerentity.setCustomerId(userentity.getUserId());
				addCustomer(customerentity);
				subscriptionObj.setCustomerId(customerentity.getCustomerId().intValue());

				System.out.println("save customer  completed");

			} else {
				List<Customer> customerList = customerRepository.findBycustomerNbr(customerNbr);
				subscriptionObj.setCustomerId(customerList.get(0).getCustomerId().intValue());

			}
		}

		if (employeeNumber.isPresent()) {
			boolean exists = employeeRepository.existsEmployeeByempNbr(empNbr);
			if (!exists) {

				Users useremployeeEntity = objectEntityMapper.getUserEmployeeEntity(empinfo);

				useremployeeEntity.setCreatedBy(createbyUser);
				useremployeeEntity.setLogin(empNbr);
				addUsers(useremployeeEntity);
				System.out.println("save user 2  completed");

				Dealer dealerentity = objectEntityMapper.getDealerEntity(dealerinfo);
				
			    
				if (!dealerRepository.existsDealerBydealerNbr(dealerentity.getDealerNbr())) {
					dealerentity.setDealerId(useremployeeEntity.getUserId());
					addDealer(dealerentity);
				}else {
					List<Dealer> result   = dealerRepository.findBydealerNbr(dealerentity.getDealerNbr());
					if(result.size() > 0) {
						dealerentity = result.get(0);
					}
				}
				

				System.out.println("save dealer  completed");

				// Employee details
				Employee employeeEntity = objectEntityMapper.getEmployeeEntity(empinfo);
				employeeEntity.setEmpId(useremployeeEntity.getUserId());
				employeeEntity.setDealerId(dealerentity.getDealerId());
				employeeEntity.setCreatedBy(createbyUser);

				addEmployee(employeeEntity);
				System.out.println("save employee  completed");

				subscriptionObj.setEmpId(employeeEntity.getEmpId().intValue());
				subscriptionObj.setDealerId(dealerentity.getDealerId().intValue());
				subscriptionObj.setCreated_by(createbyUser);
				System.out.println("save employee  done");

			}

			else {
				List<Employee> employeeList = employeeRepository.findByempNbr(empNbr);
				subscriptionObj.setEmpId(employeeList.get(0).getEmpId().intValue());
				subscriptionObj.setDealerId(employeeList.get(0).getDealerId().intValue());
				subscriptionObj.setCreated_by(createbyUser); // createbyUser

			}

		}

		SubscriptionDTO subscriptioninfo = customerDealerdto.getSubscriptioninfo();
		Subscription subscriptionEntity = objectEntityMapper.getSubscriptionEntity(subscriptioninfo);
		List<PackageType> packagetypeObj = packageTypeRepository.findBypkgCode(subscriptioninfo.getPkgCode());
		
		subscriptionEntity.setPkgTypeId(packagetypeObj.get(0).getPkgTypeId());
		subscriptionEntity.setCreated_by(subscriptionObj.getCreated_by());
		subscriptionEntity.setCustomerId(subscriptionObj.getCustomerId());
		subscriptionEntity.setEmpId(subscriptionObj.getEmpId());
		subscriptionEntity.setDealerId(subscriptionObj.getDealerId());
		addSubscription(subscriptionEntity);

		String vinNumber = subscriptioninfo.getVinNbr();
		int duration = packagetypeObj.get(0).getDuration();

		connectCarServices.updateSubscriptionDate(vinNumber, duration);

		return "Success";

	}
	
	
	/**
	 * Logic to update the IRN and QR Code for the given certificate number.
	 */
	public void updateIRNandQRCode(GSTParamsDTO gstParamDTO) {
		
		List<Subscription> subscriptions = subscriptionRepository.findBycertificateNbr(gstParamDTO.getCertificateNbr());
		 for (Subscription subscription : subscriptions ) {
			 subscription.setIrnNbr(gstParamDTO.getIrnNbr());
			 subscription.setQrCode(gstParamDTO.getQrCode());
			 subscriptionRepository.save(subscription);
		 }
	};
	
	

}
