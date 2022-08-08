package com.cba.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cba.api.dto.ReportResultDTO;
import com.cba.api.dto.ReportSearchCriteriaDTO;
import com.cba.api.repository.GenericQueryRepository;
import com.cba.api.services.CoreBillingReportService;

@Transactional
@Service
public class CoreBillingReportServiceImpl implements CoreBillingReportService{

	@Autowired
	GenericQueryRepository query;
	
	@Override
	public List<ReportResultDTO> getSubscriptionRenewalReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO)
			throws Exception {
		  return query.getSubscriptionRenewalReport(reportSearchCriteriaDTO);
	}

	@Override
	public List<ReportResultDTO> getTotalCollectionsReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO)
			throws Exception {
		return query.getTotalCollectionsReport(reportSearchCriteriaDTO);
	}

	
}
