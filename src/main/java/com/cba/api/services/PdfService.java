package com.cba.api.services;

import java.io.File;
import java.io.IOException;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.lowagie.text.DocumentException;

public interface PdfService {

	/**
	 * Service to generate the CCS Certificate as PDF
	 * 
	 * @param details - Input JSON parameters
	 * @return - Generated PDF
	 * @throws IOException
	 * @throws DocumentException
	 */
	public File generatePdf(CertificateGenerationDTO details) throws IOException, DocumentException;

	/**
	 * Service to generate the Invoice as PDF
	 * 
	 * @param invoiceDTO - Input JSON parameters
	 * @return - Generated PDF
	 * @throws IOException
	 * @throws DocumentException
	 */
	public File generateInvoice(InvoiceGenerationDTO invoiceDTO) throws IOException, DocumentException;

}
