package Service;

import java.io.File;

import org.springframework.stereotype.Service;


public interface EmailService {
	
	//send email to single person
	void sendEmail(String to,String subject,String message);
	
	//send email to multiple person
	void sendEmail(String [] to, String subject,String msg);
	
	//send Email with html
	void sendEmailWithHtml(String to,String subject,String htmlcontent);
	 
	void sendEmailWithFile(String to,String subject,String message,File file);
   
	List<Message> getInbixMessages();
}
 