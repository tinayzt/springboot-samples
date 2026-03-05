# Hello 接口规格文档

## 1. 接口定义

- **路径**: `GET /api/hello`
- **功能**: 返回欢迎信息，验证 Spring Boot 项目运行正常
- **参数**: 无
- **响应示例**:
```json
{
  "code": 200,
  "msg": "success",
  "data": "Hello Spring Boot"
}
```

## 2. 技术要求

- Spring Boot 3.x + Java 17
- 端口: 8080
- 包结构:
  - `com.example.controller.HelloController` - 控制器
  - `com.example.vo.ResultVO<T>` - 统一响应包装类

## 3. 实现要点

### ResultVO 类
```java
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
    // 提供构造方法和静态工厂方法 success(T data)
}
```

### HelloController 类
```java
@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return ResultVO.success("Hello Spring Boot");
    }
}
```

## 4. 验收标准

- 项目成功启动
- 访问 `http://localhost:8080/api/hello` 返回 200
- 响应 JSON 包含 code、msg、data 三个字段
- code=200, msg="success", data 为欢迎语字符串

## 5. AI 生成提示词

```
请生成 Spring Boot 3.x + Java 17 代码：

1. 创建 ResultVO<T> 通用响应类，包含 code、msg、data 字段，提供 success(T data) 静态方法

2. 创建 HelloController：
   - @RestController + @RequestMapping("/api")
   - GET /hello 接口返回 ResultVO<String>
   - 返回: code=200, msg="success", data="Hello Spring Boot"

包结构: controller 和 vo 包
```