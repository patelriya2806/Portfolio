package in.backend.portfolio.controller;

import in.backend.portfolio.modal.Email;
import in.backend.portfolio.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/contact")
    public String setEmailService(@RequestBody Email email) {
        emailService.sendEmail(email.getEmail(),email.getMessage());
        return "Message sent successfully";
    }
}
