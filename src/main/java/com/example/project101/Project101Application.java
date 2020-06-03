package com.example.project101;

import com.example.project101.property.FileStorageProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.twilio.type.PhoneNumber;
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Project101Application {

    public static void main(String[] args) {
        SpringApplication.run(Project101Application.class, args);
    }

}
