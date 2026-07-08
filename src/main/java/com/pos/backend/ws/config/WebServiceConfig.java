package com.pos.backend.ws.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    // Registra el servlet que atiende las peticiones SOAP en /ws/*
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // El nombre del bean ("tipoCambio") define la URL final del WSDL:
    // http://localhost:8080/ws/tipoCambio.wsdl
    @Bean(name = "tipoCambio")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema tipoCambioSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("TipoCambioPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://pos.com/tipocambio");
        wsdl11Definition.setSchema(tipoCambioSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema tipoCambioSchema() {
        return new SimpleXsdSchema(new ClassPathResource("tipoCambio.xsd"));
    }
}
