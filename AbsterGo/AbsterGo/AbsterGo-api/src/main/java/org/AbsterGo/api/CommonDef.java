package org.AbsterGo.api;

/**
 * 各种常量定义
 * 
 * 
 */
public interface CommonDef {
	/**网站用户名称**/
	public static final String WEBSITE_NAME_CN = "八点金融";
	/**第三方支付名称**/
	public static final String PAYPROVIDERCN = "富友";
	/**服务电话**/
	public static final String SERVICE_PHONE = "4000-928-999";
	/**发送邮箱**/
	public static final String SERVICE_EMAIL = "";
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	/**
	 * 刪除失敗
	 */
	public static final int DELETE_FAIL = -1;

	/**
	 * 刪除成功
	 */
	public static final int DELETE_SUCCESS = 1;

	/**
	 * 更新失敗
	 */
	public static final int UPDATE_FAIL = -1;

	/**
	 * 更新成功
	 */
	public static final int UPDATE_SUCCESS = 1;
	/**
	 * 消息类型定义开始
	 */
	/**
	 * 充值
	 */
	public static final short INNER_MAIL_TYPE_RECHARGE = 100;
	/**
	 * 投资人投资成功
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_SUCCESS = 101;

	/**
	 * 站内信类别-投资人-新回款
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_MONEYREPAY = 102;

	/**
	 * 站内信类别-投资人-资金解冻
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_MONEYBACK = 103;

	/**
	 * 站内信类别-投资人-出借成功
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_INVESTSUCCESS = 104;

	/**
	 * 站内信类别-投资人-留言被回复
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_GETMESSAGE = 105;

	/**
	 * 站内信类别-投资人-其他
	 */
	public static final short INNER_MAIL_TYPE_INVESTOR_OTHER = 199;

	/**
	 * 站内信类别-借款人-成功满额
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_SUCCESS = 201;

	/**
	 * 站内信类别-借款人-审核未通过
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_NOPASS = 202;

	/**
	 * 站内信类别-借款人-借款项目未满额
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_NOFULL = 203;

	/**
	 * 站内信类别-借款人-还款提醒
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_PAY = 204;

	/**
	 * 站内信类别-借款人-逾期通知
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_LATEPAY = 205;
	/**
	 * 站内信类别-借款人-审核通过
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_PASS = 206;

	/**
	 * 站内信类别-投资人-债权转出
	 */
	public static final short RIGHTS_ROLL_OUT = 207;

	/**
	 * 站内信类别-投资人-债权买入
	 */
	public static final short RIGHTS_BUY_IN = 208;

	/**
	 * 站内信类别-投资人-债权卖出
	 */
	public static final short RIGHTS_BUY_OUT = 209;

	/**
	 * 站内信类别-借款人-新还款
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_MONEYREPAY = 210;

	/**
	 * 站内信类别-借款人-其他
	 */
	public static final short INNER_MAIL_TYPE_BORROWER_OTHER = 299;

	/**
	 * 站内信类别-红包
	 */
	public static final short INNER_MAIL_TYPE_REDMONEY = 300;
	/**
	 * 站内信类别-个人喜好
	 */
	public static final short INNER_MAIL_TYPE_HOBBY = 301;
	/**
	 * 站内信类别-注册红包
	 */
	public static final short INNER_MAIL_TYPE_REDMONEY_REGISTER = 302;
	/**
	 * 站内信类别-邀请好友红包
	 */
	public static final short INNER_MAIL_TYPE_REDMONEY_INVITE = 303;
	/**
	 * 站内信类别-网站活动
	 */
	public static final short INNER_MAIL_TYPE_ACTIVITY = 304;

}
