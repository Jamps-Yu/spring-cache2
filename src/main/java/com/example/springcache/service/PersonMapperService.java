package com.example.springcache.service;

import com.example.springcache.bean.Person;
import com.example.springcache.mapper.PersonMapper;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author Jianping Yu
 * @date 10/27/2020
 */
@Service
@CacheConfig(cacheNames = {"person"})
public class PersonMapperService {
    @Resource
    PersonMapper pm;


    @Cacheable(cacheNames = {"person"})
    public Person selectById(Integer id){
        System.out.println("not use cache ,person="+pm.selectById(id));
        return pm.selectById(id);
    }
    @CachePut(cacheNames = {"person"},key = "#pp.getId()")
    public Person updateById(Person pp){
        System.out.println("cache put running");

        pm.updateById(pp);
        return pp;
    }
    @CachePut(cacheNames = {"person"},key = "#pp.getId()")
    public Person insert(Person pp){
        System.out.println("cache insert running");
         pm.insert(pp);
        return pp;
    }
    @CacheEvict(cacheNames = {"person"})
    public int deleteById(Integer id){
        System.out.println("cache Evict running");
        return pm.deleteById(id);
    }

    @Bean
    public CacheManager cacheManager() {

        Cache cache = new ConcurrentMapCache("person");

        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Arrays.asList(cache));

        return manager;
    }
}
