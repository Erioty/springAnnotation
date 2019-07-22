package com.cnct.config;

import com.cnct.bean.Car;
import com.cnct.bean.Color;
import com.cnct.bean.Person;
import com.cnct.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装备相关的配置类
 * 自动装配：Spring利用依赖注入(DI)完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1.@Autowired:自动注入
 *          1).默认优先按照类型去容器中找到对应的组件，找到就赋值 applicationContext.getBean(BookDao.class)
 *          2).如果找到多个相同类型的组件,则将属性名作为组件的id去容器中查找 applicationContext.getBean(bookDao)
 *          3).使用@Qualifier("bookDao")限定需要装配的组件，而不是使用属性名
 *          4).自动装配默认一定要将属性赋值好，没有就会报错。
 *              但可使用@Autowired(required = false)将自动装配改为非必须，没有的情况下则不装配
 *          5).@Primary:在没有限定前提下让Spring进项自动装配的时候，默认使用首选的Bean(在Bean的方法上写@Primary)
 *              也可以继续使用@Qualifier限定需要装配的bean
 *          BookService {
 *                @Autowired
 *                private BookDao bookDao;
 *          }
 *
 *  2.Sring还支持使用@Resource(JSR250)@Inject(JSR330)实现自动装配【java规范的注解】
 *      @Resource: 和@Autowired一样实现自动装配功能，默认按组件名称进项装配
 *                  不支持@Primary和@Autowired(required = false)功能
 *      @Inject: 需要导入javax.inject的依赖，和Autowired的功能一样,但没有required = false的功能
 *
 *  3.@Autowired可以标注在构造器，参数，方法，属性上。都是从IOC容器中获取参数组件的值
 *      1).标注在方法位置：@Bean+方法参数，参数从容器中获取。默认不写@Autowired
 *      2).标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3).放在参数位置
 *
 */
@Configuration
@ComponentScan({"com.cnct.service","com.cnct.dao","com.cnct.controller","com.cnct.bean"})
public class MainConfigOfAutowired {

    //@Primary 这个Bean为首选Bean，当容器中有多个相同类型的组件，首选@Primary标注的Bean
    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * @Bean 标注的方法创建对象时，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car){
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
