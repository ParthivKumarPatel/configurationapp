package com.test.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.test.domain.ConfigurableItem;
import com.test.service.ConfigurationService;
import com.test.ui.ConfigurationVO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AppConfigControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void createConfigurationItem() {
    	
    	ConfigurationVO vo = new ConfigurationVO();
    	vo.setAppCode("PDF_PATH");
    	vo.setName("c://test.pdf");
    	vo.setVersion("0.1");
    	
    	URI url = restTemplate.postForLocation("/api/PDF_PATH/config/0.1",vo);   
    	
    }
    
    @Test
    public void getConfigurationItem() {
    	
    	ConfigurationVO vo = new ConfigurationVO();
    	vo.setAppCode("PDF_PATH");
    	vo.setName("c://test.pdf");
    	vo.setVersion("0.1");
    	
    	URI url = restTemplate.postForLocation("/api/PDF_PATH/config/0.1",vo);  
    	
    	 ResponseEntity<ConfigurableItem> responseEntity =
    	            restTemplate.getForEntity("/api/PDF_PATH/config/0.1", ConfigurableItem.class);
    	 			ConfigurableItem item = responseEntity.getBody();
    	        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	        Assert.assertEquals("c://test.pdf", item.getItemName());
    	
    	
    }
    
    
    @Test
    public void getConfigurationItemsForAppCode() {
    	
    	ConfigurationVO vo = new ConfigurationVO();
    	vo.setAppCode("PDF_PATH");
    	vo.setName("c://test.pdf");
    	vo.setVersion("0.1");
    	
    	 restTemplate.postForLocation("/api/PDF_PATH/config/0.1",vo);  
    	
    	vo = new ConfigurationVO();
    	vo.setAppCode("PDF_PATH");
    	vo.setName("c://test.pdf");
    	vo.setVersion("0.2");
    	
    	 restTemplate.postForLocation("/api/PDF_PATH/config/0.2",vo);
    	
    	
    	 
    	    Object[] responselist =
    	            restTemplate.getForObject("/api/PDF_PATH/config", Object[].class);
    	 		
    	     //   Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    	        Assert.assertEquals(2, Arrays.asList(responselist).size());
    	      
    	
    	
    }
}