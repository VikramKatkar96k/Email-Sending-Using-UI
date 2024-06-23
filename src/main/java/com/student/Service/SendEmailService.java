package com.student.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

	private JavaMailSender javaMailSender;

	@Value("$(spring.mail.username)")
	private String fromEmailID;

	public SendEmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendEmail(String receiver,String sub,String ebody) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmailID);
		message.setTo(receiver);
		message.setSubject(sub);
		message.setText(ebody);
		javaMailSender.send(message);
	}

}
