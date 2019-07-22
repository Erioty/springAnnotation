package com.cnct.config;

import com.cnct.bean.Color;
import com.cnct.bean.ColorFactoryBean;
import com.cnct.bean.Person;
import com.cnct.bean.Red;
import com.cnct.condition.LinuxCondition;
import com.cnct.condition.MyImportBeanDefinitionRegistrar;
import com.cnct.condition.MyImportSelector;
import com.cnct.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/*
@Configuration：表示当前类是配置类 相当于xml配置文件
 */

@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class}) //快速导入组件，id默认是组件的全类名
public class MainConfig2 {

    //默认都是单例的
    /*
    @Scope:指定作用范围
    取值：
    prototype：多例 IOC容器启动时不会调用方法创建对象，
    而是每次获取时才会调用方法创建对象，每次获取都会new对象
    singleton：单例（默认的）IOC容器启动会调用方法创建对象放到IOC容器中。
                以后每次获取都直接从容器中获取（map.get()）,不管获取几次都是同一个对象
    request：同一次请求创建一个实例
    session：同一个session创建一个实例
     */
    //@Scope("prototype")
    @Lazy
    @Bean // @Bean：把组件添加到容器中 相当于xml配置文件中的<bean></bean>标签
    public Person person(){
        System.out.println("把Person添加到容器中...");
        return new Person("周晟泽", 22);
    }

    /*
    @conditional:按照一定的条件进行判断，满足条件则给容器中注册bean

    如果操作系统是window，则注册"bill"到容器中，
    如果操作系统是linux,则注册"linus"到容器中
     */
    @Bean("bill")
    @Conditional({WindowsCondition.class})
    public Person person01(){
        return new Person("Bill", 62);
    }

    @Bean("linas")
    @Conditional({LinuxCondition.class})
    public Person person02(){
        return new Person("linas", 48);
    }

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
