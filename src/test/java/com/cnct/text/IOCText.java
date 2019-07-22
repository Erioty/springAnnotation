package com.cnct.text;

import com.cnct.bean.Person;
import com.cnct.config.MainConfig;
import com.cnct.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCText {
    // IOC容器
    AnnotationConfigApplicationContext acf = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        printBeans(acf);
    }

    public void printBeans(AnnotationConfigApplicationContext acf ){
        String[] beanDefinitionNames = acf.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }

        // 工厂Bean获取的是 调用getObject()创建的对象
        Object colorFactoryBean = acf.getBean("colorFactoryBean");
        Object colorFactoryBean2 = acf.getBean("colorFactoryBean");
        System.out.println("Bean的类型："+colorFactoryBean.getClass());
        System.out.println(colorFactoryBean == colorFactoryBean2);
        Object colorFactoryBean3 = acf.getBean("&colorFactoryBean");
        System.out.println("工厂Bean:"+colorFactoryBean3.getClass());
    }

    @Test
    public void test03(){
        String[] beanDefinitionNames = acf.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
        Map<String, Person> persons = acf.getBeansOfType(Person.class);
        System.out.println(persons);
        // 动态获取环境变量的值
        ConfigurableEnvironment environment = acf.getEnvironment();
        // windows 7
        String property = environment.getProperty("os.name");
        System.out.println(property);
    }

    @Test
    public void test02(){
        // IOC容器
        AnnotationConfigApplicationContext acf = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*String[] beanDefinitionNames = acf.getBeanDefinitionNames();
        // 查看容器中的所有组件
        for (String name: beanDefinitionNames){
            System.out.println(name);
        }*/
        System.out.println("ICO容器创建完成");
        // 默认都是单例的
        Object person = acf.getBean("person");
        Object person2 = acf.getBean("person");
        System.out.println(person == person2);
    }


    /**
     * 测试注解方式的包扫描
     * 在配置类中写 @ComponentScan(value = "com.cnct")注解
     * com.cnct包下的标注了@Controller、@Service、@Repository、@Componet的类都会被加入到容器中
     */
    @Test
    public void test01(){
        // IOC容器
        AnnotationConfigApplicationContext acf = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = acf.getBeanDefinitionNames();
        // 查看容器中的所有组件
        for (String name: beanDefinitionNames){
            System.out.println(name);
        }
    }



}
