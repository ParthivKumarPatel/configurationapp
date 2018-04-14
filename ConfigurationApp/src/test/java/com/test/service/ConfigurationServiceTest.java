package com.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.domain.ConfigurableItem;
import com.test.domain.ConfigurableItemKey;
import com.test.respository.ConfigurationRepository;



@RunWith(SpringRunner.class)
public class ConfigurationServiceTest {

	  
	   
	   @TestConfiguration
	    static class ConfigurationServiceTestContextConfiguration {
	  
	        @Bean
	        public ConfigurationService employeeService() {
	            return new ConfigurationServiceImpl();
	        }
	    }
	   
	   @Autowired
	   private ConfigurationService configurationService;
	 
	   @MockBean
	    private ConfigurationRepository cofigurationReposity;
	   
	   @Before
	   public void setUp() {
	       ConfigurableItem item = new ConfigurableItem();
	       ConfigurableItemKey key = new ConfigurableItemKey();
	       key.setAppCode("PDF_PATH");
	       key.setVersion("0.1");
	       item.setConfigurableItemKey(key);
	       item.setItemName("c://test.pdf");
	       item.setLastModified(new Date());
	       
	       ConfigurableItem item2 = new ConfigurableItem();
	       ConfigurableItemKey key2 = new ConfigurableItemKey();
	       key2.setAppCode("PDF_PATH");
	       key2.setVersion("0.2");
	       item2.setConfigurableItemKey(key2);
	       item2.setItemName("c://abc.pdf");
	       item2.setLastModified(new Date());
	       
	       List<ConfigurableItem> items = new ArrayList<>();
	       items.add(item);
	       items.add(item2);
	       
	    
	       Mockito.when(cofigurationReposity.findByConfigurableItemKeyAppCodeAndConfigurableItemKeyVersion(key.getAppCode(), key.getVersion()))
	         .thenReturn(item);
	       
	       Mockito.when(cofigurationReposity.save(item))
	         .thenReturn(item);
	       
	       Mockito.when(cofigurationReposity.findByConfigurableItemKey_AppCode("PDF_PATH"))
	         .thenReturn(items);
	       
	   }	   
	  
  
	   @Test
	    public void getConfigurableItem() throws Exception {
		   String appCode = "PDF_PATH";
		   String version = "0.1";
		   
		   ConfigurableItem item =  configurationService.getConfigurationItem(appCode, version);
		   

	        Assert.assertEquals("c://test.pdf", item.getItemName());

	    }
	   
	   @Test
	    public void createUpdateConfigurationItem() throws Exception {
		   String appCode = "PDF_PATH";
		   String version = "0.1";
		   String itemName = "c:/test.pdf";
		   
		   configurationService.updateConfigurationItem(appCode, version, itemName);
		   


	    }
	   
	   @Test
	    public void getConfigurationItemsForAppCode() throws Exception {
		   String appCode = "PDF_PATH";
		  
		   
		   List<ConfigurableItem> items = configurationService.getAllConfigurationItems(appCode);
		   Assert.assertEquals(2,items.size());


	    }

}
