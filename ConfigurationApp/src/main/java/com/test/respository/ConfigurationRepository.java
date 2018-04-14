package com.test.respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.domain.ConfigurableItem;
import com.test.domain.ConfigurableItemKey;

public interface ConfigurationRepository extends CrudRepository<ConfigurableItem, ConfigurableItemKey>{

	 /**
	  * Returns all configurable items.
	  * @return
	  */
	// List<ConfigurableItem> findByAll();
     
	/**
	 * Reurns all document for appCode
	 * @param appCode
	 * @return
	 */
	 List<ConfigurableItem> findByConfigurableItemKey_AppCode(String appCode);
	 
	 /**
	  * Returns the documents for app code and version.
	  * @param appCode
	  * @param version
	  * @return
	  */
	 ConfigurableItem findByConfigurableItemKeyAppCodeAndConfigurableItemKeyVersion(String appCode,String version);
	 
	 
	 
	 
}
