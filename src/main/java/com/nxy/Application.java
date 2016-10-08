package com.nxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebEnvironment(false);
        ApplicationContext context = app.run(args);
        System.out.println(context.getEnvironment().getProperty("app.bili.api.avinfo-url"));
    }
}
