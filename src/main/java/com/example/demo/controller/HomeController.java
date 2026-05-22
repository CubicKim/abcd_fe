package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        // 🎯 [핵심 주소] 쿠버네티스 내부 DNS 서비스 이름을 주소로 사용합니다!
        String backendUrl = "http://abcd-be-service:8081/api/data";

        String backendMessage = "";
        try {
            RestTemplate restTemplate = new RestTemplate();
            // 백엔드 API 호출하여 결과 Map으로 받기
            Map<String, Object> response = restTemplate.getForObject(backendUrl, Map.class);
            if (response != null) {
                backendMessage = (String) response.get("message");
            }
        } catch (Exception e) {
            backendMessage = "백엔드 연결 실패: " + e.getMessage();
        }

        // Thymeleaf나 JSP 템플릿 화면으로 데이터 전달
        model.addAttribute("backendMessage", backendMessage);
        return "index";
    }
}