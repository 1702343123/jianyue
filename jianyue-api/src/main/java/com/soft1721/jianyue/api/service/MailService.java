package com.soft1721.jianyue.api.service;

/**
 * Created by wj on 2019/4/15.
 */
public interface MailService {
    /**
     * 发送简单邮件
     */
    void sendMail(String to,String subject,String content);
}
