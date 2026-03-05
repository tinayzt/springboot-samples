# springboot-hello 项目结构说明

## 当前项目结构

```
springboot-hello/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   └── SpringbootHelloApplication.java  # 启动类
│   │   └── resources/
│   │       ├── application.properties           # 配置文件
│   │       ├── static/                          # 静态资源目录
│   │       └── templates/                       # 模板目录
│   └── test/                                    # 测试代码
├── target/                                      # 编译输出（自动生成）
├── pom.xml                                      # Maven 配置
└── mvnw / mvnw.cmd                              # Maven 包装器
```

## 需要创建的包结构

完成 Hello 接口需要在 `src/main/java/com/example/` 下创建：

```
com/example/
├── controller/
│   └── HelloController.java    # 处理 /api/hello 请求
├── vo/
│   └── ResultVO.java            # 统一响应格式
└── SpringbootHelloApplication.java
```

## 关键文件说明

- **SpringbootHelloApplication.java**: 项目入口，包含 `main` 方法
- **pom.xml**: 管理 Spring Boot 依赖和插件
- **application.properties**: 配置端口、日志等参数
- **target/**: Maven 编译后的 `.class` 文件，无需手动修改
