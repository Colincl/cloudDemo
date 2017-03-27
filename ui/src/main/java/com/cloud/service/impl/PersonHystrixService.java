package com.cloud.service.impl;

import com.cloud.entity.Person;
import com.cloud.service.PersonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")//当本方法调用失败时，调用后备方法fallbackSave
    public List<Person> save(String name){
        return personService.save(name);
    }

    public List<Person> fallbackSave(){
        List<Person> list = new ArrayList<>();
        Person p = new Person("Person Service 故障");
        list.add(p);
        return list;
    }
}
