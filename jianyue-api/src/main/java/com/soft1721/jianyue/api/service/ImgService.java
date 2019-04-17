package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.Img;

import java.util.List;

/**
 * Created by wj on 2019/4/8.
 */
public interface ImgService {
    /**
     * 根据id查询图片
     * */
    List<Img> selectImgsByAId(int aId);

    /**
     * 存入图片
     * */
    void insertImg(Img img);
}
