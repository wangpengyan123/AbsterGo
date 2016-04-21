package org.AbsterGo.api;
/**
 * 消息发送时用到的常量类
 * 八点金融p2p平台
 * @author chenyuezhi
 * @time 2015年12月13日-下午1:55:37
 * 2015恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
public class MessageConstants {
	/* **消息类型**********************/
	
	/**短信****/
	public static final Integer MESSAGE_TYPE_SMS = 1;
	/**站内信****/
	public static final Integer MESSAGE_TYPE_INNERMAIL = 2;
	/**邮件****/
	public static final Integer MESSAGE_TYPE_EMAIL = 3;
	
	/* ****模板类型，根据该模板类型查询具体的短信、站内信、或者邮件模板***************************/
	/**提现成功**/
	public static final Integer TEMPLATE_TYPE_WITHDRAW_SUCCESS = 2;
	/**提现失败**/
	public static final Integer TEMPLATE_TYPE_WITHDRAW_FAIL = 3;
	/**充值成功**/
	public static final Integer TEMPLATE_TYPE_RECHARGE_SUCCESS = 4;
	/**充值失败**/
	public static final Integer TEMPLATE_TYPE_RECHARGE_FAIL = 5;
	/**重置登陆密码通知**/
	public static final Integer TEMPLATE_TYPE_UPDATEP_ASSWORD = 7;
	/**重置密码链接邮件***/
	public static final Integer TEMPLATE_TYPE_FORGET_PWD = 8;
	/**登陆失败**/
	public static final Integer TEMPLATE_TYPE_login_Fail = 9;
	/**注册邮箱激活**/
	public static final Integer TEMPLATE_TYPE_REGISTER_SUCCESS = 11;
	/**留言回复通知**/
	public static final Integer TEMPLATE_TYPE_LEAVE_WORD = 12;
	/**活动消息**/
	public static final Integer TEMPLATE_TYPE_ACTIVITY = 14;
	/**投资喜好消息**/
	public static final Integer TEMPLATE_TYPE_INVEST_HOBBY = 15;
	/**借款审核通过**/
	public static final Integer TEMPLATE_TYPE_BORROWING_AUDIT_THROUGH = 17;
	/**借款审核未通过**/
	public static final Integer TEMPLATE_TYPE_BORROWING_AUDIT_REJECT = 18;
	/**满标放款**/
	public static final Integer TEMPLATE_TYPE_BORROWMONEY_TO_ACCOUNT = 19;
	/**还款提醒**/
	public static final Integer TEMPLATE_TYPE_BORROWER_REIMBURSEMENT_PROMPT = 20;
	/**还款操作**/
	public static final Integer TEMPLATE_TYPE_REPAYMENT_OPERATE = 21;
	/**逾期还款提醒**/
	public static final Integer TEMPLATE_TYPE_NOTLIMIT_REIMBURSEMENT = 22;
	/**借款流标**/
	public static final Integer TEMPLATE_TYPE_FLOW_LOAN = 23;
	/**投标冻结**/
	public static final Integer TEMPLATE_TYPE_INVEST= 25;
	/**满标扣款**/
	public static final Integer TEMPLATE_TYPE_FULL_LOAN = 26;
	/**投资流标**/
	public static final Integer TEMPLATE_TYPE_INVESTMENT_FLOW_STANDARD = 27;
	/**收到还款**/
	public static final Integer TEMPLATE_TYPE_REPAY = 28;
	/**债权转让**/
	public static final Integer TEMPLATE_TYPE_DEBT_TRANSFER = 29;
	/**债权转让成功卖出**/
	public static final Integer TEMPLATE_TYPE_DEBT_SELL = 30;
	/**债权转让成功买入**/
	public static final Integer TEMPLATE_TYPE_DEBT_BUY = 31;
	/**注册送红包**/
	public static final Integer TEMPLATE_TYPE_REGISTER_GIFT_BAG = 32;
	/**邀请好友送红包**/
	public static final Integer TEMPLATE_TYPE_INVITE_GIFT_BAG = 33;
	/**自定义红包消息**/
	public static final Integer TEMPLATE_TYPE_CUSTOM_RED_MONEY = 34;
	
	/// 理财计划
	/**理财计划投标冻结**/
	public static final Integer TEMPLATE_TYPE_LC_INVEST= 59;
	/**理财计划收到还款**/
	public static final Integer TEMPLATE_TYPE_LC_REPAY = 58;


}
