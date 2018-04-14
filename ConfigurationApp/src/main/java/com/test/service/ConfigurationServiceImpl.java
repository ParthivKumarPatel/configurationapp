package com.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.domain.ConfigurableItem;
import com.test.domain.ConfigurableItemKey;
import com.test.respository.ConfigurationRepository;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
	  List<ConfigurableItem> items =  null;
	  
	  @Autowired
	  ConfigurationRepository configurationRepository; 
	
	/**
	 *   Returns all configurables items from the system.
	 */
	public List<ConfigurableItem> getAllConfigurableItems() {
		 return (List<ConfigurableItem>)configurationRepository.findAll();
		
	}
	
	/**
	 * Returns configurables properties values for particular app code.
	 */
	@Override
	public List<ConfigurableItem> getAllConfigurationItems(String appCode) {
		List<ConfigurableItem> items = (List<ConfigurableItem>)configurationRepository.findByConfigurableItemKey_AppCode(appCode);
		items.sort((i1,i2) -> i2.getLastModified().compareTo(i1.getLastModified()));		
		return items;
	}
	
	/**
	 * Returns the configurable property values for appcode and version.
	 */
	@Override
	public ConfigurableItem getConfigurationItem(String appCode, String version) {
		return  configurationRepository.findByConfigurableItemKeyAppCodeAndConfigurableItemKeyVersion(appCode, version);
		
	}
	
	/**
	 * Update the configurable property values for appcode, version and new value. if appcode and version does exist then it will replace the 
	 * itemname with newItemname, if not exists it will create a new configurableItem
	 */
	@Override
	@Transactional
	public void updateConfigurationItem(String appCode, String version, String newItemName) {
		ConfigurableItemKey key = new ConfigurableItemKey();
		key.setAppCode(appCode);		
		key.setVersion(version);
		ConfigurableItem item = new ConfigurableItem();
		item.setConfigurableItemKey(key);
		item.setLastModified(new Date());
		item.setItemName(newItemName);
		configurationRepository.save(item);

		
	}
}
