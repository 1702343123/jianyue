package com.soft1721.jianyue.api.service.impl;

/**
 * Created by wj on 2019/4/8.
 */
import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.mapper.ArticleMapper;
import com.soft1721.jianyue.api.mapper.ImgMapper;
import com.soft1721.jianyue.api.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Resource
    private  ArticleMapper articleMapper;
    @Resource
    private ImgMapper imgMapper;
    @Override
    public List<ArticleVO> selectAll() {
        List<ArticleVO> articleVOList = articleMapper.selectAll();
        for (ArticleVO articleVO:articleVOList){
            articleVO.setImgs(imgMapper.selectImgsByAId(articleVO.getId()));
        }
        return articleVOList;
    }

    @Override
    public ArticleVO getArticleById(int aId) {
        return articleMapper.getArticleById(aId);
    }

    @Override
    public void insertArticle(Article article) {
        articleMapper.insertArticle(article);
    }

    @Override
    public List<ArticleVO> getArticleByUId(int uId) {
        return articleMapper.getArticleByUId(uId);
    }

    @Override
    public void deleteArticleById(int aId) {
        articleMapper.deleteArticleById(aId);
    }


}


