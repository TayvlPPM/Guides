package com.HelpGuide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.HelpGuide")
@EnableJpaRepositories("com.HelpGuide.repository")
@EntityScan("com.HelpGuide.model")
@PropertySource({
        "classpath:application.properties"
})
@EnableCaching
@SpringBootApplication
public class HelpGuide extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelpGuide.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HelpGuide.class, args);
    }
}
