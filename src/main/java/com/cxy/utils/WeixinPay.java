package com.cxy.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;

/**
 * @author chengxy
 * @date 2018/4/20 14:30
 */
@Component
public class WeixinPay {

    private Logger logger = LoggerFactory.getLogger(WeixinPay.class);

    private static String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //微信分配的公众账号ID（企业号corpid即为此appId） wx9eac3cc489dd9429
    private static String appid = "wx9eac3cc489dd9429";
    //商品描述
    //private static String body = "wxd678efh567hg6787";
    //微信支付分配的商户号 天天爱车员工端商户号 1494971262   1241596902
    private static String mch_id = "1241596902";
    //随机字符串(加密用)
    private static String nonce_str = "cxy";

    //回调地址
    private static String notify_url = "https://pay.qq.com";
    //场景信息
    private static String scene_info = "{\"h5_info\": {\"type\":\"Wap\",\"wap_url\": \"https://pay.qq.com\",\"wap_name\": \"腾讯充值\"}}";

    //交易类型 H5支付的交易类型为MWEB
    private static String trade_type = "MWEB";

    private static String sign = "";


    public void useWeixinPay(String out_tarde_no, BigDecimal totalAmount, String body, String userIp) {
        BigDecimal totalFee = totalAmount.multiply(new BigDecimal("100"));
        int total_fee = totalFee.intValue();
        String format = "appid=" + appid +
                "&body=" + body +
                "&mch_id=" + mch_id +
                "&nonce_str=" + nonce_str +
                "&notify_url=" + notify_url +
                "&out_trade_no=" + out_tarde_no +
                "&scene_info=" + scene_info +
                "&spbill_create_ip=" + userIp +
                "&total_fee=" + total_fee +
                "&trade_type=" + trade_type +
                "&key=550e8400E29B11D4A716446655440000";
        logger.info("这是加密字符串：{}", format);
        sign = MD5Utils.MD5(format);
        logger.info(sign + "这是签名");
        //format = format + "&sign="+sign;
        String xmlString = "<xml>\n" +
                "<appid>" + appid + "</appid>\n" +
                "<body>" + body + "</body>\n" +
                "<mch_id>" + mch_id + "</mch_id>\n" +
                "<nonce_str>" + nonce_str + "</nonce_str>\n" +
                "<notify_url>" + notify_url + "</notify_url>\n" +
                "<out_trade_no>" + out_tarde_no + "</out_trade_no>\n" +
                "<spbill_create_ip>" + userIp + "</spbill_create_ip>\n" +
                "<total_fee>" + total_fee + "</total_fee>\n" +
                "<trade_type>" + trade_type + "</trade_type>\n" +
                "<scene_info>" + scene_info + "</scene_info>\n" +
                "<sign>" + sign + "</sign>\n" +
                "</xml>";

        httpUseXmlUtil(xmlString);
    }
//    public void httpUseJsonUtils(String format){
//        CloseableHttpClient httpClient = HttpClientPool.getHttpClient();
//        JSONObject jsonResult = null;
//        HttpPost method = new HttpPost(url);
//        HttpClientPool.config(method);
//        //utf-8格式编码，防止乱码
//        CloseableHttpResponse result = null;
//
//        try {
//            if (null != format) {
//                StringEntity entity = new StringEntity(format, "utf-8");
//                entity.setContentEncoding("utf-8");
//                entity.setContentType("application/json");
//                // multipart/form-data
//                method.setEntity(entity);
//            }
//            //发起请求
//            result = httpClient.execute(method);
//            url = URLDecoder.decode(url, "UTF-8");
//
//            //判断请求结果是否是200响应成功
//            if (result.getStatusLine().getStatusCode() == 200) {
//                String str = "";
//                //读取7bao接口返回过来的json字符串
//                str = EntityUtils.toString(result.getEntity(),"utf-8");
//                //将json字符串转为json对象
//                //jsonResult = JSON.parseObject(str);
//                logger.info(str.toString()+"1111111111111111");
//            }
//            if (result.getStatusLine().getStatusCode() != 200) {
//                throw new CodeAttribute.RuntimeCopyException("HTTP请求出错！！！");
//            }
//
//        } catch (exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (result != null) {
//                    result.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void httpUseXmlUtil(String xmlString) {

        CloseableHttpClient httpClient = HttpClientPool.getHttpClient();
        HttpPost method = new HttpPost(url);
        HttpClientPool.config(method);
        //utf-8格式编码，防止乱码
        CloseableHttpResponse result = null;

        try {
            if (null != xmlString) {
                StringEntity entity = new StringEntity(xmlString, "utf-8");
                entity.setContentEncoding("iso8859-1");
                entity.setContentType("text/xml");
                // multipart/form-data
                method.setEntity(entity);
            }
            //发起请求
            result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            logger.info(result.toString() + "22222222222222");
            //判断请求结果是否是200响应成功
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                //读取7bao接口返回过来的json字符串
                str = EntityUtils.toString(result.getEntity(), "utf-8");
                //将json字符串转为json对象
                //jsonResult = JSON.parseObject(str);
                logger.info(str.toString() + "1111111111111111");
            }
            if (result.getStatusLine().getStatusCode() != 200) {
                throw new CodeAttribute.RuntimeCopyException("HTTP请求出错！！！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
