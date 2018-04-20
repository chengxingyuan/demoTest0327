package com.cxy.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


/**
 * @author chengxy
 * @date 2018/4/20 12:36
 */
@Component
public class Alipay {

    private Logger logger = LoggerFactory.getLogger(Alipay.class);

    String APP_ID = "2088612395294940";
    String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKRXiGKMPuZcjUnnKlr8I39f6luJoy11eMLjwQav6eiHVHPVC20/Gs8i8UlSJckaeWD0bHmo6u3AsWU96KL2Y+OMmWuUFVAwJ8e5Dj7PfG0YjyXz337SLcwkjJz72Kj+LbECfR0zieVRon04k48SFE3HZ3KCIaySF4oIpX04rnHImVTxhiZr7JTKz9pV4cA2t19IALjgeSw9CTVPxW2dgcZ7HI9axrkcHHCEmLQkS/DiL3KZhJpmgEBmYWJLwfhxD7d8xMovxWKNdPW2dwIL8FwjBHtyaqClev1rSYE+edNVeQAX0H/es20M/7Wc3Kf9+hJF1YUX1MSbsn/T0PhfcTAgMBAAECggEABAEjDm+bzQmxmUbFdzrx2wEK0O3ZuWM3K94i6y7OFPVKwDdsYP8eXq3c4zG2fwvQ2K20lQ9K1pGU2J6xMTtSMLcgT3cqBzZBGi3R8mfofR+QYcSUXNvHSLFvvjh/+sVUApgjLxZ460z3pvOfY8DH/+CKpcTJyBDPIVk06Ho96ZeFCnkOyyzRzXeVueJ/k80lDBQCk1u+lyRfnW5S01Dwmu2yejXFOsPx3O3QS2JZL9eqBPRZmpsfWi1SfIaU7X2niH02ySde5bhgoBsKHqzvtkCaW/wUUIsvPJ0TKeMVGL/EJz8WNMjR2BVautmpqMrQH9dyGN8RHn+Djp/yPUapsQKBgQDOoQI6PtIfatK4bIuChI7zlaaTFFzsdzFaf/YKpL9I9aDQCIC7UNkYECzAwREs5RMgOz7sTjWtzOyPo1qk5FkvSKWMTqv91MQiiRuZNa8vmd3fWQUmrY4tCKAf//RegQ+tpWGq9IPIcALjh9vqLH7rFAJ8Ocxh1f4oj6grhLDDFQKBgQCrTzH9q1IhWoM8ZNSaRRTcD6Oe0jEc4F18k4OYuWs6MhDgJVAPg8S3n7O3BszvocGSKWNyqiUzbk9uEpyTT1UgzW0wS+dXYNm7/iJfIGeG5gyygWJhjfOy6HPYcYPAs+d/bY8rYhuiyiZLYNNVZMBcDMkjKsWUpFagEHEBu0R7hwKBgCulIMZSzKlsM/RWoSVBgLx86MF6dKJSDu+xxbO71te/Ymdu1Fo8mo6VpA5W+ZzFCkQtn33kizwZ5AH3HEdmIFx3eNhpKbUlAwTUdyrmhwmD87SgphDkafqjLsdzlhd8JWalXzrwCQIGfuW2pcISAgD/qgK5Zq1nuRayOXBvx7J9AoGAA3CfrFxYVdsfb4MG0eI5PQIDYxkNa2sF9Y5wwgxXHuAKfrXBGc6nkJhgX3h/fQBehrTWDmNkQ9gfODKfekXJi9MUMjgT+Sk0thWwUwCvk4HjF2KJuzPChQEt8la1MpVqPKDSkyhxLZ+pjTHwjHJtemu3TkF5njZ+ltA9tK8x/NkCgYAy2Ca9UlBpVcT5N4wvgYIdIacGHp9WM/7bIiUW6BZDaniitPIiuMhzJX/KtdOtILr65bJgaW0ouroLD5Nc5u4JnM2DLnmS//KE2ddNh8GwIylegiMF1bMg+ywrQzsjk05jwBrpju9+RNaDkAHWxm5WtDXcwr83E11Ub5Ned/KQbw==";
    String CHARSET = "utf-8";
    String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAikV4hijD7mXI1J5ypa/CN/X+pbiaMtdXjC48EGr+noh1Rz1QttPxrPIvFJUiXJGnlg9Gx5qOrtwLFlPeii9mPjjJlrlBVQMCfHuQ4+z3xtGI8l899+0i3MJIyc+9io/i2xAn0dM4nlUaJ9OJOPEhRNx2dygiGskheKCKV9OK5xyJlU8YYma+yUys/aVeHANrdfSAC44HksPQk1T8VtnYHGexyPWsa5HBxwhJi0JEvw4i9ymYSaZoBAZmFiS8H4cQ+3fMTKL8VijXT1tncCC/BcIwR7cmqgpXr9a0mBPnnTVXkAF9B/3rNtDP+1nNyn/foSRdWFF9TEm7J/09D4X3EwIDAQAB";

    public void useAliPay(String orderId,BigDecimal totalAmount,String goodsTitle) throws AlipayApiException {
        //实例化客户端
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, "RSA2");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify
        AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
        //SDK已经封装掉了公共参数，这里只需要传入业务参数
        //此次只是参数展示，未进行字符串转义，实际情况下请转义  product_code  2088612395294940
        request.setBizContent("  {" +
                "    \"total_amount\":" + totalAmount + "," +
                "    \"out_trade_no\":" + orderId + "," +
                "    \"subject\":"+goodsTitle +"," +
                "    \"seller_id\":\"2088612395294940\"," +
               // "    \"product_code\":\"www.tticar.com\"," +
                "    \"quit_url\":\"www.tticar.com\"" +
                " }");
        AlipayOpenPublicTemplateMessageIndustryModifyResponse response = alipayClient.execute(request);
        //调用成功，则处理业务逻辑
        if (response.isSuccess()) {
            //.....
        } else {
            logger.info("错误代码：" + response.getCode(), response.getBody());
            logger.info("请求支付宝支付失败，返回明细：{}", response.getSubCode() + response.getSubMsg());
        }
    }
}
