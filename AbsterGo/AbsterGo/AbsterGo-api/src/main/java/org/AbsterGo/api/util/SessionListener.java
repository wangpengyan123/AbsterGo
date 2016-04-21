package org.AbsterGo.api.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 会话监听
 * 
 * 王少军 2016年1月13日 上午10:41:15
 * 
 * 2016恒实汇通公司-版权所有
 * 
 * @version 1.0.0
 *
 */
public class SessionListener implements HttpSessionListener {
	public static Map<String, Object> userMap = new HashMap<String, Object>();
	private MySessionContext myc = MySessionContext.getInstance();

	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		myc.addSession(httpSessionEvent.getSession());
	}

	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		HttpSession session = httpSessionEvent.getSession();
		myc.delSession(session);
	}
}
