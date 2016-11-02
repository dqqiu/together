# together
		together:整合实际项目中所用到的技术，项目基于SpringBoot框架开发。包含自定义代码生成器、shiro、redis等的封装和实现
		
## 相关说明
Swagger2接口文档地址：http://{项目部署机器IP}:{项目占用端口}/{项目名}/swagger-ui.html
		
## 数据库安装说明
		数据库脚本保存位置在references/database文件夹中，其中init_schema.sql为建库语句，包含建立的用户和权限，目前只需执行此脚本即可，其它脚本后期集成flyway数据库脚本迁移时，将自动生成。