package com.soft1721.jianyue.api.service.impl;

/**
 * Created by wj on 2019/4/10.
 */
import com.soft1721.jianyue.api.entity.Follow;
import com.soft1721.jianyue.api.service.FollowService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FollowServiceImplTest {
    @Resource
    private FollowService followService;

    @Test
    public void getFollow() {
        System.out.println(followService.getFollow(2,1));
    }

    @Test
    public void getFollowsByUId() {
        System.out.println(followService.getFollowsByUId(1));
    }

    @Test
    public void insertFollow() {
        Follow follow = new Follow();
        follow.setFromUId(2);
        follow.setToUId(1);
        followService.insertFollow(follow);
    }

    @Test
    public void deleteFollow() {
        followService.deleteFollow(2,11 );
    }
}