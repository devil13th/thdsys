package com.thd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.thd.core.dao.BaseRepositoryFactoryBean;
import com.thd.core.filter.ThreadPoolInitFilter;
import com.thd.core.filter.TimeFilter;
import com.thd.core.listener.MyListener;
import com.thd.core.redis.RedisConfig;
import com.thd.core.servlet.MyServlet;





//囊括@SpringBootConfiguration @EnableAutoConfiguration  @ComponentScan   三个注释
@SpringBootApplication(scanBasePackages = "com.thd")

//开启自动配置功能  以前我们需要配置的东西,Spring Boot帮我们自动配置
//如果有@SpringBootApplication 则下面注释可不写
//@EnableAutoConfiguration

//开启扫描@Component,@Controller,@Service,@Repository
//如果有@SpringBootApplication(scanBasePackages = "com.thd") 下面的注释可不写
//是以前的<context:component-scan>
//@ComponentScan(basePackages = {"com.thd.*"})

//注明这个类是个配置文件 继承自@Configuration，二者功能也一致  和以前的xml配置是等效的
//如果有@SpringBootApplication 则下面注释可不写
//@SpringBootConfiguration

//------------------  servlet filter listener -----------------//
//开启扫描@WebServlet,@WebListener,@WebFilter 
//等同于在web.xml中配置servlet,监听器,过滤器   Scanning for Servlets, Filters, and listeners
@ServletComponentScan


//------------------  加载配置文件 -----------------//
@PropertySource(value={"classpath:config/application.yml"},encoding="utf-8") 



public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}
	
	
	
	public static void main(String[] args) {
		//System.setProperty("spring.devtools.restart.enabled", "false");
	    SpringApplication.run(Application.class, args);
	}
	
	
}
