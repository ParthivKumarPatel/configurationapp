package com.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author PateP1
 *Domain object for saving configurable item.
 */
@Entity
@Table(name = "configurableitem")
public class ConfigurableItem {

	@EmbeddedId
    private ConfigurableItemKey configurableItemKey;
	
	
	
	
	public ConfigurableItemKey getConfigurableItemKey() {
		return configurableItemKey;
	}
	public void setConfigurableItemKey(ConfigurableItemKey configurableItemKey) {
		this.configurableItemKey = configurableItemKey;
	}
	
	@Column(name="name")
	private String itemName;
	
	
	
	@Column(name="lastmodified")
	private Date lastModified;
	
	
	@Column(name="lastmodified")
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	
	@Column(name="name")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}		
	
	
	
	
	
}
