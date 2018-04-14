package com.test.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.domain.ConfigurableItem;
import com.test.domain.ConfigurableItemKey;
import com.test.service.ConfigurationService;
import com.test.ui.ConfigurationVO;


/**
 * Main controller to manage the interaction with component. 
 * 
 * @author PateP1
 *
 */
@RestController
public class AppConfigController {
     
	@Autowired
	ConfigurationService configurationService;
	

    /**
     * Returns documents for app code and version.
     * 
     * Assumption : document is represented by itemname in database. 
     * for example can be configured in database like below..
     * APP CODE , ItemName, Version
     * =====================================================
     * PDF_PATH,   /c://abc// , 0.1
     * WEB_SERVICE_URL , http://xx.xx.xx.xx:90/ , 0.1
     * PDF_PATH,   /c://todo// , 0.2
     * 
     * 
     * @param appCode
     * @param version
     * @return
     */
    
	@RequestMapping("/api/{appCode}/config/{version}")
    public ConfigurableItem getConfigurationItem(@PathVariable("appCode") String appCode,
    		@PathVariable("version") String version) {
    	return configurationService.getConfigurationItem(appCode, version);
    	
    }
    /**
     * Add/update the configurable property
     * @param item
     */
    @PostMapping("/api/{appCode}/config/{version}")
    public void updateConfigurableItem(@RequestBody ConfigurationVO item) {
    	configurationService.updateConfigurationItem(item.getAppCode(), item.getVersion(), item.getName());    	
    }
    
    /**
     * Returns all items for an app code.
     * @param appCode
     * @return
     */
    @RequestMapping("/api/{appCode}/config")
    public List<ConfigurableItem> getConfigurableItems(@PathVariable("appCode") String appCode) {
    	return configurationService.getAllConfigurationItems(appCode)    ;	
    }
    
}