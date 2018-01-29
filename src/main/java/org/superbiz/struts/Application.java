package org.superbiz.struts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean struts2Filter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("struts2");
        registrationBean.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("actionPackages","com.lq");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean strutsCleanupFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("struts-cleanup");
        registrationBean.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean sitemeshFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setName("sitemesh");
        registrationBean.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(3);
        return registrationBean;
    }
}
