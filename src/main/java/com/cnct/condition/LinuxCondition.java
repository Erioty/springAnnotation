package com.cnct.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否Linux系统
 */
public class LinuxCondition implements Condition {

    /**
     * @param context 判断条件能使用的上下文(环境)
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.获取到IOC使用的beanFactory(bean工厂)
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3.获取当前环境信息
        Environment environment = context.getEnvironment();
        // 4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        // 获取操作系统的名字
        String property = environment.getProperty("os.name");
        if(property.contains("linux")){
            return true;
        }
        return false;
    }
}
