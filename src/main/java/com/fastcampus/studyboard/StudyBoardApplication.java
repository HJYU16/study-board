package com.fastcampus.studyboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class StudyBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyBoardApplication.class, args);
    }

}
