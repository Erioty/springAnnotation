package com.cnct.text;

import com.cnct.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {


    @Test
    public void test01(){
        // 1.创建IOC容器
        AnnotationConfigApplicationContext annotation = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        // IOC容器创建完成就会将单例的Bean加进容器中
        System.out.println("IOC容器创建完成");
        //关闭容器时调用destroy方法
        annotation.close();

    }
}
