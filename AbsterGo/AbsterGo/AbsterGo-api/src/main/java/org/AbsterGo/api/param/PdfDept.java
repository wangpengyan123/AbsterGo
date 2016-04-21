package org.AbsterGo.api.param;

import java.io.Serializable;

/**
 * 
 *  pdf中用于传递参数的对象
 * PdfDept  
 * chenyuezhi  
 * 2016年1月15日 下午2:48:20  
 *   
 * @version 1.0.0  
 *
 */
public class PdfDept implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**序号**/
	private String no;
	/**借款人姓名**/
	private String jkrName;
	/**借款人身份证号码**/
	private String jkrIdCardno;
	/**本次转让债权价值**/
	private String bczrDebtValue;
	/**需支付对价**/
	private String xzfdj;
	/**借款类型**/
	private String jkType;
	/**借款信息**/
	private String jkInfo;
	/**还款起始日期**/
	private String hkBeginEndTime;
	/**还款期限（月）**/
	private String hkMonths;
	/**剩余还款月数**/
	private String syhkMonths;
	/**预计债权收益率(年)**/
	private String yqDebtRate;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getJkrName() {
		return jkrName;
	}
	public void setJkrName(String jkrName) {
		this.jkrName = jkrName;
	}
	public String getJkrIdCardno() {
		return jkrIdCardno;
	}
	public void setJkrIdCardno(String jkrIdCardno) {
		this.jkrIdCardno = jkrIdCardno;
	}
	public String getBczrDebtValue() {
		return bczrDebtValue;
	}
	public void setBczrDebtValue(String bczrDebtValue) {
		this.bczrDebtValue = bczrDebtValue;
	}
	public String getXzfdj() {
		return xzfdj;
	}
	public void setXzfdj(String xzfdj) {
		this.xzfdj = xzfdj;
	}
	public String getJkType() {
		return jkType;
	}
	public void setJkType(String jkType) {
		this.jkType = jkType;
	}
	public String getJkInfo() {
		return jkInfo;
	}
	public void setJkInfo(String jkInfo) {
		this.jkInfo = jkInfo;
	}
	public String getHkBeginEndTime() {
		return hkBeginEndTime;
	}
	public void setHkBeginEndTime(String hkBeginEndTime) {
		this.hkBeginEndTime = hkBeginEndTime;
	}
	public String getHkMonths() {
		return hkMonths;
	}
	public void setHkMonths(String hkMonths) {
		this.hkMonths = hkMonths;
	}
	public String getSyhkMonths() {
		return syhkMonths;
	}
	public void setSyhkMonths(String syhkMonths) {
		this.syhkMonths = syhkMonths;
	}
	public String getYqDebtRate() {
		return yqDebtRate;
	}
	public void setYqDebtRate(String yqDebtRate) {
		this.yqDebtRate = yqDebtRate;
	}
	
}
