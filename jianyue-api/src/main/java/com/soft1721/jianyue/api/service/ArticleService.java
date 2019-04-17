package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;

import java.util.List;

/**
 * Created by wj on 2019/4/8.
 */
public interface ArticleService {
    /**
     * 查询全部文章
    * */
    List<ArticleVO> selectAll();
    /**
     * 根据id查询文章
     * */
    ArticleVO getArticleById(int aId);
    /**
     * 写文章
     * */
    void insertArticle(Article article);
    /**
     * 根据id查询title
     * */
    List<ArticleVO> getArticleByUId(int uId);
    /**
     * 根据id删除文章
     * */
    void deleteArticleById(int aId);
}
