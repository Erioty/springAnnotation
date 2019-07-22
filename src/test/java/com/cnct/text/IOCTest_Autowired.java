package com.cnct.text;

import com.cnct.bean.Boss;
import com.cnct.bean.Car;
import com.cnct.bean.Color;
import com.cnct.config.MainConfigOfAutowired;
import com.cnct.dao.BookDao;
import com.cnct.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    //创建IOC容器
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01(){
        BookService bean = applicationContext.getBean(BookService.class);
        System.out.println(bean);

        /*BookDao bean1 = applicationContext.getBean(BookDao.class);
        System.out.println(bean1);*/

        Boss bean1 = applicationContext.getBean(Boss.class);
        System.out.println(bean1);

        Car bean2 = applicationContext.getBean(Car.class);
        System.out.println(bean2);

        Color bean3 = applicationContext.getBean(Color.class);
        System.out.println(bean3);

        applicationContext.close();
    }

    // 打印容器中所有的Bean
    public void printsBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String names:definitionNames){
            System.out.println(names);
        }

    }
}
