package com.cba.api.services.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cba.api.repository.AuditLogRepository;
import com.cba.api.services.ConnectCarServices;
import com.cba.entity.AuditLog;

/*
 * Refer {@link com.cba.api.services.ConnectCarServices}
 *
 * @author manikandan.rajendran
 * @version 1.0
 * @since 2022-06-17
 */

@Service
public class ConnectCarServicesImpl implements ConnectCarServices {

	@Value("${spring.api.vinvalidationurl}")
	private String vinValidationPath;

	@Value("${spring.api.expiredateurl}")
	private String expiredatePath;

	@Value("${spring.api.updateexpiredateurl}")
	private String updateexpiredateurl;
	
	@Autowired
	AuditLogRepository auditLogRepository; 
	

	/**
	 * {@link com.cba.api.services.ConnectCarServices.validateVINNumber}
	 * 
	 */
	@Override
	public ResponseEntity<String> validateVINNumber(String vinNum) throws Exception{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("VIN", vinNum);
		headers.set("BRAND", "K");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		AuditLog auditLog=createAuditLog(headers, vinValidationPath,"/corebilling/api/vinvalidation");
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = restTemplate.exchange(vinValidationPath, HttpMethod.GET, entity,
					String.class);
			updateAuditLog(responseEntity,auditLog);
		}catch(Exception ex) {
			updateAuditLogForException(  ex  , auditLog);
		}finally {
			auditLogRepository.save(auditLog);	
		}
		
		return responseEntity;

	}

	/**
	 * {@link com.cba.api.services.ConnectCarServices.updateSubscriptionDate}
	 * 
	 */
	@Override
	public String updateSubscriptionDate(String vinNum, int duartion) throws Exception{

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("VIN", vinNum);
		headers.set("BRAND", "K");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		ResponseEntity<String> responseEntity = null;
		AuditLog auditLog=createAuditLog(headers, expiredatePath,"/corebilling/api/expiredate");
		try {
			responseEntity = restTemplate.exchange(expiredatePath, HttpMethod.GET, entity,
					String.class);
			
			updateAuditLog(responseEntity, auditLog);
			String expiredDate = "";
			if (responseEntity.getStatusCodeValue() == 200) {
				String chk = responseEntity.getBody();
				JSONObject json = new JSONObject(chk);
				expiredDate = json.getString("expireDt");
				updateSubscriptionDate(expiredDate, vinNum, duartion);
				
				
			}
		} catch (Exception ex) {
			updateAuditLogForException(  ex  , auditLog);
		}finally {
			auditLogRepository.save(auditLog);
		}
		
		return "success";

	}

	/**
	 * Overloaded method to update the subscription date
	 * 
	 * @param expiryDate
	 * @param vinNum
	 * @param duartion
	 * @return
	 */
	private String updateSubscriptionDate(String expiryDate, String vinNum, int duartion) throws Exception{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate newexpiredDate = LocalDate.parse(expiryDate, formatter);
		LocalDate currentDate = LocalDate.now();

		if (newexpiredDate.isAfter(currentDate)) {
			newexpiredDate = newexpiredDate.plusDays(duartion);
		}

		if (newexpiredDate.isBefore(currentDate)) {
			newexpiredDate = currentDate.plusDays(duartion);

		}

		String newExpireDateFormatted = newexpiredDate.format(formatter);

		// post call to save the data

		JSONObject obj = new JSONObject();
		obj.put("expireDt", newExpireDateFormatted);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("VIN", vinNum);
		headers.set("BRAND", "K");
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> request = new HttpEntity<String>(obj.toString(), headers);
		AuditLog auditLog=createAuditLog(headers, updateexpiredateurl,"/corebilling/api/updateexpiredate");
		ResponseEntity<String> personResultAsJsonStr =null;
		try {
			personResultAsJsonStr = restTemplate.postForEntity(updateexpiredateurl, request,
					String.class);
			
			updateAuditLog(personResultAsJsonStr, auditLog);	
		}catch(Exception ex) {
			updateAuditLogForException(  ex  , auditLog);
		}finally {
			auditLogRepository.save(auditLog);	
		}
		
		return "success";

	}
	
	private AuditLog createAuditLog(HttpHeaders headers,String path, String requestFrom) {
		AuditLog auditLog=new AuditLog();
		Timestamp beforecall=new Timestamp(System.currentTimeMillis());
		auditLog.setRequestedOn(beforecall);
		auditLog.setDestrequestOn(beforecall);
		auditLog.setRequestedFrom(requestFrom);
		auditLog.setRequestedParameter(headers.toString());
		auditLog.setDestinationApi(path);
		auditLog.setCreatedDate(beforecall);
		auditLog.setCreatedBy(1);
		
		return auditLog;
		
	}
	
	private void updateAuditLog(ResponseEntity<String> response,AuditLog auditLog) {
		Timestamp aftercall=new Timestamp(System.currentTimeMillis());
		//auditLog.setRespErrorMsg(response.getBody()==null?"":response.getBody().toString());
		auditLog.setResponseOn(aftercall);
		auditLog.setResponseStatus(response.getStatusCode().toString());
		auditLog.setResponseParameter(response.getHeaders().toString());
	}
	
	private void updateAuditLogForException(Exception e,AuditLog auditLog) {
		Timestamp exceptioncall=new Timestamp(System.currentTimeMillis());
		//auditLog.setRespErrorMsg(e.getMessage());
		auditLog.setResponseOn(exceptioncall);
		auditLog.setResponseStatus(e.getMessage());
	}

}
