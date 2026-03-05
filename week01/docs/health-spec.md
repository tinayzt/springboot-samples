1. 核心目标
提供系统健康检查接口，快速确认服务运行状态

2. 业务规则
接口路径：GET /api/health

请求参数：无

返回字段：

appName：应用名称

version：应用版本

time：当前服务器时间（格式：yyyy-MM-dd HH:mm:ss）

status：运行状态（固定返回 "UP"）

3. 技术约束
框架：Spring Boot 3.x + Java 17

端口：8080

返回格式：统一使用 ResultVO<T> 包装

包结构：

com.example.controller.HealthController

com.example.vo.ResultVO<T>

com.example.dto.HealthInfoDTO

4. 接口示例
请求
text
GET http://localhost:8080/api/health
成功响应
json
{
  "code": 200,
  "msg": "success",
  "data": {
    "appName": "健康检查服务",
    "version": "1.0.0",
    "time": "2024-01-15 14:30:45",
    "status": "UP"
  }
}
5. 配置文件
yaml
spring:
  application:
    name: 健康检查服务

application:
  version: 1.0.0
6. 实现要点
ResultVO.java
java
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
    
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(200, "success", data);
    }
}
HealthInfoDTO.java
java
public class HealthInfoDTO {
    private String appName;
    private String version;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String status;  // 固定 "UP"
}
HealthController.java
java
@RestController
@RequestMapping("/api")
public class HealthController {
    
    @Value("${spring.application.name}")
    private String appName;
    
    @Value("${application.version}")
    private String version;
    
    @GetMapping("/health")
    public ResultVO<HealthInfoDTO> health() {
        HealthInfoDTO info = new HealthInfoDTO();
        info.setAppName(appName);
        info.setVersion(version);
        info.setTime(LocalDateTime.now());
        info.setStatus("UP");
        return ResultVO.success(info);
    }
}
7. 验收标准
服务启动成功，访问 /api/health 返回 200

返回 JSON 包含 code、msg、data 三个字段

data 中包含 appName、version、time、status 四个字段

status 为 "UP"，time 为当前时间

appName 和 version 正确从配置文件读取