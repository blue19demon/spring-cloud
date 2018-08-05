package com.zimadai.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
@RefreshScope
public class JdbcFile {

	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.port}")
	private String port;
	@Value("${jdbc.username}")
	private String usename;
	@Value("${jdbc.password}")
	private String passport;
	
	public JdbcFile() {
		super();
	}
	public JdbcFile(String url, String port, String usename, String passport) {
		super();
		this.url = url;
		this.port = port;
		this.usename = usename;
		this.passport = passport;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	
}
