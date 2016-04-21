package org.AbsterGo.api;

/**
 * 红包状态
 * 八点金融p2p平台
 * @author chenyuezhi
 * @time 2015年12月7日-下午7:31:18
 * 2015恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
public interface RedMoneyDef {
	/* **********************红包状态**************************** */
	/**
	 * 未使用
	 */
	public final static Integer STATUS_NOT_USE = 20;
	/**
	 * 已使用
	 */
	public final static Integer STATUS_USED = 30;
	/**
	 * 已过期
	 */
	public final static Integer STATUS_TIME_OUT = 40;
	/* **********************红包状态**************************** */

	/* **********************红包来源**************************** */
	/**
	 * -注册
	 */
	public final static Integer SOURCE_REGISTER = 1;
	/**
	 * 邀请好友
	 */
	public final static Integer SOURCE_FRIEND = 2;
	/**
	 * 定时红包--改造为-群发红包
	 */
	public final static Integer SOURCE_TIMERREDMONEY = 3;
	/**
	 * 群发红包
	 */
	public final static Integer SOURCE_GROUPREDMONEY = 3;
	/**
	 * 固定红包-注册送红包
	 */
	public final static Integer SOURCE_CONSTANT_REGISTER_REDMONEY = 4;
	/**
	 * 固定红包-邀请好友送红包
	 */
	public final static Integer SOURCE_CONSTANT_INVITE_FRIENDS = 5;

	/**
	 * 后台管理员添加--平台奖励
	 */
	public final static Integer SOURCE_ADMIN_ADD = 6;
	/* **********************红包来源**************************** */

	/* **********************红包类型**************************** */
	/**
	 * 普通红包
	 */
	public final static Integer TYPE_COMMON = 0;
	/**
	 * 定时红包
	 */
	public final static Integer TYPE_TIMER = 1;
	/**
	 * 群发红包
	 */
	public final static Integer TYPE_GROUP = 1;
	/* **********************红包类型**************************** */
	/* ***********************红包使用范围*********************/
	/***全部项目可使用**/
	public final static Integer USER_RANGE_ALL = 1;
	/***理财项目可使用***/
	public final static Integer USER_RANGE_LI_CAI = 2;
	/***散标项目可使用***/
	public final static Integer USER_RANGE_SAN_BIAO = 3;
	/**指定项目可使用**/
	public final static Integer USER_RANGE_ZHI_DING = 4;
	/* ***********************红包使用范围*********************/
	/* ***********************时间类型*********************/
	/***有效期（天）**/
	public final static Integer TIME_TYPE_DAY = 0;
	/***起止时间***/
	public final static Integer TIME_TYPE_PERIOD= 1;
	/* ***********************时间类型*********************/
	/* ***********************推送方式*********************/
	/***站内信**/
	public final static Integer PUSH_WAY_INNERMAIL = 1;
	/***邮件***/
	public final static Integer PUSH_WAY_MAIL = 2;
	/**短信**/
	public final static Integer PUSH_WAY_SMS = 3;
	/* ***********************推送方式*********************/
	/* ********************群发方式*************************/
	/**当前页所选**/
	public final static Integer GROUP_SEND_TYPE_CURRENT_SELECTED =1;
	/****查询条件所选****/
	public final static Integer GROUP_SEND_TYPE_QUERY_SELECTED =2;
	/**全体用户*/
	public final static Integer GROUP_SEND_TYPE_ALL=3;
}
