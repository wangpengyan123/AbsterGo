package org.AbsterGo.api;
/**
 * pdf常用常量
 * 
 * 八点金融p2p平台
 * @author chenyuezhi
 * @time 2016年1月11日-下午8:08:03
 * 2016恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
public class PdfConstants {
	/**借款合同模板名称**/
	public static String PDF_TEMPLATE_JKHT = "借款合同.pdf";
	/**借款合同模板路径***/
	public static String PDF_PATH = "pdfTemplate";
	//////参数
	/**合同编号**/
	public static String PDF_PARAM_HTBH="htbh";
	/**签署日期   一般取当前日期**/
	public static String PDF_PARAM_QSRQ="qsrq";
	/**出借人**/
	public static String PDF_PARAM_CJR ="cjr";
	/**出借人用户名**/
	public static String PDF_PARAM_CJR_YHM="cjr_yhm";
	/**出借人身份证号**/
	public static String PDF_PARAM_SFZH="cjr_sfzh";
	/**借款人**/
	public static String PDF_PARAM_JKR="jkr";
	/**借款人用户名**/
	public static String PDF_PARAM_JKR_YHM="jkr_yhm";
	/**借款人身份证号**/
	public static String PDF_PARAM_JKR_SFZH="jkr_sfzh";
	/**管理人-即管理公司名称  上海钦嘉金融信息服务有限公司**/
	public static String PDF_PARAM_GLR="glr";
	/**住所-即管理公司地址**/
	public static String PDF_PARAM_ZS="zs";
	/**借款本金大写**/
	public static String PDF_PARAM_JKBJ_DX="jkbj_dx";
	/**借款本金小写**/
	public static String PDF_PARAM_JKBJ_XX="jkbj_xx";
	/**借款期限**/
	public static String PDF_PARAM_JKQX="jkqx";
	/**借款开始日期**/
	public static String PDF_PARAM_JK_KSRQ="jk_ksrq";
	/**借款利率**/
	public static String PDF_PARAM_JK_LL="jk_ll";
	/**借款结束日期**/
	public static String PDF_PARAM_JK_JSRQ="jk_jsrq";
	/**借款用途**/
	public static String PDF_PARAM_JK_YT="jk_yt";
	/**还款方式 默认为第三种  数值"3"**/
	public static String PDF_PARAM_HKFS="hkfs";
	/**还款日 默认为每个月26日  数值"26"**/
	public static String PDF_PARAM_HKR="hkr";
	///债权转让部分
	/**债权转让人(甲方)**/
	public static String PDF_PARAM_DEBT_ZRR="debt_zrr";
	/**债权转让人(甲方) 身份证号码**/
	public static String PDF_PARAM_DEBT_ZRR_SFZH="debt_zrr_sfzh";
	/**债权转让人(甲方) 手机号**/
	public static String PDF_PARAM_DEBT_ZRR_SJH="DEBT_ZRR_SJH";
	/**债权受让人(乙方)（新债权人）**/
	public static String PDF_PARAM_DEBT_SRR="debt_srr";
	/**受让人身份证(乙方)**/
	public static String PDF_PARAM_DEBT_SRR_SFZH="debt_srr_sfzh";
	/**受让人手机号(乙方)**/
	public static String PDF_PARAM_DEBT_SRR_SJH="debt_srr_sjh";
	
	/**资金出借即回收方式**/
	public static String PDF_PARAM_ZJCJ_JHSFS="zjcj_jhsfs";
	/**初始出借日期**/
	public static String PDF_PARAM_CS_CJRQ="cs_cjrq";
	/**初始出借金额**/
	public static String PDF_PARAM_CS_CJJE="cs_cjje";
	/**下一个报告日 类似于 一个月后**/
	public static String PDF_PARAM_XYG_BGR="xyg_bgr";
	/**到期日期**/
	public static String PDF_PARAM_DQRQ="dqrq";
	/**到期日您预计累计资产总额**/
	public static String PDF_PARAM_DQR_ZCZE="dqr_zcze";
	
	
	//八点金融出借咨询与服务协议
	/**出借人证件类型**/
	public static String PDF_PARAM_CJR_ZJLX = "cjr_zjlx";
	/**出借人证件类型**/
	public static String PDF_PARAM_CJR_ZJH = "cjr_zjh";
	/**出借模式**/
	public static String PDF_PARAM_CJMS = "cjms";
	/**出借人证件类型**/
	public static String PDF_PARAM_SDQ = "sdq";
	/**出借本金大写**/
	public static String PDF_PARAM_CJBJ_DX = "cjbj_dx";
	/**出借本金小写**/
	public static String PDF_PARAM_CJBJ_XX = "cjbj_xx";
	/**预期年化收益率**/
	public static String PDF_PARAM_YQNHSYL = "yqnhsyl";
	//出借协议
	/**出借人手机号**/
	public static String PDF_PARAM_CJR_SJH = "cjr_sjh";
}
