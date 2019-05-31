package com.thd;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;



 

//囊括@SpringBootConfiguration @EnableAutoConfiguration  @ComponentScan   三个注释
@SpringBootApplication(scanBasePackages = "com.thd")


//开启扫描@Transactional   数据库事务
@EnableTransactionManagement

//------------------  加载配置文件 -----------------//
@PropertySource(value={"classpath:config/application.yml"},encoding="utf-8") 

@MapperScan("com.thd.mybatis.mapper")
public class Application extends SpringBootServletInitializer {


	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	
	
	
	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled", "false");
	    SpringApplication.run(Application.class, args);
	}
	
	
}
