package com.example.springcache.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * @author Jianping Yu
 * @date 2020/10/14
 */
@Data
@ConfigurationProperties(prefix = "person")
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String name;
    private Integer age;
    private Integer id;
}
