package com.soft1721.jianyue.api.controller;

/**
 * Created by wj on 2019/4/8.
 */
import com.aliyun.oss.OSSClient;
import com.soft1721.jianyue.api.entity.Article;
import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.vo.ArticleVO;
import com.soft1721.jianyue.api.entity.vo.CommentVO;
import com.soft1721.jianyue.api.service.ArticleService;
import com.soft1721.jianyue.api.service.CommentService;
import com.soft1721.jianyue.api.service.FollowService;
import com.soft1721.jianyue.api.service.ImgService;
import com.soft1721.jianyue.api.util.MsgConst;
import com.soft1721.jianyue.api.util.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@RestController
@RequestMapping(value = "/api/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;
    @Resource
    private CommentService commentService;
    @Resource
    private FollowService followService;
    @Resource
    private ImgService imgService;

    @GetMapping(value = "/list")
    public ResponseResult getAll() {
        List<ArticleVO> articleList = articleService.selectAll();
        return ResponseResult.success(articleList);
    }

    @GetMapping(value = "/{aId}")
    public ResponseResult getArticleById(@PathVariable("aId") int aId,@RequestParam("userId") int userId) {
        ArticleVO article = articleService.getArticleById(aId);
        int toUId = article.getUId();
        Map<String, Object> map = new HashMap<>();
        Follow follow = followService.getFollow(userId, toUId);
        if (follow != null) {
            map.put("followed", MsgConst.FOLLOWED);
        } else {
            map.put("followed", MsgConst.NO_FOLLOWED);
        }
        List<CommentVO> comments = commentService.selectCommentsByAId(aId);
        map.put("article", article);
        map.put("comments", comments);
        return ResponseResult.success(map);
    }

    //新增文章
    @PostMapping("/add")
    public ResponseResult postArticle(@RequestParam("uId") int uId,
                                      @RequestParam("title") String title,
                                      @RequestParam("content") String content) {
        Article article = new Article();
        article.setUId(uId);
        article.setTitle(title);
        article.setContent(content);
        article.setCreateTime(new Date());
        articleService.insertArticle(article);
        //新增文章后，将获取到的自增主键返回给客户端，方便图片地址的写入
        return ResponseResult.success(article.getId());
    }
    //根据id查询文章title
    @GetMapping("/user")
    public ResponseResult getArticleByuId (@RequestParam("uId") int uId) {
        List<ArticleVO> articleList=  articleService.getArticleByUId(uId);
        return ResponseResult.success(articleList);
    }
    //根据id删除文章
    @DeleteMapping("/delete")
    public ResponseResult deleteArticle(int aId){
        articleService.deleteArticleById(aId);
        return ResponseResult.success();
    }

}