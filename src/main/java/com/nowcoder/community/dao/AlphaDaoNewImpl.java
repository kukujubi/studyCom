package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary //优先被扫描到
public class AlphaDaoNewImpl implements AlphaDao {
    @Override
    public String select() {
        return "new Hello";
    }
}
