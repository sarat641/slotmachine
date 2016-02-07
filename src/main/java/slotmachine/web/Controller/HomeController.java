package slotmachine.web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import slotmachine.web.dao.FileUploadDAO;
import slotmachine.web.entities.Fileuploads;

/**
 *
 * @author SARAT
 */
@Controller
public class HomeController {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public String editView(@RequestParam("id") Integer logoId,Model model) {
        Fileuploads fileuploads =fileUploadDAO.findById(logoId);
        model.addAttribute("data", fileuploads);
        return "editView";
    }

}
