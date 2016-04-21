package org.AbsterGo.api.util;

import javax.servlet.http.HttpServletRequest;

public class RequestHeader {

	
	public static int JudgeIsMoblie(HttpServletRequest request) {
		int isMoblie = 0;
		String[] mobileAgents = { "iphone", "ipad"};
		String[] androidAgent = {"android"};
		if (request.getHeader("User-Agent") != null) {
			for (String mobileAgent : mobileAgents) {
				if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
					isMoblie = 1;
					break;
				}
			}
			for (String mobileAgent : androidAgent) {
				if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {
					isMoblie = 2;
					break;
				}
			}
		}
		return isMoblie;
	}
}
