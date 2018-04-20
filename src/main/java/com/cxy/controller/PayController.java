package com.cxy.controller;

import com.alipay.api.AlipayApiException;
import com.cxy.utils.Alipay;
import com.cxy.utils.RequestRealIp;
import com.cxy.utils.WeixinPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author chengxy
 * @date 2018/4/20 13:39
 */
@RestController
@RequestMapping("pay")
public class PayController {
    @Autowired
    private Alipay alipay;

    @Autowired
    private WeixinPay weixinPay;

    @RequestMapping("/alipay")
    public void useAlipay() throws AlipayApiException {
        //alipay.useAliPay();
    }

    @RequestMapping("/weixinPay")
    public void weixinPay(HttpServletRequest request) throws AlipayApiException {
        String requestRealIp = RequestRealIp.getRequestRealIp(request);
        weixinPay.useWeixinPay("cxy123",new BigDecimal("20.10"),"maimai",requestRealIp);
    }
}
