package com.cnct.bean;

import org.springframework.beans.factory.annotation.Value;


public class Person {

    /*
    使用@Value注解给属性赋值 相当于xml配置文件中<bean>标签中<property>标签
    1.基本数值
    2.可以写spEL：#{}
    3.可以写${}，取出配置文件中[properties]的值(在运行环境变量里面的值)
     */

    @Value("李四")
    private String name;
    @Value("#{36-5}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;

    public Person() {
        super();
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age,String nickName) {
        this.name = name;
        this.age = age;
        this.nickName = nickName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
