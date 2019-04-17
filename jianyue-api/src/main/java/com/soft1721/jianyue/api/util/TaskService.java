package com.soft1721.jianyue.api.util;

import com.soft1721.jianyue.api.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by wj on 2019/4/15.
 */
@Service
//@Async
public class TaskService {
    @Autowired
    private MailService mailService;

//    @Scheduled(cron = "0 0 10 * * ?")
//    public void proces(){
//        mailService.sendMail("16422802@qq.com","王杰","定时10:00发送");
//        System.out.println("111");
//    }
}