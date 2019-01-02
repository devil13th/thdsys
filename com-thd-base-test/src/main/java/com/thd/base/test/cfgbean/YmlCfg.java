package com.thd.base.test.cfgbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
//@ConfigurationProperties(prefix="ymlcfg")
public class YmlCfg {
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Value("${ymlcfg.project-name}")
	private String projectName;
	
}
