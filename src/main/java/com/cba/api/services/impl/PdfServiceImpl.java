package com.cba.api.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.cba.api.dto.CertificateGenerationDTO;
import com.cba.api.dto.InvoiceGenerationDTO;
import com.cba.api.services.PdfService;
import com.lowagie.text.DocumentException;

@Transactional
@Service
public class PdfServiceImpl implements PdfService {

	private static final String PDF_RESOURCES = "/pdf_resources/";
	
	@Autowired
	private SpringTemplateEngine templateEngine;

	
	public PdfServiceImpl(SpringTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}

	@Override
	public File generatePdf(CertificateGenerationDTO details) throws IOException, DocumentException {
		Context context = getContext(details);
		String html = loadAndFillTemplate(context);
		System.out.println("Load Templates");
		return renderPdf(html);
	}

	private File renderPdf(String html) throws IOException, DocumentException {
		File file = File.createTempFile("subscriptioncertificate", ".pdf");
		OutputStream outputStream = new FileOutputStream(file);
		ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
		renderer.setDocumentFromString(html);
		renderer.layout();
		System.out.println("Reder in IMPL");
		renderer.createPDF(outputStream);
		outputStream.close();
		file.deleteOnExit();
		return file;
	}

	private Context getContext(CertificateGenerationDTO details) {
		Context context = new Context();
		context.setVariable("certificate", details);
		return context;
	}

	private String loadAndFillTemplate(Context context) {
		return templateEngine.process(new ClassPathResource(PDF_RESOURCES + "certificate").getPath(), context);
	}

	@Override
	public File generateInvoice(InvoiceGenerationDTO invoiceDTO) throws IOException, DocumentException {
		Context context = getInvoiceContext(invoiceDTO);
		String html = loadAndFillInvoiceTemplate(context);
		System.out.println("Load Templates");
		return renderPdf(html);
	}

	private Context getInvoiceContext(InvoiceGenerationDTO invoiceDTO) {
		Context context = new Context();
		context.setVariable("invoice", invoiceDTO);
		return context;
	}

	private String loadAndFillInvoiceTemplate(Context context) {
		return templateEngine.process(new ClassPathResource(PDF_RESOURCES + "invoice").getPath(), context);
	}

}
