package com.cnct;

import com.cnct.bean.Person;
import com.cnct.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        /*
        非注解方式，xml配置文件方式使用bean:
         */
        /*   // 指定配置文件的位置
       ClassPathXmlApplicationContext cxm = new ClassPathXmlApplicationContext("beans.xml");
       // 获取指定名字的bean
       Person bean = (Person)cxm.getBean("person");
        System.out.println(bean);
        */

        /*
        配置文件方式，要求指定配置类的类型
         */
        AnnotationConfigApplicationContext annotConfig = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person)annotConfig.getBean("person");
        System.out.println(person);

    }
}
