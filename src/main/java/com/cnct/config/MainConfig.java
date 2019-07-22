package com.cnct.config;

import com.cnct.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 用注解方式代替之前的xml配置文件方式
 * 配置类 = 配置文件
 */

@Configuration  // @Configuration 表示当前类为一个配置类
/*
 @ComponentScan 包扫描 value:指定要扫描的包
 excludeFilters = Filter[]  指定扫描时按照什么规则排除哪些类
 FilterType.ANNOTATION 按照注解方式
 FileterType.ASSIGNABLE_TYPE 按照给的的类型
 FileterType.ASPECTJ 使用ASPECTJ表达式
 FileterType.REGEX 使用正则表达式
 FileterType.CUSTOM 自定义规则 要写一个TpyeFilter的实现类

 includeFilters = Filter[]  指定扫描时只需要包含哪些类
 useDefaultFilters = false 禁用默认的过滤规则

 */
@ComponentScan(value = "com.cnct",includeFilters = {
        //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyTypeFilter.class)
},useDefaultFilters = false)
public class MainConfig {

    /*
    @Bean注解：给容器中注册一个Bean
    Bean的类型为方法的返回值类型 id默认用方法名作为id
    相当于：配置文件中的
    <bean id="xxx" class="xxx.xxx.xxx">
        <property name="xxx" value="xx"/>
    </bean>
     */
    @Bean
    public Person person(){
        return new Person("刘智文", 20);
    }

}
