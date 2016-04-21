package org.AbsterGo.api.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**  
 *   
 * LoginFilter  登录filter
 *   
 * 王晓鹏  
 * 2015年11月25日 下午1:52:42  
 *  
 *  2015恒实汇通公司-版权所有   
 * @version 1.0.0  
 *   
 */
public class LoginFilter implements Filter {
	
	public LoginFilter() {
	}

	public void destroy() {
	}

	/**
	 * 
	 * @Title: doFilter 
	 * @Description: 判断用户是否登录访问 
	 * @author lidaqing   
	 * @date 2014-6-5 下午3:56:22  
	 * @param req,resp,chain
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getRequestURI();
		if(url.endsWith("/index.jsp") || url.endsWith("/login") || url.endsWith("/servlet/VerifyingCodeGen") || url.endsWith("css")
				 || url.endsWith("js") || url.endsWith("jpg") || url.endsWith("png") || url.endsWith("gif") || url.endsWith("ico") || url.indexOf("/services/") != -1){
			chain.doFilter(request, response);
			return;
		}
//		BackUser user = (BackUser) WebUtil.getSessionValue(request, "backuser");
//		if (user != null&&WebUtil.getSessionValue(request, Constants.VERIFYING_CODE_KEY)!=null) {
//			chain.doFilter(request, response);
//			return;
//		}
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		
		/*response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder builder = new StringBuilder();
		builder.append("<script type='text/javascript'>");
		builder.append("alert('操作超时,请重新登录!');");
		builder.append("window.location.href=\"");
		builder.append(request.getContextPath() + "/sys_crm_login.jsp\";</script>");
		out.print(builder.toString()); 
		out.close();*/
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
