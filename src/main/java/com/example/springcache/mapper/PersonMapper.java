package com.example.springcache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springcache.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;

/**
 * @author Jianping Yu
 * @date 10/27/2020
 */
@Mapper
@CacheConfig(cacheNames = {"person"})
public interface PersonMapper extends BaseMapper<Person> {
}
