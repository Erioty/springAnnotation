package com.cnct.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器：初始化前后进行处理工作
 * 将后置处理器加入容器中
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化之前调用
     * @param bean 创建的实例
     * @param beanName 实例在容器中的名字
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeforeInitialization..."+bean+"=>"+beanName);
        return bean;
    }


    /**
     * 在初始化之后调用
     * @param bean 创建的实例
     * @param beanName 实例在容器中的名字
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AfterInitialization..."+bean+"=>"+beanName);
        return bean;
    }
}
