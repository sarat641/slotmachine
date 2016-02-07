package slotmachine.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import slotmachine.web.dto.EmailDTO;

/**
 *
 * @author SARAT
 */
@Controller
public class MailController {

    @Autowired
    private MailSender mailSender;

    @RequestMapping(method = RequestMethod.GET, value = "/sendMail")
    public String emailForm() {
        return "EmailForm";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sendMail")
    public String doRegister(EmailDTO email, BindingResult errors)  {
        if (errors.hasErrors()) {
            return "home";
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("babu145356@gmail.com");
        message.setTo(email.getRecipient());
        message.setSubject(email.getSubject());
        message.setText(email.getMessage());
        mailSender.send(message);

        return "success";
    }
}
