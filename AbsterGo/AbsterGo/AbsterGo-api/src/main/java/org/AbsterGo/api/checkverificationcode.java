package org.AbsterGo.api;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class checkverificationcode {
	private static final Logger log = LoggerFactory.getLogger(checkverificationcode.class);

	public boolean checkverificationcode(HttpServletRequest request) {
		// output stream
		PrintWriter out = null;
		// session
		HttpSession session = request.getSession();
		// verification code from client
		String vcclient = null;
		// verification code from server
		String vcserver = null;
		// check verification code to clien flag
		String checktoclienflag = null;
		boolean flag=false;
		try {

			vcclient = request.getParameter("vclogincode");
			vcserver = String.valueOf(session.getAttribute("verificationcodeuserlogin"));
			vcclient = vcclient == null ? "" : vcclient;
			if (vcclient.equals(vcserver)) {
				checktoclienflag = "vcok";
				
				flag = true;
			} else {
				checktoclienflag = "vcwrong";
				
				flag=false;
			}
			
           
		} catch (Exception e) {
			log.error("vcclient: " + vcclient + "vcserver: " + vcserver + "验证失败", e);
			
			return false;
		} finally {
			
			return flag;
		}
	}
}
