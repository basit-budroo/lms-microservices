package org.lms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.lms")
@EntityScan(basePackages = "org.lms.bean")
@EnableJpaRepositories(basePackages = "org.lms.persistence")
@EnableEurekaClient
public class LmsUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LmsUserServiceApplication.class, args);
    }

}
