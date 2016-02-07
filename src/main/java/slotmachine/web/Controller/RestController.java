package slotmachine.web.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import slotmachine.web.dao.FileUploadDAO;
import slotmachine.web.dto.EmailDTO;
import slotmachine.web.entities.Fileuploads;
import slotmachine.web.util.ApplicationConstants;

/**
 *
 * @author SARAT
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/image/rest/api")
public class RestController {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @Autowired
    private MailSender mailSender;

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public String deleteFile(@PathVariable Integer id) {
        Fileuploads fileuploads = fileUploadDAO.findById(id);
        try {

            File file = new File(fileuploads.getFilelocation());

            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
                fileUploadDAO.delete(id);
            } else {
                System.out.println("Delete operation is failed.");
                return "fail";
            }

        } catch (Exception e) {
            System.out.println(e);
            return "fail";
        }
        return "succuess";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String nextImageSet() {

        List<Integer> ids = fileUploadDAO.getListOfFileIds();
        String randomIdsAsString = getRandomIdsListAsString(ids);
        return randomIdsAsString;
    }

    private String getRandomIdsListAsString(List<Integer> listOfImageIds) {
        StringBuilder idsAsString = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(listOfImageIds.size());
            idsAsString.append(listOfImageIds.get((randomIndex)));
            if (i != 2) {
                idsAsString.append(":");
            }
        }
        return idsAsString.toString();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sendMail")
    public String sendMail(@RequestBody EmailDTO email) {
        

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(ApplicationConstants.MAIL_FROM);
        message.setTo(email.getRecipient());
        message.setSubject(ApplicationConstants.MAIL_SUBJECT);
        message.setText(ApplicationConstants.MAIL_MESSAGE);
        mailSender.send(message);

        return "success";
    }
}
