package kr.or.dev;

import java.util.List;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/login")
	public String loginTest(){
		return "login/login";
	}
	
	@RequestMapping("/main")
	public String mainTest(){
		return "main";
	}
	
	@RequestMapping("/project")
	public String projectTest(){
		return "project";
	}
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping("/sendMail")
	public String sendMail(@RequestParam("toEmail")List<String> emailList
						 , @RequestParam(value="email_con", defaultValue="Flowolf로 업무관리, 채팅, 파일공유, 일정 공지를 한 곳에서!\n pc에서 사용해보세요.")String email_con) throws MessagingException{
		
		
		MimeMessage message = mailSender.createMimeMessage();		
		
		message.setFrom("Flowolf <cocoa8090@gmail.com>");
		message.setSubject("[Flowolf] 프로젝트에 초대합니다.");
		message.setText(email_con);
		
		for (String toEmail : emailList) {			
			message.addRecipients(Message.RecipientType.TO, toEmail);
		}		
		
		mailSender.send(message);
		return "redirect:/test/project";
	}

}
