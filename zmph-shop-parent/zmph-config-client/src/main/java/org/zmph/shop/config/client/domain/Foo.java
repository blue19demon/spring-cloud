package org.zmph.shop.config.client.domain;

import org.springframework.beans.factory.annotation.Value;

public class Foo {
	@Value("${foo}")
	private String foo;
	@Value("${democonfigclient.message}")
	private String message;
	public String getFoo() {
		return foo;
	}
	public void setFoo(String foo) {
		this.foo = foo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Foo(String foo, String message) {
		super();
		this.foo = foo;
		this.message = message;
	}
	public Foo() {
		super();
	}
	
}
