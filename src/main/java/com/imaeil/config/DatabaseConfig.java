package com.imaeil.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@PropertySource("classpath:/properties/globals.properties")
public class DatabaseConfig {
	@Value("${db.type}")
	private String type;
	@Value("${db.default}")
	private String def;
	@Value("${db.driver}")
	private String drivername;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.ip}")
	private String ip;
	@Value("${db.port}")
	private String port;
	@Value("${db.sid}")
	private String sid;
	@Value("${db.poolname}")
	private String poolname;
	@Value("${db.poolsize}")
	private String poolsize;
	@Value("${db.timeout}")
	private String timeout;
	@Value("${db.detectionthreshold}")
	private String detectionthreshold;
	@Value("${db.testquery}")
	private String testquery;
	
	public String getUrl() {
		String url = null;
		
		if(this.type.equals("Oracle")) {
			url = this.def + this.ip + ":" + this.port + ":" + this.sid;
		}
		
		return url;
	}
}
