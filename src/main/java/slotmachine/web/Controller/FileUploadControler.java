package slotmachine.web.Controller;

import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import slotmachine.web.dao.FileUploadDAO;
import slotmachine.web.entities.Fileuploads;
import slotmachine.web.squencer.Sequencer;
import slotmachine.web.util.ApplicationConstants;

/**
 *
 * @author SARAT
 */
@Controller
public class FileUploadControler {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @Autowired
    private Sequencer sequencer;

    @RequestMapping(method = RequestMethod.POST, value = "/uploadLogo")
    public String save(@RequestPart("logo") MultipartFile logo, Fileuploads fileUpload, Model model) throws IOException {

        String filename = sequencer.next() + logo.getOriginalFilename();//unique file name 
        fileUpload.setFilelocation(ApplicationConstants.UPLOADS_PATH + filename);
        logo.transferTo(new File(ApplicationConstants.UPLOADS_PATH + filename));

        fileUploadDAO.save(fileUpload);
        model.addAttribute("listOfFileUploads", fileUploadDAO.findAll());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateLogo")
    public String update(@RequestPart("logo") MultipartFile logo, Fileuploads fileUpload, Model model) throws IOException {

        if (!logo.getOriginalFilename().isEmpty()) {
            String filename = sequencer.next() + logo.getOriginalFilename();//unique file name 
            fileUpload.setFilelocation(ApplicationConstants.UPLOADS_PATH + filename);
            logo.transferTo(new File(ApplicationConstants.UPLOADS_PATH + filename));
        } else {
            Fileuploads defultFile = fileUploadDAO.findById(fileUpload.getId());
            fileUpload.setFilelocation(defultFile.getFilelocation());
        }

        fileUploadDAO.update(fileUpload);
        model.addAttribute("listOfFileUploads", fileUploadDAO.findAll());
        return "home";
    }

}
