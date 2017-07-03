package com.aircha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MasteringSpirngMvc4Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MasteringSpirngMvc4Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MasteringSpirngMvc4Application.class, args);
    }
}
