package org.textrpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.textrpg.feignclient.gigachat")
public class TextRpgApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextRpgApplication.class, args);
    }

}
