package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Comment;
import com.soft1721.jianyue.api.entity.vo.CommentVO;

import java.util.List;

/**
 * Created by wj on 2019/4/8.
 */
public interface CommentService {
    /**
     * 根据id查询评论
     * */
    List<CommentVO> selectCommentsByAId(int aId);
    /**
     * 添加
     * */
    void addComment(Comment comment);
}
