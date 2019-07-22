package com.cnct.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("cat constructor...");
    }

    /**
     * 销毁方法 容器关闭时调用(单例时)
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }

    /**
     * 初始化方法 在Bean创建完成并且赋值完成后调用
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }
}
