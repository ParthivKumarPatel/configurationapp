package com.test.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConfigurableItemKey implements Serializable {

	@Column(name="appcode")
	private String appCode;
	
	
	@Column(name="version")
	private String version;
	
	@Column(name="appcode")
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	@Column(name="version")
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
