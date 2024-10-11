package Service;

import java.beans.JavaBean;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@JavaBean
@Service
public class EmailServiceImpl implements EmailService{

	@Autowired(required = true)
	private JavaMailSender  mailsender;
    private static final Logger logger =  LoggerFactory.getLogger(EmailServiceImpl.class);
	
    @Autowired(required = true)
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailsender = mailSender;
    }

	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setFrom("singhnyasa.11june@gmail.com");
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		//simpleMailMessage.setFrom("singhnyasa.11june@gmail.com");
		mailsender.send(simpleMailMessage);

		logger.info("Email has been sent...");
		
	}

	@Override
	public void sendEmail(String[] to, String subject, String msg) {
		// TODO Auto-generated method stub
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(msg);
		simpleMailMessage.setFrom("singhnyasa.11june@gmail.com");
		mailsender.send(simpleMailMessage);
		logger.info("Email has been sent...");
		
	}

	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlcontent) {
		// TODO Auto-generated method stub
        MimeMessage simpleMailMessage = mailsender.createMimeMessage();
        
        try {
			MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage, true, "UTF-8");
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setFrom("singhnyasa.11june@gmail.com");
	        helper.setText(htmlcontent,true);
	        mailsender.send(simpleMailMessage);
	        logger.info("Email has been sent...");
			 
        } catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void sendEmailWithFile(String to, String subject,String message ,File file) {
		// TODO Auto-generated method stub
		MimeMessage mimeMessage =mailsender.createMimeMessage();
		 try {
			MimeMessageHelper helper =new MimeMessageHelper(mimeMessage, true);
		    helper.setTo(to);
		    helper.setFrom("singhnyasa.11june@gmail.com");
		    helper.setText(message);
		    helper.setSubject(subject);
		    FileSystemResource fileSystemResource =  new FileSystemResource(file);
		    helper.addAttachment(fileSystemResource.getFilename(),file);
		    mailsender.send(mimeMessage);
		    
		 } catch (MessagingException e) {
              throw new RuntimeException(e);
		}
	}

	

	

}
