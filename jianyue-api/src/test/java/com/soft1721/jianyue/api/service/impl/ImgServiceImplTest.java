package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.Img;
import com.soft1721.jianyue.api.service.ImgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by wj on 2019/4/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImgServiceImplTest {
    @Resource
    private ImgService imgService;

    @Test
    public void insertImg() throws Exception {
        Img img=new Img();
        img.setAId(3);
        img.setImgUrl("http://img4.imgtn.bdimg.com/it/u=3336693946,3187478344&fm=26&gp=0.jpg");
        imgService.insertImg(img);
    }

}