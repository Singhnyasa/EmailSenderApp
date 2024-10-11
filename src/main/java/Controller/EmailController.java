package Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.EmailService;

@RestController
@RequestMapping("api/v1/email")
@CrossOrigin("*")
public class EmailController {
	
	private EmailService emailservice;
	
	
	
	public EmailController(EmailService emailservice) {
		
		this.emailservice = emailservice;
	}



	@PostMapping("/send")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
 		
		emailservice.sendEmailWithHtml(request.getTo(), request.getSubject(), request.getMssg());
		return ResponseEntity.ok("Email is send ");
	}
	


}
