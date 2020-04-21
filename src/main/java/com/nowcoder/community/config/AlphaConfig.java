package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
//普通的配置类
public class AlphaConfig {
    //定义第三方的类

    @Bean //这个方法名是bean的名字
    public SimpleDateFormat simpleDateFormat(){//这个方法返回的对象将被装配到容器里
        return new SimpleDateFormat("yyyy MM dd HH:mm:ss");
    }

}
