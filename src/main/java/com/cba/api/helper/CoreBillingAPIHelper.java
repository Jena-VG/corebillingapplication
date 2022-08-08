package com.cba.api.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.CustomerDTO;
import com.cba.api.dto.DealerDTO;
import com.cba.api.dto.EmployeeDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.dto.PackageTypeDTO;
import com.cba.api.dto.SubscriptionDTO;
import com.cba.api.dto.VehicleDetailsDTO;
import com.cba.api.utils.DateUtils;
import com.cba.entity.Customer;
import com.cba.entity.Dealer;
import com.cba.entity.Employee;
import com.cba.entity.PackageType;
import com.cba.entity.SAPInterface;
import com.cba.entity.Subscription;
import com.cba.entity.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Helper DP to convert DTO to Entity and vice versa.
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

public class CoreBillingAPIHelper {

	Date date = DateUtils.getCurrentdate();

	/**
	 * This method is used to convert the customer details to a user entity for
	 * creating an user for the given customer
	 * 
	 * @param customerinfo - refer {@link com.cba.api.dto.CustomerDTO}
	 * @return Users User Entity that is required to be persisted
	 */
	public Users getUserEntity(CustomerDTO customerinfo) {
		Users user = new Users();
		user.setUserType("CUSTOMER");
		user.setUserName(customerinfo.getName());
		user.setEmail(customerinfo.getEmail());
		user.setMobile(customerinfo.getMobile());
		return user;
	}

	/**
	 * Helper method to convert the Customer DTO to customer Entity
	 * 
	 * @param customerinfo - refer {@link com.cba.api.dto.CustomerDTO}
	 * @return Customer - Converted Customer Entity
	 */
	public Customer getCustomerEntity(CustomerDTO customerinfo) {
		Customer customer = new Customer();

		customerinfo.setCreatedDate(date);
		customerinfo.setUpdatedDate(date);
		customer.setCustomerNbr(customerinfo.getCustomerNbr());
		customer.setAddressLine1(customerinfo.getAddressLine1());
		customer.setAddressLine2(customerinfo.getAddressLine2());

		customer.setCity(customerinfo.getCity());
		customer.setPincode(customerinfo.getPincode());
		customer.setState(customerinfo.getState());
		customer.setSacCode(customerinfo.getSacCode());
		customer.setGstNbr(customerinfo.getGstNbr());
		customer.setCreatedDate(customerinfo.getCreatedDate());

		return customer;
	}

	/**
	 * Helper method to convert the Employee DTO to User Entity
	 * 
	 * @param customerinfo - refer {@link com.cba.api.dto.EmployeeDTO}
	 * @return User - User Entity
	 */
	public Users getUserEmployeeEntity(EmployeeDTO empinfo) {
		Users user = new Users();
		user.setUserType("EMPLOYEE");
		user.setUserName(empinfo.getEmpNbr());
		user.setCreatedDate(date);

		return user;

	}

	/**
	 * Helper method to convert Dealer DTO to Entity
	 * 
	 * @param dealerinfo {@link com.cba.dto.DealerDTO}
	 * @return Dealer - Dealer Entity
	 */
	public Dealer getDealerEntity(DealerDTO dealerinfo) {

		Dealer dealer = new Dealer();
		dealerinfo.setCreatedDate(date);
		dealerinfo.setUpdatedDate(date);
		dealer.setDealerNbr(dealerinfo.getDealerNbr());
		dealer.setDealerName(dealerinfo.getDealerName());
		dealer.setAddressLine1(dealerinfo.getAddressLine1());
		dealer.setAddressLine2(dealerinfo.getAddressline2());
		dealer.setCity(dealerinfo.getCity());
		dealer.setEmail(dealerinfo.getEmail());
		dealer.setDealerGstNbr(dealerinfo.getDealerGstNbr());
		dealer.setCreatedDate(dealerinfo.getCreatedDate());
		return dealer;
	}

	/**
	 * Helper method to convert the Employee DTO to Employee Entity
	 * 
	 * @param empinfo - Refer {@link com.cba.dto.EmployeeDTO}
	 * @return employee - Employee Entity
	 */
	public Employee getEmployeeEntity(EmployeeDTO empinfo) {
		Employee employee = new Employee();
		empinfo.setCreatedDate(date);
		empinfo.setUpdatedDate(date);

		employee.setDeptId(empinfo.getDeptId());
		employee.setEmpNbr(empinfo.getEmpNbr());
		employee.setDesignation(empinfo.getDesignation());
		employee.setCreatedDate(empinfo.getCreatedDate());

		return employee;
	}

	/**
	 * Helper method to convert the Subscription DTO to Subscrtiption Entity
	 * 
	 * @param subscriptioninfo - Refer {@link com.cba.dto.SubscriptionDTO}
	 * @return Subscription - Subscription Entity
	 */
	public Subscription getSubscriptionEntity(SubscriptionDTO subscriptioninfo) {

		Subscription subscription = new Subscription();
		subscriptioninfo.setCreatedDate(date);
		subscription.setVinNbr(subscriptioninfo.getVinNbr());
		subscription.setSubscriptionNbr(subscriptioninfo.getSubscriptionNbr());
		subscription.setCertificateNbr(subscriptioninfo.getCertificateNbr());
		subscription.setDeptName(subscriptioninfo.getDeptName());
		subscription.setProgramType(subscriptioninfo.getProgramType());
		subscription.setModelName(subscriptioninfo.getModelName());
		subscription.setFuelType(subscriptioninfo.getFuelType());
		subscription.setVariantName(subscriptioninfo.getVariantName());
		subscription.setVehicleSoldDate(subscriptioninfo.getVehicleSoldDate());
		subscription.setRegNbr(subscriptioninfo.getRegNbr());
		subscription.setRegDate(subscriptioninfo.getRegDate());
		subscription.setOdometerReading(subscriptioninfo.getOdometerReading());
		subscription.setActivationFromDate(subscriptioninfo.getActivationFromDate());
		subscription.setActivationToDate(subscriptioninfo.getActivationToDate());
		subscription.setIrnNbr(subscriptioninfo.getIrnNbr());
		subscription.setQrCode(subscriptioninfo.getQrCode());
		subscription.setPkgPrice(subscriptioninfo.getPkgPrice());
		subscription.setIgst(subscriptioninfo.getIgst());
		subscription.setCgst(subscriptioninfo.getCgst());
		subscription.setSgst(subscriptioninfo.getSgst());
		subscription.setDiscountAmount(subscriptioninfo.getDiscountAmount());
		subscription.setTotalAmount(subscriptioninfo.getTotalAmount());
		subscription.setPymtTransNbr(subscriptioninfo.getPymtTransNbr());
		subscription.setPymtTransDate(subscriptioninfo.getPymtTransDate());
		subscription.setPaidAmount(subscriptioninfo.getPaidAmount());
		subscription.setPymtStatus(subscriptioninfo.getPymtStatus());
		subscription.setInvNbr(subscriptioninfo.getInvNbr());
		subscription.setInvGeneratedOn(subscriptioninfo.getInvGeneratedOn());
		subscription.setCreatedDate(subscriptioninfo.getCreatedDate());
		subscription.setRsaAmount(subscriptioninfo.getRsaAmount());

		return subscription;
	}

	public PackageType getPackageEntity(PackageTypeDTO packageTypeDTO) {
		PackageType packageType = new PackageType();
		System.out.println("date : " + date);
		packageType.setCreatedBy(packageTypeDTO.getCreatedBy());
		packageType.setCreatedDate(date);
		packageType.setDuration(packageTypeDTO.getDuration());
		packageType.setIsActive(packageTypeDTO.getIsActive());
		packageType.setPkgCode(packageTypeDTO.getPkgCode());
		packageType.setPkgDesc(packageTypeDTO.getPkgDesc());
		packageType.setPkgPrice(packageTypeDTO.getPkgPrice());
		// packageType.setPkgTypeId(packageTypeDTO.getPkgTypeId());
		packageType.setRsaPrice(packageTypeDTO.getRsaPrice());
		packageType.setUpdatedBy(packageTypeDTO.getUpdatedBy());
		packageType.setUpdatedDate(packageTypeDTO.getUpdatedDate());

		return packageType;

	}

	/**
	 * Helper method to convert the incoming map values to equivalent POJO
	 * 
	 * @param data
	 * @return
	 */
	public CertificateGenerationDTO getCertificateDTO(List<Map<String, Object>> data) {
		CertificateGenerationDTO certificateDTO = new CertificateGenerationDTO();
		if (data != null && data.size() == 0) {
			Map<String, Object> result = data.get(0);
			ObjectMapper mapper = new ObjectMapper();
			certificateDTO = mapper.convertValue(result, CertificateGenerationDTO.class);

		}
		return certificateDTO;
	}

	/**
	 * Helper method to convert the incoming map values to equivalent POJO
	 * 
	 * @param data
	 * @return
	 */
	public InvoiceGenerationDTO getInvoiceDTO(List<Map<String, Object>> data) {
		InvoiceGenerationDTO invoiceDTO = new InvoiceGenerationDTO();
		if (data != null && data.size() == 0) {
			Map<String, Object> result = data.get(0);
			ObjectMapper mapper = new ObjectMapper();
			invoiceDTO = mapper.convertValue(result, InvoiceGenerationDTO.class);

		}
		return invoiceDTO;
	}

	/**
	 * 
	 * @param subscription
	 * @return
	 */
	public SubscriptionDTO toSubscriptionDTO(Subscription subscription) {
		SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
		subscriptionDTO.setCertificateNbr(subscription.getCertificateNbr());
		subscriptionDTO.setActivationFromDate(subscription.getActivationFromDate());
		subscriptionDTO.setActivationToDate(subscription.getActivationToDate());
		subscriptionDTO.setCgst(subscription.getCgst());
		subscriptionDTO.setCustomerId(subscription.getCustomerId());
		subscriptionDTO.setDealerId(subscription.getDealerId());
		subscriptionDTO.setDeptName(subscription.getDeptName());
		subscriptionDTO.setDiscountAmount(subscription.getDiscountAmount());
		if (subscription.getEmpId() != null) {
			subscriptionDTO.setEmpId(subscription.getEmpId());
		}
		subscriptionDTO.setFuelType(subscription.getFuelType());
		subscriptionDTO.setIgst(subscription.getIgst());
		subscriptionDTO.setInvGeneratedOn(subscription.getInvGeneratedOn());
		subscriptionDTO.setInvNbr(subscription.getInvNbr());
		subscriptionDTO.setIrnNbr(subscription.getIrnNbr());
		subscriptionDTO.setModelName(subscription.getModelName());
		subscriptionDTO.setOdometerReading(subscription.getOdometerReading());
		subscriptionDTO.setPaidAmount(subscription.getPaidAmount());
		subscriptionDTO.setPaidAmount(subscription.getPaidAmount());
		subscriptionDTO.setProgramType(subscription.getProgramType());
		subscriptionDTO.setPymtStatus(subscription.getPymtStatus());
		subscriptionDTO.setPymtTransDate(subscription.getPymtTransDate());
		subscriptionDTO.setQrCode(subscription.getQrCode());
		subscriptionDTO.setRegDate(subscription.getRegDate());
		subscriptionDTO.setRegNbr(subscription.getRegNbr());
		subscriptionDTO.setRsaAmount(subscription.getRsaAmount());
		subscriptionDTO.setSgst(subscription.getSgst());
		subscriptionDTO.setSubscriptionId(subscription.getSubscriptionId());
		subscriptionDTO.setSubscriptionNbr(subscription.getSubscriptionNbr());
		subscriptionDTO.setTotalAmount(subscription.getTotalAmount());
		subscriptionDTO.setVariantName(subscription.getVariantName());
		subscriptionDTO.setVehicleSoldDate(subscription.getVehicleSoldDate());
		subscriptionDTO.setVinNbr(subscription.getVinNbr());
		return subscriptionDTO;
	}

	/**
	 * 
	 * @param customerinfo
	 * @return
	 */
	public CustomerDTO toCustomerDTO(Customer customerinfo) {
		CustomerDTO customer = new CustomerDTO();

		customerinfo.setCreatedDate(customerinfo.getCreatedDate());
		customerinfo.setUpdatedDate(customerinfo.getUpdatedDate());
		customer.setCustomerNbr(customerinfo.getCustomerNbr());
		customer.setAddressLine1(customerinfo.getAddressLine1());
		customer.setAddressLine2(customerinfo.getAddressLine2());

		customer.setCity(customerinfo.getCity());
		customer.setPincode(customerinfo.getPincode());
		customer.setState(customerinfo.getState());
		customer.setSacCode(customerinfo.getSacCode());
		customer.setGstNbr(customerinfo.getGstNbr());
		customer.setCreatedDate(customerinfo.getCreatedDate());
		customer.setCustomerId(customerinfo.getCustomerId());

		return customer;
	}

	/**
	 * 
	 * @param customerDTO
	 * @param packageType
	 * @return
	 */
	public Subscription toSubscriptionEntity(CustomerDTO customerDTO, PackageType packageType, String nextVal) {
		Subscription subscription = new Subscription();
		VehicleDetailsDTO vehicle = customerDTO.getVehicleDetails();
		subscription.setPkgTypeId(packageType.getPkgTypeId());
		subscription.setVinNbr(vehicle.getVinNumber());

		StringBuffer subNbr = new StringBuffer();
		subNbr.append("CBC000");
		subNbr.append(getDatePartofSubNbr());
		subNbr.append(nextVal);
		System.out.println("**********" + subNbr.toString());
		subscription.setSubscriptionNbr(subNbr.toString());
		subscription.setCertificateNbr(subNbr.toString());
		subscription.setCustomerId(customerDTO.getCustomerId());
		subscription.setProgramType(packageType.getPkgDesc());
		subscription.setModelName(vehicle.getModelName());
		subscription.setFuelType(vehicle.getFuelType());
		subscription.setVariantName(vehicle.getVariantName());
		subscription.setVehicleSoldDate(vehicle.getVehicleSoldDate());
		subscription.setRegNbr(vehicle.getRegNumber());
		subscription.setRegDate(vehicle.getVehicleSoldDate());
		subscription.setOdometerReading(vehicle.getOdometerReading());
		subscription.setActivationFromDate(new Date());
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, packageType.getDuration());
		subscription.setActivationToDate(cal.getTime());
		subscription.setPkgPrice(packageType.getPkgPrice());
		subscription.setIgst(Math.round(packageType.getPkgPrice() * 0.18));
		subscription.setCgst(Math.round(packageType.getPkgPrice() * 0.09));
		subscription.setSgst(Math.round(packageType.getPkgPrice() * 0.09));

		subscription.setRsaAmount(packageType.getRsaPrice());
		subscription.setRsaigst(Math.round(packageType.getRsaPrice() * 0.18));
		subscription.setRsacgst(Math.round(packageType.getRsaPrice() * 0.09));
		subscription.setRsasgst(Math.round(packageType.getRsaPrice() * 0.09));
		subscription.setDiscountAmount(0);

		if ("AP".equals(customerDTO.getSacCode())) {
			subscription.setIgst(0);
			subscription.setRsaigst(0);
		} else {

			subscription.setCgst(0);
			subscription.setSgst(0);
			subscription.setRsacgst(0);
			subscription.setRsasgst(0);
		}
		double totalAmount = subscription.getPkgPrice() + subscription.getIgst() + subscription.getCgst()
				+ subscription.getSgst() + subscription.getRsaAmount() + subscription.getRsaigst()
				+ subscription.getRsacgst() + subscription.getRsasgst();
		subscription.setTotalAmount(totalAmount);
		// payment trans amount
		// payment tran dt
		// payment amount
		// payment status

		// inv nbr
		subscription.setInvGeneratedOn(new Date());
		subscription.setCreatedDate(new Date());
		subscription.setSource("Mobile App");
		// created by
		return subscription;
	}

	public String getDatePartofSubNbr() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		StringBuffer sBuff = new StringBuffer();
		sBuff.append(year % 100).append(String.format("%02d", month + 1)).append(weekOfYear);
		return sBuff.toString();
	}

	public SAPInterface getSapInterface(Subscription subscription, CustomerDTO customerDTO) {
		SAPInterface sapInterface = new SAPInterface();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		sapInterface.setZinvNo(subscription.getSubscriptionNbr());
		sapInterface.setZinvDt(simpleDateFormat.format(DateUtils.getCurrentdate()));
		sapInterface.setCertNo(subscription.getCertificateNbr());
		sapInterface.setRegCan("CS");
		sapInterface.setVinNo(subscription.getVinNbr());
		sapInterface.setCspRwo(subscription.getPkgPrice());

		sapInterface.setZcustVehRegNo(customerDTO.getVehicleDetails().getRegNumber());
		sapInterface.setCspRwo(subscription.getPkgPrice());
		sapInterface.setCspRw(subscription.getTotalAmount());

		sapInterface.setZpcGst(subscription.getCgst());
		sapInterface.setZpsGst(subscription.getSgst());
		sapInterface.setZpiGst(subscription.getIgst());

		sapInterface.setZsac("998729");
		sapInterface.setTaxCode("WSALE");
		sapInterface.setRctRdt(simpleDateFormat.format(DateUtils.getCurrentdate()));
		SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("HHMMSS");
		// sapInterface.setRctrTm(simpleTimeFormat.format(DateUtils.getCurrentdate()));
		sapInterface.setRctFlg("N");
		sapInterface.setRctMsg("SUCCESS");

		sapInterface.setIrnNo(subscription.getIrnNbr());
		sapInterface.setAckTn(subscription.getAckNbr());
		sapInterface.setAckDt(subscription.getAckDt());
		sapInterface.setRsaSgst(subscription.getRsasgst());
		sapInterface.setRsaIgst(subscription.getRsaigst());
		sapInterface.setRsaCgst(subscription.getRsacgst());
		sapInterface.setCcsRsaAmt(subscription.getRsaAmount());
		sapInterface.setCustGstin(customerDTO.getGstNbr());
		sapInterface.setZname1(customerDTO.getName());
		sapInterface.setZaddr(customerDTO.getAddressLine1() + customerDTO.getAddressLine2());
		sapInterface.setZpostCd(customerDTO.getPincode());
		sapInterface.setZdesc1(subscription.getProgramType());
		sapInterface.setZsez(customerDTO.getIsSez());

		sapInterface.setCity(customerDTO.getCity());
		sapInterface.setPlcSup(customerDTO.getCityCode());

		sapInterface.setRctNo(subscription.getPymtTransNbr());
		if (subscription.getPymtTransDate() != null) {
			sapInterface.setRctDt(simpleDateFormat.format(subscription.getPymtTransDate()));
			sapInterface.setRctTm(simpleTimeFormat.format(subscription.getPymtTransDate()));
		}
		// TODO Set payment receipt type and UTR no

		return sapInterface;
	}

}
