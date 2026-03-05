package com.example.springboothello.controller;

//import com.example.demo.vo.ResultVO;
import com.example.springboothello.vo.ResultVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthController {

    @Value("${spring.application.name:系统健康检查服务}")
    private String appName;

    @Value("${application.version:1.0.0}")
    private String version;

    @GetMapping("/health")
    public ResultVO<Map<String, Object>> health() {
        Map<String, Object> data = new HashMap<>();
        data.put("appName", appName);
        data.put("version", version);
        data.put("time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        data.put("status", "UP");

        return ResultVO.success(data);
    }
}