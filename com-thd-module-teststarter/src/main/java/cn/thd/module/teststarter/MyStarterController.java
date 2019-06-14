package cn.thd.module.teststarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author devil13th
 **/
@Controller
@RequestMapping(value="/mystarter")
public class MyStarterController {


    @Autowired
    private MyStarterBean myStarterBean;
    @RequestMapping(value="/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        return myStarterBean.sayHello(name);
    }


    public MyStarterBean getMyStarterBean() {
        return myStarterBean;
    }

    public void setMyStarterBean(MyStarterBean myStarterBean) {
        this.myStarterBean = myStarterBean;
    }

}
