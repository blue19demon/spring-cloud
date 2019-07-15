package com.zmph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZuulApiGatewayApplication {
	 //追加bean的是实现
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}
}