package slotmachine.web.Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/myImage")
public class ImageController {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("id") Integer logoId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Fileuploads fileuploads =fileUploadDAO.findById(logoId);
        
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        
        File f = new File(fileuploads.getFilelocation());
		BufferedImage bi = ImageIO.read(f);
        try (OutputStream out = response.getOutputStream()) {
            ImageIO.write(bi, "jpg", out);
        }

    }
}
