/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine.web.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import slotmachine.config.RootConfig;
import slotmachine.config.WebConfig;
import slotmachine.web.Controller.HomeController;
import slotmachine.web.dao.FileUploadDAO;

/**
 *
 * @author SARAT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockServletContext.class})
@WebAppConfiguration
public class HomeControllerTest {
    
    private final String URL = "/";
    private MockMvc mvc;
    private FileUploadDAO fileUploadDAO;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
        
    }
    
    @Test
    public void home() throws Exception {
        mvc.perform(get(URL))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }
    
}
