package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {
    //依赖注入dao
    @Autowired
    private AlphaDao alphaDao;

    public AlphaService(){
        System.out.println("construt alphaService");
    }

    @PostConstruct //表示这个方法会在构造器之后调用 用来初始化某些数据
    public void init(){
        System.out.println("Init alphaService");
    }

    @PreDestroy //在对象销毁前调用 比如释放某些资源
    public void destroy(){
        System.out.println("destroy alphaService");
    }

    public String find(){
        return alphaDao.select();
    }
}
