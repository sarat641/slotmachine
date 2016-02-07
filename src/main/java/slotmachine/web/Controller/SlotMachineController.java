/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine.web.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import slotmachine.web.dao.FileUploadDAO;

/**
 *
 * @author SARAT
 */
@Controller
public class SlotMachineController {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @RequestMapping(method = RequestMethod.GET, value = "/slotMachineHome")
    public String defaultSlotMachine(Model model) {
        List<Integer> ids = fileUploadDAO.getListOfFileIds();
        model.addAttribute("imageIds", getRandomIdsList(ids));
        return "slotMachine";
    }

    private List<Integer> getRandomIdsList(List<Integer> listOfImageIds) {
        Random random = new Random();
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(listOfImageIds.size());
            ids.add(listOfImageIds.get((randomIndex)));
        }
        return ids;
    }
}
