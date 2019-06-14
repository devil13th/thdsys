package cn.thd.module.teststarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author devil13th
 **/
@Component
public class MyStarterBean {
    @Autowired
    private MyStarterProperties myStarterProperties;

    public MyStarterBean(){
        System.out.println("自定义starter中的bean 构造");
    }

    public String sayHello(String str){
        return myStarterProperties.getWelcome() +":"+ str + " ! " + myStarterProperties.getOtherInfo() + " ||| " + myStarterProperties.getBaseInfo() ;
    }
}

