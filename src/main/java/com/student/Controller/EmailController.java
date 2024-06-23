package com.student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Service.SendEmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController 
{
	@Autowired
	private SendEmailService emailService;
		
	@GetMapping("/sendEmail")
	public String sendEmail(String receiver,String body) {
		emailService.sendEmail(receiver," Your Registration Successfully ",body);
		
		return "email sent successfully...!";
	}
}
