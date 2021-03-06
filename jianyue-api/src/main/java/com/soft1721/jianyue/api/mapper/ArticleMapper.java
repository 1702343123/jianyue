package com.soft1721.jianyue.api.mapper;

/**
 * Created by wj on 2019/4/8.
 */
import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleMapper {
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "u_id",property = "uId"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "avatar",property = "avatar")
    })
    @Select("SELECT a.*,b.id,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.u_id=b.id ORDER BY a.id DESC")
    List<ArticleVO> selectAll();

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "u_id",property = "uId"),
            @Result(column = "title",property = "title"),
            @Result(column = "content",property = "content"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "avatar",property = "avatar")
    })
    @Select("SELECT a.*,b.id,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.u_id=b.id WHERE a.id = #{id} ")
    ArticleVO getArticleById(int aId);

    @Insert("INSERT INTO t_article (u_id,title,content,create_time) VALUES (#{uId},#{title},#{content},#{createTime}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertArticle(Article article);

    @Select("SELECT t_article.id,t_article.title FROM t_article LEFT JOIN t_user ON t_user.id=t_article.u_id WHERE t_user.id=#{uId}")
    List<ArticleVO> getArticleByUId(int uId);

    @Delete("DELETE FROM t_article WHERE id=#{id}")
    void deleteArticleById(int aId);
}



