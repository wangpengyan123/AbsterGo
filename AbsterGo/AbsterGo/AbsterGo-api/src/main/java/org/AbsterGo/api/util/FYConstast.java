package org.AbsterGo.api.util;

import java.math.BigDecimal;



public class FYConstast {
	/** 商户代码、商户号 **/
	public final static String key = "0006510F0093601";

	//public final static String key = "0001000F0279967";
	
	
	public final static String plain = "plain";

	public final static String signature = "signature";

	public final static String resp_code = "resp_code";

	public final static String right_result = "0000";

	public final static String account_result = "5343";

	public final static String message_ID = "openAccount";

	public final static String loan_message_ID = "buyLoan";

	public final static String CASH = "cash";

	public final static String des_key = "156873c93262d8d16716aac54b444c6d";

	public final static String userid = "jzh05";


//	public final static String jzh_url = "http://116.239.4.195:9056/jzh";

	//public final static String userid = "HSHT001K";


	/** 充值方式--商户端个人用户跳转登录页面（网页版）--快速充值 **/

	/** 定义map中返回xml的key值 **/
	public final static String RESP_XML = "resp_xml";
	/** 充值方式--商户端个人用户跳转登录页面（网页版）--快速充值 **/

	public final static String RECHARGE_TYPE_WEBLOGIN_KUAISU = "webLogin-kuaisu";
	/** 充值方式--商户端个人用户跳转登录页面（网页版）--网银充值 **/
	public final static String RECHARGE_TYPE_WEBLOGIN_WANGYIN = "webLogin-wangyin";
	/** 充值方式--商户端个人用户跳转登录页面（网页版）--手机认证 **/
	public final static String RECHARGE_TYPE_WEBLOGIN_PHONE = "webLogin-phone";
	/** 充值方式--商户P2P网站免登录快速充值接口 **/
	public final static String RECHARGE_TYPE_KUAISU = "kuaisu";
	/** 充值方式--商户P2P网站免登录网银充值接口 **/
	public final static String RECHARGE_TYPE_WANGYIN = "wangyin";
	/** 成功登录后跳转页面代码--快速充值 **/
	public final static String WEBLOGIN_LOCATION_KUAISU = "0020";
	/** 成功登录后跳转页面代码--提提现 **/
	public final static String WEBLOGIN_LOCATION_CACHE = "0022";
	/** 成功登录后跳转页面代码--网银充值 **/
	public final static String WEBLOGIN_LOCATION_WANGYIN = "0024";
	/** 成功登录后跳转页面代码--手机认证 **/
	public final static String WEBLOGIN_LOCATION_PHONE = "1001";
	/** 客服电话 **/
	public final static String SERVICE_PHONE = "400-8771-888";
	/** 划拨查询 **/
	public final static String BUSI_TP_03 = "PW03";
	/*** 交易状态 ***/
	public final static String TXN_ST_SUCCESS = "1";

	/** 充值服务-个人网银 */
	public final static String RECHARGE_SERVICE_PERSON_WANGYIN = "personWangyin";
	/** 充值服务-手机快捷 ***/
	public final static String RECHARGE_SERVICE_PHONE = "phone";
	/** 充值服务-企业网银 ***/
	public final static String RECHARGE_SERVICE_ENTERPRISE_WANGYIN = "enterpriseWangyin";
	/** 充值服务-快速充值-(IVR语音、终端签约、手机签约、协议终端) ***/
	public final static String RECHARGE_SERVICE_KUAISU = "kuaisu";
	/** 增值服务-委托充值 ***/
	public final static String RECHARGE_SERVICE_WEITUO = "weituo";

	/** 充值服务-个人网银 费率 ***/
	public final static BigDecimal RATE_PERSON_WANGYIN = BigDecimal.valueOf(0.0023);
	/** 充值服务-手机快捷 费率 2元起 ***/
	public final static BigDecimal RATE_PHONE = BigDecimal.valueOf(0.004);
	/** 充值服务-企业网银 15元/笔 ***/
	public final static BigDecimal RATE_ENTERPRISE_WANGYIN = BigDecimal.valueOf(15);
	/** 充值服务-快速充值-(IVR语音、终端签约、手机签约、协议终端) 5元起、80元封顶 ***/
	public final static BigDecimal RATE_KUAISU = BigDecimal.valueOf(0.001);
	/** 增值服务-委托充值 5元起 ***/
	public final static BigDecimal RATE_WEITUO = BigDecimal.valueOf(0.001);
	/** 增值服务-提现手续费 3元起 ***/
	public final static BigDecimal CASH_FEE = BigDecimal.valueOf(3);
}
