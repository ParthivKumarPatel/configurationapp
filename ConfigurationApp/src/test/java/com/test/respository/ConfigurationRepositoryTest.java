package com.test.respository;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.domain.ConfigurableItem;
import com.test.domain.ConfigurableItemKey;
import org.junit.Assert;



@RunWith(SpringRunner.class)
@DataJpaTest
public class ConfigurationRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
	
	 @Autowired
	 private ConfigurationRepository configurationRepository;
	 
	 
	@Test
    public void testAddUpdateConfigurationItem() {
		ConfigurableItem item = new ConfigurableItem();
		
		ConfigurableItemKey itemKey = new ConfigurableItemKey();
		itemKey.setAppCode("PDF_PATH");
		itemKey.setVersion("0.1");
		
		item.setConfigurableItemKey(itemKey);
		item.setItemName("/abc/txt");
		item.setLastModified(new Date());
		
		
        entityManager.persist(item);
        
        ConfigurableItem itemfromDb = configurationRepository.
        		findByConfigurableItemKeyAppCodeAndConfigurableItemKeyVersion("PDF_PATH", "0.1");
		Assert.assertEquals("/abc/txt", itemfromDb.getItemName());
}
	
	@Test
	public void testListAllConfigurationItemForAppCode() {
		
		ConfigurableItem item = new ConfigurableItem();
		
		ConfigurableItemKey itemKey = new ConfigurableItemKey();
		itemKey.setAppCode("PDF_PATH");
		itemKey.setVersion("0.1");
		
		item.setConfigurableItemKey(itemKey);
		item.setItemName("/abc/txt");
		item.setLastModified(new Date());
		
		
        entityManager.persist(item);
        
        ConfigurableItem item2 = new ConfigurableItem();
		
		ConfigurableItemKey itemKey2 = new ConfigurableItemKey();
		itemKey2.setAppCode("PDF_PATH");
		itemKey2.setVersion("0.2");
		
		item2.setConfigurableItemKey(itemKey2);
		item2.setItemName("/abc/233");
		item2.setLastModified(new Date());
		
		
        entityManager.persist(item2);
		
        List<ConfigurableItem> items = configurationRepository.findByConfigurableItemKey_AppCode("PDF_PATH");
        Assert.assertEquals(2, items.size()); //check the lentgh of stored list..
		
		
	}
    
}
    
