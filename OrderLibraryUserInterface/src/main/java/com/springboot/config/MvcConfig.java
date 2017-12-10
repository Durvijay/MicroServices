package com.springboot.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/home").setViewName("index");
     registry.addViewController("/").setViewName("login");
     registry.addViewController("/welcome").setViewName("welcome");
     registry.addViewController("/login").setViewName("login");
    }
    
    
}