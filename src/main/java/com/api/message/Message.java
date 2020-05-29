package com.api.message;



import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/*
 *用户：sky-吴
 *日期：2019/9/16
 */
public class Message {
	/*云智信的短信服务*/
	public static void main(String[] args) {
		String host = "http://yzxyzm.market.alicloudapi.com";
		String path = "/yzx/verifySms";
		String method = "POST";
		String appcode = "b67a36b19c4241569ad99d35e0a6504b";
		Map<String, String> headers = new HashMap<String, String>();
		//最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		querys.put("phone", "15932072636");
		querys.put("templateId", "TP18040314");
		//第二个参数是固定格式的, 不能改
		String code="自定义(字母加数字)";
		querys.put("variable", "code:"+code);
		Map<String, String> bodys = new HashMap<String, String>();


		try {
			/**
			 * AppKey：203743455     AppSecret：l96mangomp3rbfz3hgn660ukpvdajaur
			 *
			 * AppCode：b67a36b19c4241569ad99d35e0a6504b
			 *
			 *
			 * 重要提示如下:
			 * HttpUtils请从
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
			 * 下载
			 *
			 * 相应的依赖请参照
			 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
			 */
			HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			System.out.println(response.toString());
			//获取response的body
			System.out.println(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
