package org.AbsterGo.api.util;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.AbsterGo.model.AppUser;
import com.alibaba.druid.util.StringUtils;

public class WebUtil {

	/**
	 * 向application中存放对象
	 * 
	 * @param req
	 * @param key
	 * @param value
	 */
	public static void setApplicationValue(HttpServletRequest req, String key, Object value) {
		ServletContext application = req.getSession().getServletContext();
		application.setAttribute(key, value);
	}

	/**
	 * 在application取出对象
	 * 
	 * @param req
	 * @param key
	 * @return
	 */
	public static Object getApplicationValue(HttpServletRequest req, String key) {
		ServletContext application = req.getSession().getServletContext();
		return application.getAttribute(key);
	}

	/**
	 * 向session中存放对象
	 * 
	 * @param req
	 * @param key
	 * @param value
	 */
	public static void setSessionValue(HttpServletRequest req, String key, Object value) {
		HttpSession session = req.getSession(true);
		session.setAttribute(key, value);
	}

	/**
	 * Return an Object from the current session add by zhj
	 * 
	 * @param req
	 * @param key
	 * @return object
	 */
	public static Object getSessionValue(HttpServletRequest req, String key) {
		HttpSession session = req.getSession(true);
		return session.getAttribute(key);
	}

	/**
	 * 移除session
	 * 
	 * @param req
	 * @param key
	 *            void
	 * @exception @since
	 *                1.0.0
	 */
	public static void removeSessionValue(HttpServletRequest req, String key) {
		HttpSession session = req.getSession(true);
		session.removeAttribute(key);
	}

	//
	// /**
	// * 从request中取得分页信息.
	// * @return PageReq 分页请求信息封装类
	// * @author ligang
	// */
	// public static PageReq getPageReq(HttpServletRequest request,int pageSize)
	// {
	// PageReq pageReq = new PageReq();
	// String pageNum = request.getParameter("pageNum");
	// if(StringUtils.isBlank(pageNum)) {
	// String sessionPageNum = (String)getSessionValue(request,"pageNum");
	// if(StringUtils.isBlank(sessionPageNum)) {
	// pageNum = "1";
	// } else {
	// pageNum = sessionPageNum;
	// }
	// }
	// pageReq.setPageNumber(Integer.parseInt(pageNum));
	// pageReq.setPageSize(pageSize);
	// return pageReq;
	// }

	// /**
	// * 验证邮箱格式是否正确
	// * @param email
	// * @return
	// */
	// public static boolean isEmail(String email){
	// if(StringUtils.isNotBlank(email)){
	// Pattern p =
	// Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
	// Matcher m = p.matcher(email);
	// return m.find();
	// }
	// return false;
	// }
	// /**
	// * 验证是否是手机号
	// * @param mobile
	// * @return
	// */
	// public static boolean isMobile(String mobile){
	//
	// if(!StringUtils.isNotBlank(mobile))
	// return false;
	// Pattern p =
	// Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	// Matcher m = p.matcher(mobile);
	// return m.matches();
	// }

	/**
	 * 直接输出.
	 * 
	 * @param contentType
	 *            内容的类型.html,text,xml的值见后，json为"text/x-json;charset=UTF-8"
	 */
	public static void render(HttpServletResponse res, String text, String contentType) {
		try {
			res.setContentType(contentType);
			res.getWriter().write(text);
			res.getWriter().flush();
		} catch (IOException e) {
		}
	}

	/**
	 * 直接输出纯字符串.
	 */
	public static void writeResponse(HttpServletResponse res, String text) {
		res.setContentType("text/plain;charset=UTF-8");
		try {
			res.getWriter().write(text);
			res.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 直接输出纯XML.
	 */
	public static void renderXML(HttpServletResponse res, String text) {
		render(res, text, "text/xml;charset=UTF-8");
	}

	/**
	 * 取得http传递的参数值,并设置默认值
	 * 
	 * @param request
	 *            http请求
	 * @param paramName
	 *            参数名称
	 * @param defaultValue
	 *            如果参数值为null情况下的默认值
	 * @return 参数值
	 */
	public static String getParameter(HttpServletRequest request, String paramName, String defaultValue) {
		/**
		 * 返回值
		 */
		String returnValue = null;

		/**
		 * 参数的值
		 */
		String paramValue = request.getParameter(paramName);

		if (paramValue == null || paramValue.equals("")) {
			returnValue = defaultValue;
		} else {
			returnValue = paramValue;
		}
		// 如果参数值为空,那么转换成空字符串,如果非空,原样返回
		returnValue = ((returnValue == null) ? "" : returnValue);

		// 返回
		return returnValue.trim();
	}

	/**
	 * 取得http传递的参数值,并设置默认值
	 * 
	 * @param request
	 *            http请求
	 * @param paramName
	 *            参数名称
	 * @param defaultValue
	 *            如果参数值为null情况下的默认值
	 * @return 参数值
	 */
	public static int getParameterInt(HttpServletRequest request, String paramName, int defaultValue) {
		/**
		 * 返回值
		 */
		int returnValue = 0;

		/**
		 * 参数的值
		 */
		String paramValue = request.getParameter(paramName);

		if (paramValue == null || paramValue.equals("")) {
			returnValue = defaultValue;
		} else {
			returnValue = Integer.parseInt(paramValue);
		}
		// 如果参数值为空,那么转换成空字符串,如果非空,原样返回
		returnValue = ((returnValue == 0) ? 0 : returnValue);

		// 返回
		return returnValue;
	}

	/**
	 * 取得http传递的参数值,并设置默认值
	 * 
	 * @param request
	 *            http请求
	 * @param paramName
	 *            参数名称
	 * @param defaultValue
	 *            如果参数值为null情况下的默认值
	 * @return 参数值
	 */
	public static long getParameterLong(HttpServletRequest request, String paramName, long defaultValue) {
		/**
		 * 返回值
		 */
		long returnValue = 0;

		/**
		 * 参数的值
		 */
		String paramValue = request.getParameter(paramName);

		if (paramValue == null || paramValue.equals("")) {
			returnValue = defaultValue;
		} else {
			returnValue = Long.parseLong(paramValue);
		}
		// 如果参数值为空,那么转换成空字符串,如果非空,原样返回
		returnValue = ((returnValue == 0) ? 0 : returnValue);

		// 返回
		return returnValue;
	}

	/**
	 * 
	 * 获取小数的数值
	 *
	 * @param request
	 * @param paramName
	 * @param defaultValue
	 * @return double
	 * 
	 * @exception @since
	 *                1.0.0
	 */
	public static double getParameterDouble(HttpServletRequest request, String paramName, double defaultValue) {
		/**
		 * 返回值
		 */
		double returnValue = 0;

		/**
		 * 参数的值
		 */
		String paramValue = request.getParameter(paramName);

		if (paramValue == null || paramValue.equals("")) {
			returnValue = defaultValue;
		} else {
			returnValue = Double.parseDouble(paramValue);
		}
		// 如果参数值为空,那么转换成空字符串,如果非空,原样返回
		returnValue = ((returnValue == 0) ? 0 : returnValue);

		// 返回
		return returnValue;
	}

	/**
	 * 获取session用户信息
	 *
	 * @param request
	 * @return AppUser
	 * @exception @since
	 *                1.0.0
	 */
	public static AppUser getSessionAppUserInfo(HttpServletRequest request) {
		// sessionId
		String sessionId = WebUtil.getParameter(request, "sessionId", "");
		// 如果sessionId不为空时直接从缓存里面获取用户信息，为空时直接从session里面获取用户信息
		if (!StringUtils.isEmpty(sessionId)) {
			MySessionContext myc = MySessionContext.getInstance();
			HttpSession session = myc.getSession(sessionId);
			if (session != null) {
				AppUser appUser = (AppUser) session.getAttribute("appUser");
				return appUser;
			}
		}
		return null;
	}

	/**
	 *
	 * @param request
	 * @param appUser   
	 *  
	 * @exception   
	 * @since  1.0.0
	 */
	public static void setSessionAppUserInfo(HttpServletRequest request, AppUser appUser) {
		// sessionId
		String sessionId = WebUtil.getParameter(request, "sessionId", "");
		// 如果sessionId不为空时直接从缓存里面获取用户信息，为空时直接从session里面获取用户信息
		if (!StringUtils.isEmpty(sessionId)) {
			MySessionContext myc = MySessionContext.getInstance();
			HttpSession session = myc.getSession(sessionId);
			if (session != null) {
				session.setAttribute("appUser", appUser);
				// 存放sessionId以及存放相关的session信息
				myc.addSession(session, sessionId);
			}
		}
	}

	/**
	 * 
	 * 获取session
	 *
	 * @param request
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public static String getSessionId(HttpServletRequest request, String key, Object value) {
		HttpSession session = request.getSession();
		// 存放sessionId以及存放相关的session信息
		MySessionContext myc = MySessionContext.getInstance();
		myc.addSession(session, session.getId());
		session.setAttribute(key, value);
		return session.getId();
	}

	/**
	 * 移除session内容
	 *
	 * @param request
	 * @param key
	 * 
	 * @exception @since
	 *                1.0.0
	 */
	public static void removeSession(HttpServletRequest request) {
		String sessionId = WebUtil.getParameter(request, "sessionId", "");
		HttpSession session = request.getSession();
		// 存放sessionId以及存放相关的session信息
		MySessionContext myc = MySessionContext.getInstance();
		// 删除session
		myc.delSession(session);
		// 通过sessionId删除缓存里面的session
		myc.delSessionBySessionId(sessionId);
		// 通过sessionId删除缓存里面的session
		myc.delSessionMapBySessionId(sessionId);
		// 删除session
		removeSessionValue(request, "appUser");
		session.invalidate();
	}
}
