package com.cnct.config;

import com.cnct.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Beande生命周期：
 *      bean创建----初始化----销毁的过程
 *
 * 容器管理bean的生命周期：
 * 可以自定义初始化和销毁方法，容器在bean进项到当前生命周期时，
 * 调用自定义的初始化和销毁方法
 *
 * 单例：在容器启动时创建对象
 * 多例：在每次获取的时候创建对象
 *
 * 初始化之前：BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：对象创建完成，并赋值好，调用初始化方法
 * 初始化之后：BeanPostProcessor.postProcessAfterInitialization
 *
 * 销毁：单例Beanz在IOC容器关闭时，调用销毁方法;多例时容器不会管理这个Bean,不会调用销毁方法
 *
 * 1.指定初始化和销毁方法
 *      通过@Bean指定init-method和destroy-method(xml配置文件中的bean标签的属性)
 * 2.通过让Bean实现InitializingBean(定义初始化逻辑)和DisposableBean(定义销毁逻辑)接口
 * 3.可以使用JSR250定义的两个注解：
 *      @PostConstruct: 在Bean创建完成并且属性赋值完成，再执行初始化方法
 *      @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 * 4.BeanPostProcessor:bean的后置处理器：
 *      在bean初始化前后进行一些工作：
 *      postProcessBeforeInitialization:在初始化之前调用
 *      postProcessAfterInitialization:在初始化之后调用
 */
@Configuration
@ComponentScan("com.cnct.bean")
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
