package org.AbsterGo.api.util;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.alibaba.druid.util.StringUtils;

/**
 * 
 * 王少军 2016年1月13日 上午10:40:40
 * 
 * 2016恒实汇通公司-版权所有
 * 
 * @version 1.0.0
 *
 */
public class MySessionContext {
	private static MySessionContext instance;
	private HashMap<String, Object> mymap;
	public HashMap<String, Long> sessionMap;
	

	private MySessionContext() {
		mymap = new HashMap<String, Object>();
		sessionMap = new HashMap<String, Long>();
	}

	public static MySessionContext getInstance() {
		if (instance == null) {
			instance = new MySessionContext();
		}
		return instance;
	}

	public synchronized void addSession(HttpSession session) {
		if (session != null) {
			String sessionId = session.getId();
			mymap.put(sessionId, session);
			sessionMap.put(sessionId, System.currentTimeMillis());
		}
	}
	
	public synchronized void addSession(HttpSession session,String sessionId) {
		if (session != null) {
			mymap.put(sessionId, session);
			sessionMap.put(sessionId, System.currentTimeMillis());
		}
	}

	public synchronized void delSession(HttpSession session) {
		if (session != null) {
			mymap.remove(session.getId());
		}
	}
	
	public synchronized void delSessionBySessionId(String session_id) {
		if (!StringUtils.isEmpty(session_id)) {
			mymap.remove(session_id);
		}
	}

	public synchronized void delSessionMapBySessionId(String session_id) {
		if (!StringUtils.isEmpty(session_id)) {
			sessionMap.remove(session_id);
		}
	}
	
	public synchronized HttpSession getSession(String session_id) {
		if (StringUtils.isEmpty(session_id)) {
			return null;
		}
		sessionMap.put(session_id, System.currentTimeMillis());
		return (HttpSession) mymap.get(session_id);
	}

}
