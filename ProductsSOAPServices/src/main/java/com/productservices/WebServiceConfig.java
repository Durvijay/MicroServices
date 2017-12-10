package com.productservices;

import org.apache.ws.commons.schema.resolver.DefaultURIResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	@Bean(name = "productservice")
	public DefaultWsdl11Definition defaultWsdl11Definition() throws Exception {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("ProductPort");
		wsdl11Definition.setLocationUri("http://localhost:8080/");
		wsdl11Definition.setTargetNamespace("http://localhost:8080/ProductsServices");
		wsdl11Definition.setSchemaCollection(updateContactXsd());
		return wsdl11Definition;
	}

	@Bean
	public XsdSchemaCollection updateContactXsd() throws Exception {
		Resource[] schema = { new ClassPathResource("xsd/Products.xsd"),
				new ClassPathResource("xsd/ProductsServicesOperations.xsd") };

		CommonsXsdSchemaCollection collection = new CommonsXsdSchemaCollection(schema);
		collection.setUriResolver(new DefaultURIResolver());
		collection.setInline(true);
		return collection;
	}

	@Bean
	public XsdSchema productsSchema1() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/ProductsServicesOperations.xsd"));
	}
}
