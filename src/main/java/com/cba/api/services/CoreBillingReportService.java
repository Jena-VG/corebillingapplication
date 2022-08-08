package com.cba.api.services;

import java.util.List;

import com.cba.api.dto.ReportResultDTO;
import com.cba.api.dto.ReportSearchCriteriaDTO;

public interface CoreBillingReportService {

	
	public List<ReportResultDTO> getSubscriptionRenewalReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO) throws Exception;

    public List<ReportResultDTO> getTotalCollectionsReport(ReportSearchCriteriaDTO reportSearchCriteriaDTO) throws Exception;
}
