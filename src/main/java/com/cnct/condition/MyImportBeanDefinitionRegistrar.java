package com.cnct.condition;

import com.cnct.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param importingClassMetadata 当前标注了@Import注解的类的所有注解信息
     * @param registry Bean定义的注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.cnct.bean.Red");
        boolean definition1 = registry.containsBeanDefinition("com.cnct.bean.Blue");
        //判断容器中是否包含这red和blue
        if (definition && definition1){
            //指定Bean定义信息:
            RootBeanDefinition root = new RootBeanDefinition(RainBow.class);
            //注册Bean并指定Bean名
            registry.registerBeanDefinition("rainBow",root);
        }
    }
}
