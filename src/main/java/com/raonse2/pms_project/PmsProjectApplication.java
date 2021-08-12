package com.raonse2.pms_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PmsProjectApplication extends SpringBootServletInitializer {
    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PmsProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PmsProjectApplication.class, args);
    }

}
