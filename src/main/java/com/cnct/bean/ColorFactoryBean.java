package com.cnct.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     * @return 返回一个Color对象 这个对象会添加到容器中
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject()");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * @return 是否为单例模式
     * true:是单例 在容器中只保存一份;
     * false:多例 每次获取都会创建一个新的Bean
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
