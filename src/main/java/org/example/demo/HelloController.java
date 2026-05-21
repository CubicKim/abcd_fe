package org.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        /*return "<h1>[IntelliJ-Community] 순수 Spring Boot (Java 1.8) 배포 성공! - Version 1</h1>";*/
        /*return "<h1>[IntelliJ-Community] 순수 Spring Boot (Java 17) 배포 성공! - Version 2</h1>";*/
        return "<h1>배포 확인 - Version 3</h1>";
    }
}