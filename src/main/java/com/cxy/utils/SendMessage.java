package com.cxy.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author chengxy
 * @date 2018/4/18 17:18
 */
@Component
public class SendMessage {

    private Logger logger = LoggerFactory.getLogger(SendMessage.class);

    /**
     * 发送短信
     * */
    public void sendMessageToUser(String phoneNum, String code, int userType) throws ClientException {

        sendMessageByAliyunService(phoneNum,code,userType);
    }

    /**
     * 阿里云短信
     */
    public void sendMessageByAliyunService(String phoneNum, String code, int userType) throws ClientException {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "180000");
        System.setProperty("sun.net.client.defaultReadTimeout", "180000");
        //初始化ascClient需要的几个参数
        //短信API产品名称（短信产品名固定，无需修改）
        final String product = "Dysmsapi";
        //短信API产品域名（接口地址固定，无需修改）
        final String domain = "dysmsapi.aliyuncs.com";

        //cxy的accessKEY
        final String accessKeyId = "LTAIusamlKzIy3ah";
        //cxy的accessKeySecret
        final String accessKeySecret = "6pKvGeatqJ5uumW84WVshKUGKdqThS";

        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(phoneNum);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName("程兴源");
        //必填:短信模板-可在短信控制台中找到
        if (userType == 1){
            request.setTemplateCode("SMS_132391002");
        }else {
            request.setTemplateCode("SMS_132390956");
        }
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam("{ \"code\":\"" + code + "\"}");
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("cxyTest00001");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && "OK".equals(sendSmsResponse.getCode())) {
            //请求成功
            logger.info("阿里云发送短信至" + phoneNum + "成功。");
        } else {
            logger.info(sendSmsResponse.getCode());
            throw new RuntimeException("阿里云发送短信至" + phoneNum + "出错了");
        }
    }
}
