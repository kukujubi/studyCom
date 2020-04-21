package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHello") //自定义bean的名字
public class AlphaDaoImp implements AlphaDao {

    @Override
    public String select() {
        return "hello";
    }
}
