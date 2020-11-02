package com.example.springcache.controller;

import com.example.springcache.bean.Person;
import com.example.springcache.mapper.PersonMapper;
import com.example.springcache.service.PersonMapperService;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jianping Yu
 * @date 2020/10/13
 */
@RestController
@RequestMapping("/t")
public class TestController {

    @Resource
    PersonMapperService pm;


    @GetMapping("hello")
    public String test(){
        return "hello";
    }
    @GetMapping("p")
    public Person testGet(@RequestParam int id){
        Person person1 = pm.selectById(id);
        System.out.println(person1);
//        System.out.println(pm.selectById(1));
        return person1;
    }
    @DeleteMapping("p")
    public String testDelete(@RequestParam int id){

        System.out.println("deleting");
        pm.deleteById(id);
        return "delete success";
    }
    @PostMapping("p")
    public String testUpdate(@RequestBody Person p){
        System.out.println("upDating");
        pm.updateById(p);
        return "upDate success";
    }
    @PutMapping("p")
    public String testInsert(@RequestBody Person p){
        System.out.println("Putting");
        pm.insert(p);
        return "insert success";
    }

    @PostMapping("ppp")
    public String testPost(@RequestBody Person person){

        System.out.println("person="+person);
        return "hello";
    }
    @PostMapping("ps")
    public String testPost(@RequestBody List<Person> persons){

        System.out.println("person="+persons);
        return "success body";
    }
}
