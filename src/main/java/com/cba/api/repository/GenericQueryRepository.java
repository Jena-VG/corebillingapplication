package com.cba.api.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.dto.ReportResultDTO;
import com.cba.api.dto.ReportSearchCriteriaDTO;


@Component
public class GenericQueryRepository extends JdbcDaoSupport {

	
	private String CERTIFICATE_SQL = "select  " + "  sub.certificate_nbr as certificateNumber, "
			+ "  sub.vin_nbr as vinNumber, " + "  users.user_name as customerName, " + "  sub.model_name as modelName, "
			+ "  to_char(sub.activation_to_date, 'dd/MM/yyyy') as packageEndDate, "
			+ "  to_char(sub.activation_from_date, 'dd/MM/yyyy') as subscriptionPurchaseDate , " + "  packType.pkg_desc as packageType "
			+ "  from  "
			+ "  ccs_subscriptions as sub left outer join ccs_customer as cust on (cust.customer_id = sub.customer_id)"
			+ "  left outer join ccs_dealer as dealer on (dealer.dealer_id = sub.dealer_id) "
			+ "  left outer join ccs_users as users on (users.user_id = cust.customer_id) "
			+ "  left outer join ccs_package_type as packType on (packType.pkg_type_id = sub.pkg_type_id) "
			+ "  where sub.certificate_nbr = ':certificateNbr'";
	
	private String INVOICE_SQL =  "select "
    		+ "  sub.certificate_nbr as invoiceNo,"
    		+ "  sub.vin_nbr as vinNumber,"
    		+ "  to_char(sub.inv_generated_on, 'dd/MM/yyyy') as invoiceDate,"
    		+ "  cust.customer_nbr as customerNumber,"
    		+ "  users.user_name as customerName,"
    		+ "  cust.address_line_1 || cust.address_line_2 || cust.city || cust.state || cust.pincode as  customerAddress,"
    		+ "  cust.gst_nbr as customerGst,"
    		+ "  sub.model_name as modelName,"
    		+ "  to_char(sub.activation_to_date, 'dd/MM/yyyy') as packageEndDate,"
    		+ "  dealer.dealer_nbr as dealerCode,"
    		+ "  to_char(sub.activation_from_date, 'dd/MM/yyyy') as subscriptionPurchaseDate ,"
    		+ "  packType.pkg_desc as packageDesc,"
    		+ "  dealer.dealer_nbr as dlrNo,"
    		+ "  sub.pkg_price as packPrice,"
    		+ "  sub.rsa_amount as rsaAmount,"
    		+ "  sub.sgst as sgst,"
    		+ "  sub.igst as igst,"
    		+ "  sub.cgst as cgst,"
    		+ "  sub.rsaIgst as rsaIgst,"
    		+ "  sub.rsasgst as rsaSgst,"
    		+ "  sub.rsacgst as rsaCgst,"
    		+ "  sub.total_amount as netValue,"
    		+ "  sub.qr_code as qrCode,"
    		+ "  sub.irn_nbr as irnNo"
    		+ " from "
    		+ " ccs_subscriptions as sub left outer join ccs_customer as cust on (cust.customer_id = sub.customer_id)"
    		+ " left outer join ccs_dealer as dealer on (dealer.dealer_id = sub.dealer_id)"
    		+ " left outer join ccs_users as users on (users.user_id = cust.customer_id)"
    		+ " left outer join ccs_package_type as packType on (packType.pkg_type_id = sub.pkg_type_id)"
    		+ " where sub.certificate_nbr  = ':certificateNbr' ";
	
	
	private String SUBSCRIPTION_RENEWAL_REPORT =  "select "
            + "  sub.certificate_nbr as invoiceNo,"
            + "  sub.vin_nbr as vinNumber,"
            + "  to_char(sub.inv_generated_on, 'dd/MM/yyyy') as invoiceDate,"
            + "  cust.customer_nbr as customerNumber,"
            + "  users.user_name as customerName,"
            + "  cust.address_line_1 || cust.address_line_2 || cust.city || cust.state || cust.pincode as  customerAddress,"
            + "  cust.gst_nbr as customerGst,"
            + "  sub.model_name as modelName,"
            + "  to_char(sub.activation_to_date, 'dd/MM/yyyy') as packageEndDate,"
            + "  dealer.dealer_nbr as dealerCode,"
            + "  to_char(sub.activation_from_date, 'dd/MM/yyyy') as subscriptionPurchaseDate ,"
            + "  packType.pkg_desc as packageDesc,"
            + "  dealer.dealer_nbr as dlrNo,"
            + "  sub.pkg_price as packPrice,"
            + "  sub.rsa_amount as rsaAmount,"
            + "  sub.sgst as sgst,"
            + "  sub.igst as igst,"
            + "  sub.cgst as cgst,"
            + "  sub.rsaIgst as rsaIgst,"
            + "  sub.rsasgst as rsaSgst,"
            + "  sub.rsacgst as rsaCgst,"
            + "  sub.total_amount as netValue,"
            + "  sub.qr_code as qrCode,"
            + "  sub.irn_nbr as irnNo"
            + " from "
            + " ccs_subscriptions as sub left outer join ccs_customer as cust on (cust.customer_id = sub.customer_id)"
            + " left outer join ccs_dealer as dealer on (dealer.dealer_id = sub.dealer_id)"
            + " left outer join ccs_users as users on (users.user_id = cust.customer_id)"
            + " left outer join ccs_package_type as packType on (packType.pkg_type_id = sub.pkg_type_id)"
            + " where 1 = 1 "
            + " :dynamicWhereClause ";
	
	
	 private String TOTAL_COLLECTION_REPORT = "select "
	            + "  sub.certificate_nbr as invoiceNo,"
	            + "  sub.vin_nbr as vinNumber,"
	            + "  to_char(sub.inv_generated_on, 'dd/MM/yyyy') as invoiceDate,"
	            + "  cust.customer_nbr as customerNumber,"
	            + "  users.user_name as customerName,"
	            + "  cust.address_line_1 || cust.address_line_2 || cust.city || cust.state || cust.pincode as  customerAddress,"
	            + "  cust.gst_nbr as customerGst,"
	            + "  sub.model_name as modelName,"
	            + "  to_char(sub.activation_to_date, 'dd/MM/yyyy') as packageEndDate,"
	            + "  dealer.dealer_nbr as dealerCode,"
	            + "  to_char(sub.activation_from_date, 'dd/MM/yyyy') as subscriptionPurchaseDate ,"
	            + "  packType.pkg_desc as packageDesc,"
	            + "  dealer.dealer_nbr as dlrNo,"
	            + "  sub.pkg_price as packPrice,"
	            + "  sub.rsa_amount as rsaAmount,"
	            + "  sub.sgst as sgst,"
	            + "  sub.igst as igst,"
	            + "  sub.cgst as cgst,"
	            + "  sub.rsaIgst as rsaIgst,"
	            + "  sub.rsasgst as rsaSgst,"
	            + "  sub.rsacgst as rsaCgst,"
	            + "  sub.total_amount as netValue,"
	            + "  sub.qr_code as qrCode,"
	            + "  sub.irn_nbr as irnNo"
	            + " from "
	            + " ccs_subscriptions as sub left outer join ccs_customer as cust on (cust.customer_id = sub.customer_id)"
	            + " left outer join ccs_dealer as dealer on (dealer.dealer_id = sub.dealer_id)"
	            + " left outer join ccs_users as users on (users.user_id = cust.customer_id)"
	            + " left outer join ccs_package_type as packType on (packType.pkg_type_id = sub.pkg_type_id)"
	            + " where 1 = 1 "
	            + " :dynamicWhereClause ";

	@Autowired
	public GenericQueryRepository(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<CertificateGenerationDTO> getCertificateDetails(String certificateNbr) {

		CERTIFICATE_SQL = CERTIFICATE_SQL.replaceAll(":certificateNbr", certificateNbr);
		return getJdbcTemplate().query(CERTIFICATE_SQL, new CertificateRowMapper());
	}
	
	private static class CertificateRowMapper implements RowMapper<CertificateGenerationDTO> {
 
		public CertificateGenerationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

			CertificateGenerationDTO certificate = new CertificateGenerationDTO();
			certificate.setCertificateNumber(rs.getString("certificateNumber"));
			certificate.setVinNumber(rs.getString("vinNumber"));
			//certificate.setModelCode(rs.getString("modelCode"));
			//certificate.setCustomerNumber(rs.getString("customerNumber"));
			certificate.setCustomerName(rs.getString("customerName"));
			certificate.setModelName(rs.getString("modelName"));
			certificate.setPackageEndDate(rs.getString("packageEndDate"));
			//certificate.setDealerCode(rs.getString("dealerCode"));
			certificate.setSubscriptionPurchaseDate(rs.getString("subscriptionPurchaseDate"));
			certificate.setPackageType(rs.getString("packageType"));
			return certificate;
		}
	}
	
	
	public List<InvoiceGenerationDTO> getInvoiceDetails(String certificateNbr) {

		INVOICE_SQL = INVOICE_SQL.replaceAll(":certificateNbr", certificateNbr);
		return getJdbcTemplate().query(INVOICE_SQL, new InvoiceRowMapper());
	}

	private static class InvoiceRowMapper implements RowMapper<InvoiceGenerationDTO> {

		public InvoiceGenerationDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			InvoiceGenerationDTO invoice = new InvoiceGenerationDTO();
			invoice.setInvoiceNo(rs.getString("invoiceNo"));
			invoice.setVinNo(rs.getString("vinNumber"));
			invoice.setInvoiceDate(rs.getString("invoiceDate"));
			invoice.setCustomerNumber(rs.getString("customerNumber"));
			invoice.setCustomerName(rs.getString("customerName"));
			invoice.setCustomerAddress(rs.getString("customerAddress"));
			invoice.setCustomerGst(rs.getString("customerGst"));
			invoice.setModelName(rs.getString("modelName"));
			invoice.setPackageEndDate(rs.getString("packageEndDate"));
			invoice.setDealerCode(rs.getString("dealerCode"));
			invoice.setSubscriptionPurchaseDate(rs.getString("subscriptionPurchaseDate"));
			invoice.setPackageDesc(rs.getString("packageDesc"));
			invoice.setDlrNo(rs.getString("dlrNo"));
			invoice.setPackPrice(rs.getBigDecimal("packPrice"));
			invoice.setRsaAmount(rs.getBigDecimal("rsaAmount"));
			invoice.setSgst(rs.getBigDecimal("sgst"));
			invoice.setIgst(rs.getBigDecimal("igst"));
			invoice.setCgst(rs.getBigDecimal("cgst"));
			invoice.setRsaIgst(rs.getBigDecimal("rsaIgst"));
			invoice.setRsaSgst(rs.getBigDecimal("rsaSgst"));
			invoice.setRsaCgst(rs.getBigDecimal("rsaCgst"));
			invoice.setNetValue(rs.getBigDecimal("netValue"));
			invoice.setQrCode(rs.getString("qrCode"));
			invoice.setIrnNo(rs.getString("irnNo"));
			return invoice;
		}
	}
	
	
	public List<ReportResultDTO> getSubscriptionRenewalReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO) {

		String whereClause = buildReportWhereClause(reportSearchCriteriaDTO);
		SUBSCRIPTION_RENEWAL_REPORT = SUBSCRIPTION_RENEWAL_REPORT.replace(":dynamicWhereClause", whereClause);
		return getJdbcTemplate().query(SUBSCRIPTION_RENEWAL_REPORT, new SubscriptionRenewalReportRowMapper());

	}

	    private static class SubscriptionRenewalReportRowMapper implements RowMapper<ReportResultDTO>{

	        @Override
	        public ReportResultDTO  mapRow(ResultSet rs, int rowNum) throws SQLException {
	            ReportResultDTO reportResultDTO = new ReportResultDTO();

	            reportResultDTO.setSubscriptionPurchaseDate(rs.getString("subscriptionPurchaseDate"));
                reportResultDTO.setVinNo(rs.getString("vinNumber"));
                reportResultDTO.setCertificateNbr(rs.getString("certificateNbr"));  
                reportResultDTO.setPkgTypeId(rs.getInt("pkgTypeId"));
                reportResultDTO.setPackageDesc(rs.getString("packageDesc"));
                reportResultDTO.setCustomerName(rs.getString("customerName"));
                reportResultDTO.setCustomerNumber(rs.getString("customerNbr"));
                reportResultDTO.setDealerCode(rs.getString("dealerCode"));
                reportResultDTO.setSource(rs.getString("source"));
                reportResultDTO.setModelName(rs.getString("modelName"));
                reportResultDTO.setSubscriptionNbr(rs.getString("subscriptionNbr"));
                reportResultDTO.setRegNbr(rs.getString("regNbr"));
                reportResultDTO.setPackageEndDate(rs.getString("packageEndDate"));
                reportResultDTO.setIsActive(rs.getString("isActive"));
                reportResultDTO.setEmployeeName(rs.getString("employeeName"));
                reportResultDTO.setDeptName(rs.getString("deptName"));
                reportResultDTO.setPackPrice(rs.getBigDecimal("packPrice"));
                reportResultDTO.setInvoiceDate(rs.getString("invoiceDate"));
                reportResultDTO.setInvoiceNo(rs.getString("invoiceNo"));
                reportResultDTO.setRsaAmount(rs.getBigDecimal("rsaAmount"));
                reportResultDTO.setSgst(rs.getBigDecimal("sgst"));
                reportResultDTO.setIgst(rs.getBigDecimal("igst"));
                reportResultDTO.setCgst(rs.getBigDecimal("cgst"));
                reportResultDTO.setRsaIgst(rs.getBigDecimal("rsaIgst"));
                reportResultDTO.setRsaSgst(rs.getBigDecimal("rsaSgst"));
                reportResultDTO.setRsaCgst(rs.getBigDecimal("rsaCgst"));
                reportResultDTO.setNetValue(rs.getBigDecimal("netValue"));
                
	            return reportResultDTO;
	        }

	    }

	   

	    public List<ReportResultDTO> getTotalCollectionsReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO) {

	    	String whereClause = buildReportWhereClause(reportSearchCriteriaDTO);
	    	TOTAL_COLLECTION_REPORT = TOTAL_COLLECTION_REPORT.replace(":dynamicWhereClause", whereClause);
	        return getJdbcTemplate().query(TOTAL_COLLECTION_REPORT,  new TotalRenewalReportMapper());
	    }

	    private static class TotalRenewalReportMapper implements RowMapper<ReportResultDTO>{

	        @Override
	        public ReportResultDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

	            ReportResultDTO reportResultDTO = new ReportResultDTO();
	            reportResultDTO.setSubscriptionPurchaseDate(rs.getString("subscriptionPurchaseDate"));
                reportResultDTO.setVinNo(rs.getString("vinNumber"));
                reportResultDTO.setCertificateNbr(rs.getString("certificateNbr"));  
                reportResultDTO.setPkgTypeId(rs.getInt("pkgTypeId"));
                reportResultDTO.setPackageDesc(rs.getString("packageDesc"));
                reportResultDTO.setCustomerName(rs.getString("customerName"));
                reportResultDTO.setCustomerNumber(rs.getString("customerNbr"));
                reportResultDTO.setDealerCode(rs.getString("dealerCode"));
                reportResultDTO.setSource(rs.getString("source"));
                reportResultDTO.setModelName(rs.getString("modelName"));
                reportResultDTO.setSubscriptionNbr(rs.getString("subscriptionNbr"));
                reportResultDTO.setRegNbr(rs.getString("regNbr"));
                reportResultDTO.setPackageEndDate(rs.getString("packageEndDate"));
                reportResultDTO.setIsActive(rs.getString("isActive"));
                reportResultDTO.setEmployeeName(rs.getString("employeeName"));
                reportResultDTO.setDeptName(rs.getString("deptName"));
                reportResultDTO.setPackPrice(rs.getBigDecimal("packPrice"));
                reportResultDTO.setInvoiceDate(rs.getString("invoiceDate"));
                reportResultDTO.setInvoiceNo(rs.getString("invoiceNo"));
                reportResultDTO.setRsaAmount(rs.getBigDecimal("rsaAmount"));
                reportResultDTO.setSgst(rs.getBigDecimal("sgst"));
                reportResultDTO.setIgst(rs.getBigDecimal("igst"));
                reportResultDTO.setCgst(rs.getBigDecimal("cgst"));
                reportResultDTO.setRsaIgst(rs.getBigDecimal("rsaIgst"));
                reportResultDTO.setRsaSgst(rs.getBigDecimal("rsaSgst"));
                reportResultDTO.setRsaCgst(rs.getBigDecimal("rsaCgst"));
                reportResultDTO.setNetValue(rs.getBigDecimal("netValue"));
	            return reportResultDTO;
	        }

	    }
	    
	    
		private String buildReportWhereClause(ReportSearchCriteriaDTO reportSearchCriteriaDTO) {

			StringBuffer dynamicWhereSQL = new StringBuffer();
			if (!isNull(reportSearchCriteriaDTO.getVinNbr())) {
				dynamicWhereSQL.append(" AND sub.vin_nbr ='" + reportSearchCriteriaDTO.getVinNbr() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getActivationToDate())) {
				dynamicWhereSQL.append(
						" AND sub.activation_to_date ='" + reportSearchCriteriaDTO.getActivationToDate() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getCertificateNbr())) {
				dynamicWhereSQL
						.append(" AND sub.certificate_nbr ='" + reportSearchCriteriaDTO.getCertificateNbr() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getCustomerName())) {
				dynamicWhereSQL.append(" AND users.user_name ='" + reportSearchCriteriaDTO.getCustomerName() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getCustomerNbr())) {
				dynamicWhereSQL.append(" AND cust.customer_nbr ='" + reportSearchCriteriaDTO.getCustomerNbr() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getDealerNbr())) {
				dynamicWhereSQL.append(" AND dealer.dealer_nbr ='" + reportSearchCriteriaDTO.getDealerNbr() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getSource())) {
				dynamicWhereSQL.append(" AND sub.source ='" + reportSearchCriteriaDTO.getSource() + "' ");
			}
			if (reportSearchCriteriaDTO.getPkgTypeId() != null
					&& reportSearchCriteriaDTO.getPkgTypeId().intValue() > 0) {
				dynamicWhereSQL.append(" AND sub.pkg_type_id= " + reportSearchCriteriaDTO.getPkgTypeId());
			}
			if (!isNull(reportSearchCriteriaDTO.getCity())) {
				dynamicWhereSQL.append(" AND cust.city ='" + reportSearchCriteriaDTO.getCity() + "' ");
			}
			if (!isNull(reportSearchCriteriaDTO.getState())) {
				dynamicWhereSQL.append(" AND cust.state ='" + reportSearchCriteriaDTO.getState() + "' ");
			}

			return dynamicWhereSQL.toString();
		}
	    
	    private boolean isNull(String data) {
	    	
	    	boolean result = true;
	    	if(data != null && data.trim().length() >0) {
	    		result = false;
	    	}
	    	return result;
	    }
}
