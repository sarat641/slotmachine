/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine.web.dao;

import slotmachine.config.TestContext;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import slotmachine.web.entities.Fileuploads;

/**
 *
 * @author SARAT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class})
@DatabaseSetup(value = {"/data/FileUploads.xml"})
public class FileUploadDAOTest {

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @Test
    public void daoShouldNotBeNull() {
        assertNotNull(fileUploadDAO);
    }

    @Test
    public void findAll() {
        Collection<Fileuploads> listOfAccount = fileUploadDAO.findAll();
        assertEquals(1, listOfAccount.size());
    }

    @Test
    public void save() {

        Fileuploads fileuploads = new Fileuploads();
        fileuploads.setFileName("test.jpg");
        fileuploads.setPrice(10);
        fileuploads.setFilelocation("F:\temp\test.jpg");

        fileUploadDAO.save(fileuploads);

        Collection<Fileuploads> listOfFileUploads = fileUploadDAO.findAll();
        assertEquals(2, listOfFileUploads.size());

    }
   
    @Test
    public void update() {
        Fileuploads fileuploads = fileUploadDAO.findById(0);
        fileuploads.setFileName("xyz");
        fileUploadDAO.update(fileuploads);
        Fileuploads afterUpdateFileuploads = fileUploadDAO.findById(0);
        assertEquals("xyz", afterUpdateFileuploads.getFileName());
    }
    
   
}
