package com.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.domain.ConfigurableItem;

@Service
public interface ConfigurationService {

	/**
	 * Returns all configuration items.
	 * @return
	 */
	public List<ConfigurableItem> getAllConfigurableItems() ;
	
	/**
	 * Returns the item based on app code and version.
	 * @param appCode
	 * @param version
	 * @return
	 */
	public ConfigurableItem getConfigurationItem(String appCode, String version);
	
	/**
	 * Update the particular item with new name based on app code and version.
	 *  if item is not available.. ite will be added new.
	 * @param appCode
	 * @param version
	 * @param newItemName
	 */
	public void updateConfigurationItem(String appCode, String version, String newItemName);
	
	/**
	 * Returns all configuration items in descending order of last modified for perticular app code.
	 * @param appCode
	 * @return
	 */
	public List<ConfigurableItem> getAllConfigurationItems(String appCode) ;
	
}
