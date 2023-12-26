package com.yangfan.playground;

import com.yangfan.playground.xjb.design.proxy.RealImage;
import com.yangfan.playground.xjb.design.proxy.aop.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class PlaygroundApplication {
    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(PlaygroundApplication.class);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);
        System.out.println("Hello world!");


        ConfigurableApplicationContext context = SpringApplication.run(PlaygroundApplication.class, args);
//        RealImage realImage = context.getBean(RealImage.class);
//        realImage.display();
        MyService myService = context.getBean(MyService.class);
        myService.performAction();


    }

}
