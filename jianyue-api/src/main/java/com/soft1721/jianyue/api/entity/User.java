package com.soft1721.jianyue.api.entity;

/**
 * Created by wj on 2019/4/1.
 */
import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Integer id;
    private String mobile;
    private String password;
    private String nickname;
    private String token;
    private Short status;
    private Date regtime;
    private String avatar;
}
