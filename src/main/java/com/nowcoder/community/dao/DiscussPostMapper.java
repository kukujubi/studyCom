package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit,int orderMode);//每一页起始行的行号，这一页最多显示多少行
    //分页的时候要知道一共有多少条数据 / 一页多少行 =页数
    //@Param注解用于给参数取别名，如果只有一个参数，并且在<if>里使用，则必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);//如果需要动态的拼条件 并且方法里只有一个条件 必须取别名@Param

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id,int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);

}

