package com.cba.api.services.impl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.CustomerDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.dto.SubscriptionDTO;
import com.cba.api.dto.SubscriptionParamsDTO;
import com.cba.api.dto.VehicleDetailsDTO;
import com.cba.api.helper.CoreBillingAPIHelper;
import com.cba.api.repository.CustomerRepository;
import com.cba.api.repository.DealerRepository;
import com.cba.api.repository.EmployeeRepository;
import com.cba.api.repository.GenericQueryRepository;
import com.cba.api.repository.PackageTypeRepository;
import com.cba.api.repository.SAPInterfaceRepository;
import com.cba.api.repository.SubscriptionRepository;
import com.cba.api.repository.UsersRepository;
import com.cba.api.services.CoreBillingB2BService;
import com.cba.api.services.EmailService;
import com.cba.api.services.PdfService;
import com.cba.api.utils.EmailDetails;
import com.cba.entity.Customer;
import com.cba.entity.PackageType;
import com.cba.entity.SAPInterface;
import com.cba.entity.Subscription;
import com.cba.entity.Users;
import com.cba.gst.integration.services.GSTPortalIntergrationServices;

/**
 * 
 * Refer {@link com.cba.api.services.CoreBillingB2BService}
 *
 */
@Transactional
@Service
public class CoreBillingB2BServiceImpl implements CoreBillingB2BService {

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
	@Autowired
    SAPInterfaceRepository sapInterfaceRepository;
	
	@Autowired
	EmailService emailService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	GenericQueryRepository query;
	

	@Autowired
	PdfService pdfService;
	
	
	@Autowired
	GSTPortalIntergrationServices gstPortalService;

	private CoreBillingAPIHelper helper = new CoreBillingAPIHelper();

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(CoreBillingB2BServiceImpl.class);

	/**
	 * Refer {@link com.cba.api.services.CoreBillingB2BService#listAllPackages()}
	 */
	@Override
	public List<PackageType> listAllPackages() {
		return packageTypeRepository.findAll();
	}

	/**
	 * Refer
	 * {@link com.cba.api.services.CoreBillingB2BService#getCustomerDetails(String)}
	 */
	@SuppressWarnings("deprecation")
	@Override
	public CustomerDTO getCustomerDetails(String vinNumber) {
		// TODO dummy Implementation
		CustomerDTO customer = new CustomerDTO();
		customer.setCustomerNbr("C1001");
		customer.setAddressLine1("No 6A, ponniamman koil street");
		customer.setAddressLine2("Hasthinapuram");
		customer.setCity("Chennai");
		customer.setCityCode("33");
		customer.setDistrict("Kancheepuram");
		customer.setEmail("balaji.desikan@htcinc.com");
		customer.setGstNbr("33AABCU9603R1ZU");
		customer.setIsSez("N");
		customer.setMobile("9840424471");
		customer.setName("Balaji Desikan");
		customer.setPincode("600064");
		customer.setSacCode("33");
		customer.setState("Tamil Nadu");
		VehicleDetailsDTO vehicle = new VehicleDetailsDTO();
		vehicle.setFuelType("Petrol");
		vehicle.setModelName("Creta");
		vehicle.setOdometerReading("289384384");
		vehicle.setRegDate(new Date(2012, 10, 2));
		vehicle.setRegNumber("TN22A3069");
		vehicle.setVariantName("EV36");
		vehicle.setVehicleSoldDate(new Date(2012, 10, 2));
		vehicle.setVinNumber("VIN1002002");
		customer.setVehicleDetails(vehicle);
		return customer;
	}

	/**
	 * Refer
	 * {@link com.cba.api.services.CoreBillingB2BService#getSubscriptionsByVin(String)
	 */
	@Override
	public List<SubscriptionDTO> getSubscriptionsByVin(String vinNumber) {
		List<SubscriptionDTO> subscriptionList = subscriptionRepository.findAllByVinNbr(vinNumber).stream()
				.map(subscription -> helper.toSubscriptionDTO(subscription)).toList();
		return subscriptionList;
	}

	/**
	 * Refer
	 * {@link com.cba.api.services.CoreBillingB2BService#getPackageTypeByCode(String)}
	 */
	@Override
	public List<PackageType> getPackageTypeByCode(String packageTypeCode) {
		return packageTypeRepository.findBypkgCode(packageTypeCode);
	}

	/**
	 * Refer
	 * {@link com.cba.api.services.CoreBillingB2BService#saveSubscription(SubscriptionParamsDTO)}
	 */
	@Override
	public Subscription saveSubscription(SubscriptionParamsDTO input) throws Exception {

		CustomerDTO customerDTO = getCustomerDetails(input.getVinNumber());
		List<PackageType> packageTypes = getPackageTypeByCode(input.getPackageTypeCode());
		PackageType packageType = null;
		if (packageTypes != null & packageTypes.size() == 1) {
			packageType = packageTypes.get(0);
		} else if (packageTypes != null & packageTypes.size() > 1) {
			throw new Exception(" Multiple Package Types with same code");
		}
		Customer customer = saveCustomer(customerDTO);
		VehicleDetailsDTO vehicle = customerDTO.getVehicleDetails();
		String customerName = customerDTO.getName();
		String email = customerDTO.getEmail();
		customerDTO = helper.toCustomerDTO(customer);
		customerDTO.setVehicleDetails(vehicle);
		customerDTO.setName(customerName);
		customerDTO.setEmail(email);
		Subscription subscription = saveSubscription(customerDTO, packageType);
		if (customerDTO.getGstNbr() != null && customerDTO.getGstNbr().trim().length() > 0) {
			generateIRNAndQRCode(subscription, customerDTO);
		}
		createRecordInSAPInterfaceTable(subscription, customerDTO);
		connectCarServices.updateSubscriptionDate(input.getVinNumber(), packageType.getDuration());
		subscriptionRepository.save(subscription); //Saving at the last because it will have all updated including the IRN and QR Code
		entityManager.flush();
		subscription.setCustomerEmail(customerDTO.getEmail());
		subscription.setCustomerName(customerDTO.getName());
		 try {
			 sendEmail(subscription);
		} catch (Exception e) {
			e.printStackTrace();
			//this should not propogate since it is expected to be the mail server handling issue.
		} 
		
		return subscription;
	}

	/**
	 * 
	 * @param customerDTO
	 * @return
	 * @throws Exception
	 */
	private Customer saveCustomer(CustomerDTO customerDTO) throws Exception {
		String customerNbr = customerDTO.getCustomerNbr();
		Customer customerentity = null;
		boolean exists = customerRepository.existsCustomerBycustomerNbr(customerNbr);
		if (!exists) {

			Users userentity = helper.getUserEntity(customerDTO);
			userentity.setCreatedBy(1);
			userentity.setLogin(customerNbr);
			userentity.setCreatedDate(new Date());
			userentity.setUpdatedBy(1);
			usersRepository.save(userentity);
			customerentity = helper.getCustomerEntity(customerDTO);
			customerentity.setCustomerId(userentity.getUserId());
			customerRepository.save(customerentity);

		} else {
			List<Customer> customerRecords = customerRepository.findBycustomerNbr(customerNbr);

			if (customerRecords != null & customerRecords.size() == 1) {
				customerentity = customerRecords.get(0);
			} else if (customerRecords != null & customerRecords.size() > 1) {
				throw new Exception(" Multiple customers with same code");
			}
		}
		return customerentity;
	}

	/**
	 * 
	 * @param customerDTO
	 * @param packageType
	 * @return
	 */
	private Subscription saveSubscription(CustomerDTO customerDTO, PackageType packageType) {
		String nextVal = getNextSubscriptionNumber();
		return helper.toSubscriptionEntity(customerDTO, packageType, nextVal);
	}

	/**
	 * 
	 * @param subscription
	 * @param customerDTO
	 * @throws Exception
	 */
	private void generateIRNAndQRCode(Subscription subscription, CustomerDTO customerDTO) throws Exception {
		gstPortalService.generateIRNAndQRCode(subscription, customerDTO);
	}

	/**
	 * 
	 * @param subscription
	 * @param customerDTO
	 */
	private void createRecordInSAPInterfaceTable(Subscription subscription, CustomerDTO customerDTO) {
		   SAPInterface sapInterface=helper.getSapInterface(subscription, customerDTO);
	        sapInterfaceRepository.save(sapInterface);      
	}

	 
	@Override
	public CertificateGenerationDTO getCertificateDTO(String certificateNbr) throws Exception {
		List<CertificateGenerationDTO> result = query.getCertificateDetails(certificateNbr);
		return result.get(0);
	}

	 
	@Override
	public InvoiceGenerationDTO getInvoiceDTO(String certificateNbr) throws Exception {
		List<InvoiceGenerationDTO> result = query.getInvoiceDetails(certificateNbr);
		return result.get(0);
	}
	
	
	/**
	 * Refer
	 * {@link com.cba.api.services.CoreBillingB2BService#getSubscriptionByCertificateNbr(String)}
	 */
	@Override
	public Subscription getSubscriptionByCertificateNbr(String certificateNbr) throws Exception {
		List<Subscription> subscriptions = subscriptionRepository.findBycertificateNbr(certificateNbr);
		if (subscriptions != null & subscriptions.size() == 1) {
			return subscriptions.get(0);
		} else if (subscriptions != null & subscriptions.size() > 1) {
			throw new Exception(" Multiple Subscriptions with same Certificate number");
		}
		return null;
	}

	 
	private void sendEmail(Subscription subscription) throws Exception{
	
		EmailDetails details = new EmailDetails();
		details.setRecipientEmail(subscription.getCustomerEmail());
		details.setRefNumber(subscription.getCertificateNbr());
		details.setRecipientName(subscription.getCustomerName());
		details.setSubject("Congradulations !! Your KIA CCS subscription Renewed !!");
		CertificateGenerationDTO certificateDTO =  getCertificateDTO(subscription.getCertificateNbr());
		System.out.println(certificateDTO);
		Path certificateFile = Paths.get(pdfService.generatePdf(certificateDTO).getAbsolutePath());
		details.addAttachment("subscription_certificate.pdf", certificateFile.toFile());
		InvoiceGenerationDTO invoiceDTO = getInvoiceDTO(certificateDTO.getCertificateNumber());
		Path invoiceFile = Paths.get(pdfService.generateInvoice(invoiceDTO).getAbsolutePath());
		details.addAttachment("invoice.pdf",invoiceFile.toFile());
		emailService.sendEmail(details);
	}

	
	private String getNextSubscriptionNumber() {
		StringBuffer filter = new StringBuffer("CBC000");
		filter.append(helper.getDatePartofSubNbr());
		String result = subscriptionRepository.findNextNbr(filter.toString());
		int nextVal = 1;
		if (result != null) {
			nextVal = Integer.parseInt(result) + 1;
		}
		return String.format("%04d", nextVal);
	}
}
