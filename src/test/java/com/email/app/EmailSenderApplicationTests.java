package com.email.app;

import java.io.File;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import Service.EmailService;


@SpringBootTest
class EmailSenderApplicationTests {
	
   
	private EmailService emailService;

	@Test
	void sendEmailTest(){
	  System.out.println("Sending email");
	  emailService.sendEmail("singhnyasa950@gmail.com", "This is email from Spring Boot", "This email is send by spring boot while creating email service");
	}
      
	@Test
	void sendEmailWithHtmlTest() {
		String html =""+ "<h1>Welcome </h1>";
		emailService.sendEmailWithHtml("singhnyasa950@gmail.com", "This is boot", html);
	}
	
	void sendEmailWithFile() {
		emailService.sendEmailWithFile("singhnyasa950@gmail.com","Email with File", "This email Conatin file", new File("C:\\Users\\ASUS\\Documents\\workspace-spring-tool-suite-4-4.23.1.RELEASE\\EmailSender\\src\\main\\resources\\Javacertificate.jpg"));
	}
}
