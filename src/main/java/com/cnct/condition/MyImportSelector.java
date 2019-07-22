package com.cnct.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 */
public class MyImportSelector implements ImportSelector {


    /**
     *
     * @param importingClassMetadata 当前标注了@Import注解的类的所有注解信息
     * @return 要导入到容器中的组件的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {


        // 可以返回空数组，但不能返回null
        return new String[]{"com.cnct.bean.Blue","com.cnct.bean.Yellow"};
    }
}
