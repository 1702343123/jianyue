package com.soft1721.jianyue.api.util;

/**
 * Created by wj on 2019/4/4.
 */
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import javafx.beans.DefaultProperty;

/**
 * 短信发送工具类
 */
public class SMSUtil {
    public static String send(String mobile) {
        DefaultProfile profile = DefaultProfile.getProfile(
                "cn-hangzhou",
                "LTAIDiTiQD3a20dY",
                "izCbGQm8YvldoOJlkY6s6PMZfI6F6c");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", "简阅");
        request.putQueryParameter("TemplateCode", "SMS_162735930");
        String verifyCode = StringUtil.getVerifyCode();
        request.putQueryParameter("TemplateParam", "{\"code\":" + verifyCode + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return verifyCode;
    }

    public static void main(String[] args) {
        System.out.println(send("18852009633"));
    }
}
