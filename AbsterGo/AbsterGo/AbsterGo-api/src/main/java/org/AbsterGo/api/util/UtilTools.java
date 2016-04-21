package org.AbsterGo.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.StringUtils;

/**
 * 工具类
 * 
 * 王少军 2016年1月8日 下午2:57:18
 * 
 * 2016恒实汇通公司-版权所有
 * 
 * @version 1.0.0
 *
 */
public class UtilTools {

	private static final String KEY = "hsmapp@#$%&*2015!@#$%&*";

	/**
	 * 
	 * md5
	 *
	 * @param plainText
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public static String md5(String plainText) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}

	/**
	 * 获取相应的数据
	 * 
	 * @param queryString
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Map<String, String> getSignParams(String queryString) throws UnsupportedEncodingException {
		Map<String, String> result = new HashMap<String, String>();
		String[] params = queryString.split("&");
		for (String param : params) {
			String[] tmp = param.split("=");
			String key = tmp[0];
			if (!"md5".equals(key)) {
				result.put(key, URLDecoder.decode(tmp[1], "UTF-8"));
			}
		}
		return result;
	}

	/**
	 * 校验参数是否正确
	 *
	 * @param queryString
	 * @return
	 * @throws UnsupportedEncodingException
	 *             boolean
	 * @exception @since
	 *                1.0.0
	 */
	public static boolean isSignParams(HttpServletRequest request) throws UnsupportedEncodingException {
		String queryString = request.getQueryString();
		if (StringUtils.isEmpty(queryString)) {
			return false;
		}
		String md5 = "";
		StringBuffer sb = new StringBuffer(KEY + "|");
		String[] params = queryString.split("&");
		int i = 0;
		for (String param : params) {
			String[] tmp = param.split("=");
			String key = tmp[0];
			if (!"md5".equals(key)) {
				sb.append(URLDecoder.decode(tmp[1], "UTF-8"));
				if (i < 2) {
					sb.append("|");
				}
				i++;
				if (i > 2) {
					break;
				}
			} else {
				md5 = URLDecoder.decode(tmp[1], "UTF-8");
			}
		}
		String signMd5 = sb.toString();
		signMd5 = signMd5.substring(0, signMd5.length());
		if (md5.equals(md5(signMd5))) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * isMobileNO
	 *
	 * @param mobiles
	 * @return boolean
	 * 
	 * @exception @since
	 *                1.0.0
	 */
	public static boolean isMobileNO(String mobiles) {
		String regExp = "^[1]([3][0-9]{1}|59|58|85|88|89)[0-9]{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobiles);
		return m.find();
	}

	/**
	 * 
	 * percent
	 *
	 * @param num1
	 * @param num2
	 * @return String
	 *  
	 * @exception   
	 * @since  1.0.0
	 */
	public static String percent(double num1, double num2) {
		double num3 = ((num2 - num1) / num2) * 100.0;
		DecimalFormat df = new DecimalFormat("#.00");
		String s = df.format(num3).replace(".00", "");
		if (StringUtils.isEmpty(s)) {
			s = "0";
		}
		return s;
	}
}
