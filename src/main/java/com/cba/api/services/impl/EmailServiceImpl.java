package com.cba.api.services.impl;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.cba.api.repository.SubscriptionRepository;
import com.cba.api.services.EmailService;
import com.cba.api.utils.EmailDetails;

@Transactional

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	SubscriptionRepository subscriptionRepository;


	@Override
	@Transactional(propagation =  Propagation.REQUIRES_NEW)
	public String sendEmail(EmailDetails emailDetails) {
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariable("emailDetails", emailDetails);
			String process = templateEngine.process("email.html", context);
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getRecipientEmail());
			if (emailDetails.getCcMailId() != null && emailDetails.getCcMailId().trim().length() > 0) {
				mimeMessageHelper.setCc(emailDetails.getCcMailId());
			}
			mimeMessageHelper.setSubject(emailDetails.getSubject());
			mimeMessageHelper.setText(process, true);
			HashMap<String, File> attachments = emailDetails.getAttachment();
			if (attachments != null) {
				for (String fileName : attachments.keySet()) {
					mimeMessageHelper.addAttachment(fileName, attachments.get(fileName));
				}
			}
			System.out.println("b4 calling ");
			mimeMessageHelper.addInline("logo", new ClassPathResource("static/img/kin_logo_small.png"));

			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		catch (MessagingException e) {
			e.printStackTrace();
			return "Error while sending mail!!!";
		}
	}

}
