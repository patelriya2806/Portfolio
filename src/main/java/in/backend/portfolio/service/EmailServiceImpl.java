package in.backend.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Async
    public void sendEmail(String email,String message) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(sender);
            mail.setSubject("Portfolio Contact Message");
            mail.setText("From :" + email + "\n" + "Message : " + message);
            mailSender.send(mail);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error :" + e.getMessage());
        }
    }
}