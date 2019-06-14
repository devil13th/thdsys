package cn.thd.module.teststarter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author devil13th
 **/

@Configuration
//指定用于封装配置信息的类
@EnableConfigurationProperties(value={MyStarterProperties.class})
//在IOC容器中有某个class的时候该配置类才会生效
//@ConditionalOnClass({MyStarterBean.class})
//在IOC容器中有某个叫xxx名字的配置的时候该配置类才生效
//@ConditionalOnProperty(name="myStarter")
@PropertySource(value={"classpath:config/mystarterapplication.properties"},encoding = "utf-8")
//配置该starter模块的类扫描路径
@ComponentScan(basePackages="cn.thd.module.teststarter")
public class MyStarterAutoConfiguration {

}
