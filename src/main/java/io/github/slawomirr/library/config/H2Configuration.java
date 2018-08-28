package io.github.slawomirr.library.config;

//import javax.servlet.annotation.WebServlet;
//import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Configuration {

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
        registration.addUrlMappings("/console/*");
        return registration;
    }
}
