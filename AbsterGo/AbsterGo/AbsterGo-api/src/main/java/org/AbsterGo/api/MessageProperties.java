package org.AbsterGo.api;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * 主要定义消息类常量信息 八点金融p2p平台
 * 
 * @author chenyuezhi
 * @time 2015年12月4日-下午3:44:15 2015恒实汇通公司-版权所有
 * @version 1.0.0
 *
 */
@Component
public class MessageProperties implements Serializable{

	private static final long serialVersionUID = -2247598479345277094L;
	/**短信请求接口地址*/
	private String smsUrl="http://web.duanxinwang.cc/asmx/smsservice.aspx";
	/**短信用户*/
	@Value("${smsName}")
	private String smsName; // 提交账户
	/**短信密码**/
	@Value("${smsPwd}")
	private String smsPwd; // 提交账户的密码
	/**短信签名**/
	private String smsKey="八点金融";


	/**邮件账户**/
	@Value("${serviceEmail}")
	private String serviceEmail;
	/**邮件发件人显示**/
	private String serviceEmailName="八点金融";
	/**邮件服务器**/
	@Value("${smtpServer}")
	private String smtpServer;
	/**邮件服务器端口**/
	private Integer smtpPort=25;
	/**邮件密码**/
	@Value("${smtpPassword}")
	private String smtpPassword;
	

	public String getSmsUrl() {
		return smsUrl;
	}

	public String getSmsName() {
		return smsName;
	}

	public String getSmsPwd() {
		return smsPwd;
	}


	public String getSmsKey() {
		return smsKey;
	}


	public String getServiceEmail() {
		return serviceEmail;
	}

	public String getSmtpServer() {
		return smtpServer;
	}

	public String getSmtpPassword() {
		return smtpPassword;
	}


	public String getServiceEmailName() {
		return serviceEmailName;
	}

	public Integer getSmtpPort() {
		return smtpPort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}

	public void setSmsName(String smsName) {
		this.smsName = smsName;
	}

	public void setSmsPwd(String smsPwd) {
		this.smsPwd = smsPwd;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}

	public void setServiceEmail(String serviceEmail) {
		this.serviceEmail = serviceEmail;
	}

	public void setServiceEmailName(String serviceEmailName) {
		this.serviceEmailName = serviceEmailName;
	}

	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}

	public void setSmtpPort(Integer smtpPort) {
		this.smtpPort = smtpPort;
	}

	public void setSmtpPassword(String smtpPassword) {
		this.smtpPassword = smtpPassword;
	}
	

}
