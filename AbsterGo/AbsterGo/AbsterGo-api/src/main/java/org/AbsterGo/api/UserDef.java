package org.AbsterGo.api;


/**
 * 用户常量定义
 * 
 * 
 */
public interface UserDef {


	/**
	 * 用户角色 不区分投资借款人
	 */
	public final static short ROLE_ALL = 0;
	/**
	 * 用户角色-投资人
	 */
	public final static short ROLE_INVESTOR = 1;

	/**
	 * 用户角色-借款人
	 */
	public final static short ROLE_BORROWER = 2;

	/**
	 * 用户角色-企业
	 */
	public final static short ROLE_BIZ = 3;
	/**
	 * 用户角色-担保人
	 */
	public final static short ROLE_SURETY = 4;

	public static final boolean GENDER_MALE = true;

	public static final boolean GENDER_FEMALE = false;

	/**
	 * 系统中转账户的用户id
	 */
	public final static int COMPANY_TRANSIT_USER_ID = 1;

	/**
	 * 系统中转账户的用户昵称
	 */
	public final static String COMPANY_TRANSIT_USER_NICKNAME = CommonDef.WEBSITE_NAME_CN
			+ "账户";

	/**
	 * 系统风险保证金账户的用户id
	 */
	public final static int COMPANY_RISK_ACCOUNT_USER_ID = 2;

	/**
	 * 系统风险保证金账户的用户昵称
	 */
	public final static String COMPANY_RISK_ACCOUNT_USER_NICKNAME = "风险保证金账户";

	/**
	 * 平台收入账户的用户id
	 */
	public final static int COMPANY_PLATFORM_INCOME_USER_ID = 3;

	/**
	 * 平台收入账户的用户昵称
	 */
	public final static String COMPANY_PLATFORM_INCOME_USER_NICKNAME = "平台收入账户";

	/**
	 * 第三方充值账户的用户id
	 */
	public final static int COMPANY_PLATFORM_RECHARGE_USER_ID = 4;

	/**
	 * 第三方充值账户的用户昵称
	 */
	public final static String COMPANY_PLATFORM_RECHARGE_USER_NICKNAME = CommonDef.PAYPROVIDERCN
			+ "充值账户";

	/**
	 * 富友银行代扣账户的用户id
	 */
	public final static int COMPANY_PLATFORM_WITHHOLD_USER_ID = 5;

	/**
	 * 富友银行代扣账户的用户昵称
	 */
	public final static String COMPANY_PLATFORM_WITHHOLD_USER_NICKNAME = CommonDef.PAYPROVIDERCN
			+ "代扣账户";

	/**
	 * 平台手续费账户的用户id（针对债权交易）
	 */
	public final static int COMPANY_PLATFORM_TRADE_INCOME_USER_ID = 6;

	/**
	 * 平台手续费账户的用户昵称（针对债权交易）
	 */
	public final static String COMPANY_PLATFORM_TRADE_INCOME_USER_NICKNAME = "平台手续费账户";

	/**
	 * 刚注册，没通过任何验证
	 */
	public final static short STATUS_NEW_REGISTERED = 0;

	/**
	 * 只通过邮件验证
	 */
	public final static short STATUS_ONLY_MAIL = 10;

	/**
	 * 邮件+手机验证
	 */
	public final static short STATUS_MAIL_MOBILE = 20;

	/**
	 * 邮件+手机+身份证
	 */
	public final static short STATUS_MAIL_MOBILE_ID = 30;

	/**
	 * 没有任何禁止项目
	 */
	public final static short FORBID_STATUS_NEW_REGISTERED = 0;

	/**
	 * 禁止评论
	 */
	public final static short FORBID_STATUS_NO_COMMENT = 10;

	/**
	 * 禁止投标
	 */
	public final static short FORBID_STATUS_NO_INVEST = 20;

	/**
	 * 禁止借款
	 */
	public final static short FORBID_STATUS_NO_BORROW = 30;

	/**
	 * 禁止评论，借入
	 */
	public final static short FORBID_STATUS_NO_COMMENT_BORROW = 40;

	/**
	 * 禁止评论，投标
	 */
	public final static short FORBID_STATUS_NO_COMMENT_INVEST = 50;

	/**
	 * 禁止评论，投标和借入
	 */
	public final static short FORBID_STATUS_NO_COMMENT_INVEST_BORROW = 60;

	/**
	 * 教育水平
	 */
	public final static String[][] EDU_LEVEL = { { "10", "小学" },
			{ "20", "初中" }, { "30", "中专" }, { "40", "高中" }, { "50", "大专" },
			{ "60", "本科" }, { "70", "硕士" }, { "80", "博士" }, { "90", "其他" } };

	/**
	 * 联系人与借款人关系－父母
	 */
	public final static short CONTACT_RELEATION_PARENTS = 100;

	/**
	 * 联系人与借款人关系－夫妻，配偶
	 */
	public final static short CONTACT_RELEATION_SPOUSE = 200;

	/**
	 * 联系人与借款人关系－子女
	 */
	public final static short CONTACT_RELEATION_CHILDREN = 300;

	/**
	 * 联系人与借款人关系－兄弟姐妹
	 */
	public final static short CONTACT_RELEATION_BROTHER_SISTER = 400;

	/**
	 * 联系人与借款人关系－朋友
	 */
	public final static short CONTACT_RELEATION_FRIEND = 500;

	/**
	 * 联系人与借款人关系－同学
	 */
	public final static short CONTACT_RELEATION_CLASSMATE = 600;

	/**
	 * 联系人与借款人关系－同事
	 */
	public final static short CONTACT_RELEATION_COLLEAGUE = 700;

	/**
	 * 联系人与借款人关系－老师
	 */
	public final static short CONTACT_RELEATION_TEACHURE = 800;

	/**
	 * 联系人与借款人关系－其他
	 */
	public final static short CONTACT_RELEATION_OTHER = 900;

	// -------提现申请状态------

	/**
	 * 提现申请-申请提交
	 */
	public final static short CASH_WITHDRAW_APPLYING = 100;

	/**
	 * 提现申请-处理完毕(审核通过)
	 */
	public final static short CASH_WITHDRAW_FINISHED = 200;

	/**
	 * 提现申请-处理完毕(审核拒绝)
	 */
	public final static short CASH_WITHDRAW_REFUSED = 300;

	/**
	 * 提现申请-处理完毕(银行退回)
	 */
	public final static short CASH_WITHDRAW_REFUNDED = 400;

}
