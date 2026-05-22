package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AbcdFeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbcdFeApplication.class, args);
    }

    /**
     * 🎯 백엔드(abcd_be) API를 호출할 때 사용할 RestTemplate을 빈(Bean)으로 등록합니다.
     * 이렇게 등록해두면 HomeController 등에서 @Autowired로 편하게 주입받아 쓸 수 있습니다.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}