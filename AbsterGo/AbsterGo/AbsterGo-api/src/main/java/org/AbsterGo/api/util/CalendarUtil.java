package org.AbsterGo.api.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.AbsterGo.api.Constants;

/**
 * @Title: CalendarUtil.java
 * @Package mob.util
 * @Description:
 * @author 王晓鹏
 * @date 2015年1月12日 上午10:02:52
 * @version V1.0
 */
/**  
 *   
 * CalendarUtil  
 *   
 * 王晓鹏  
 * 2016年1月25日 下午8:38:07  
 *  
 *  2016恒实汇通公司-版权所有   
 * @version 1.0.0  
 *   
 */
public class CalendarUtil {
	private static final int MDAYS = 30;

	private CalendarUtil() {
	}

	/**  
	 * addMonth(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param s
	 * @param months
	 * @return
	 * @throws Exception   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized String addMonth(String s, int months) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(s));
		cal.add(Calendar.DAY_OF_YEAR, months * MDAYS);
		return sdf.format(cal.getTime());
	}

	/**  
	 * addCkMonth(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param s
	 * @param months
	 * @return
	 * @throws Exception   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized String addCkMonth(String s, int months) throws Exception {
		String date[] = s.split("-");
		Integer y = Integer.valueOf(date[0]);
		Integer m = Integer.valueOf(date[1]);
		Integer d = Integer.valueOf(date[2]);
		int end_m = m + months;
		if (end_m > 12) {
			m = end_m % 12;
			if (m == 0) {
				m = 12;
			}
			y = (end_m - m) / 12 + y;
		} else {
			m = end_m;
		}
		if (m < 10) {
			return y.toString() + "-0" + m.toString() + "-" + d.toString();
		} else {
			return y.toString() + "-" + m.toString() + "-" + d.toString();
		}

	}

	/**  
	 * daysBetween(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException   
	 *int  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized int daysBetween(String sdate, String edate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(sdate));
		long stime = cal.getTimeInMillis();
		cal.setTime(sdf.parse(edate));
		long etime = cal.getTimeInMillis();

		long diff = (etime - stime) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(diff));
	}

	/**  
	 * daysBetween(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param sdate
	 * @param edate
	 * @return
	 * @throws ParseException   
	 *int  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized int daysBetween(Date sdate, Date edate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(sdate);
		sdf.format(edate);
		System.out.println(sdf.format(sdate) + "-------" + sdf.format(edate));

		return daysBetween(sdf.format(sdate), sdf.format(edate));
	}

	/**  
	 * makeRandom(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param codeCount
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized String makeRandom(int codeCount) {
		char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 创建一个随机数生成器类
		Random random = new Random();
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		// 随机产生codeCount数字的验证码。
		for (int i = 0; i < codeCount; i++) {
			// 得到随机产生的验证码数字。
			String strRand = String.valueOf(codeSequence[random.nextInt(codeCount)]);
			randomCode.append(strRand);
		}
		return randomCode.toString();
	}

	/**  
	 * makeYMDHMS(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param type
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static synchronized String makeYMDHMS(String type) {
		Calendar cal = Calendar.getInstance();
		String YMDHMS = "";
		int year = cal.get(Calendar.YEAR);// 获取年份
		int month = cal.get(Calendar.MONTH) + 1;// 获取月份
		int day = cal.get(Calendar.DATE);// 获取日
		int hour = cal.get(Calendar.HOUR_OF_DAY);// 小时
		int minute = cal.get(Calendar.MINUTE);// 分
		int second = cal.get(Calendar.SECOND);// 秒
		int millis = cal.get(Calendar.MILLISECOND);
		YMDHMS = IntToString(year) + IntToString(month) + IntToString(day) + IntToString(hour) + IntToString(minute)
				+ IntToString(second);
		// System.out.println(IntToString(year)+IntToString(month)+IntToString(day)+IntToString(hour)+IntToString(minute)+IntToString(second));
		if (type.equals("sh")) {

		} else if (type.equals("long")) {
			YMDHMS = IntToString(year) + IntToString(month) + IntToString(day) + IntToString(hour) + IntToString(minute)
					+ IntToString(second) + IntToString(millis);
		} else if (type.equals("ldys")) {
			YMDHMS = IntToString(millis);
		} else {
			return YMDHMS;
		}
		return YMDHMS;
	}

	/**  
	 * IntToString(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param val
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String IntToString(int val) {
		Integer t = new Integer(val);
		String s = t.toString();
		if (s.length() == 1) {
			s = "0" + s;
		}
		return s;
	}

	/**  
	 * StringToDate(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param str
	 * @return   
	 *Date  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static Date StringToDate(String str) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	/**  
	 * DatetoString(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param date
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String DatetoString(Date date) {
		String str = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			str = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**  
	 * DatetoStringKey(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param date
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String DatetoStringKey(Date date) {
		String str = null;
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			str = formatter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	/**  
	 * DateStringOpt(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param dateStr
	 * @param days
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String DateStringOpt(String dateStr, int days) {
		String str = null;
		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date d = formatter.parse(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.DATE, days);
			str = formatter.format(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String NameCretSplit(String cert) {
		return cert.substring(0, 4) + "**********" + cert.substring(cert.length() - 8, cert.length() - 4);
	}

	/**
	 * 加密
	 *
	 * @param str
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public static String ToDesCret(String str) {
		String key = "156873c93262d8d16716aac54b444c6d";// 初始化密钥。
		ToDes.setKey(key);
		ToDes.setEncString(str);
		return ToDes.getStrMi();
	}

	/**
	 * 解密
	 *
	 * @param str
	 * @return String
	 * @exception @since
	 *                1.0.0
	 */
	public static String ToDesToStr(String str) {
		String key = "156873c93262d8d16716aac54b444c6d"; // 初始化密钥。
		ToDes.setKey(key);
		// 对字符串进行解密
		ToDes.setDesString(str);
		String reStr = ToDes.getStrM().trim();
		return reStr;
	}

	/**
	 * 以UUID+四位随机数字形式形成唯一字符串 UUID 去掉 "-" + 4位整型
	 * 
	 * @return key
	 */
	public static final String UUID() {
		int random = (int) (new Random().nextDouble() * 10000);
		if (random < 1000) {
			random += 1000;
		}
		return java.util.UUID.randomUUID().toString().replace("-", "") + random;
	}

	/**  
	 * getDateAfter(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param time
	 * @param day
	 * @return   
	 *Date  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static Date getDateAfter(String time, int day) {
		Calendar now = Calendar.getInstance();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			now.setTime(formatter.parse(time));
			now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now.getTime();
	}

	
    public final static String addMonthsToDate(Date date,int months){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH,months);// 加3个月
         
     
         
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        String defaultStartDate = sdf.format(c.getTime()); //格式化前3月的时间
         
        return defaultStartDate;
      }

	/**  
	 * readReqStr(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param request
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String readReqStr(HttpServletRequest request) {
		BufferedReader reader = null;
		StringBuilder sb = new StringBuilder();
		try {
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {

			}
		}
		return sb.toString();
	}

	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	/**  
	 * byteToString(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param bByte
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	/**  
	 * GetMD5Code(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param strObj
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

	/**  
	 * getDateBefore(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param time
	 * @param day
	 * @return   
	 *Date  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static Date getDateBefore(String time, int day) {
		Calendar now = Calendar.getInstance();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			now.setTime(formatter.parse(time));
			now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now.getTime();
	}

	/**  
	 * getLastList(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param map
	 * @return   
	 *List<Map<String,Object>>  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static List<Map<String, Object>> getLastList(List<Map<String, Object>> map) {
		List<Map<String, Object>> lastMap = new ArrayList<Map<String, Object>>();
		if (map != null && map.size() > 0) {
			int x = map.size();
			for (int i = 0; i < x; i++) {
				Map<String, Object> investMap = map.get(i);
				if (investMap.get("realname") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("realname").toString());
					investMap.put("realname", realname.substring(0, 1));
				}
				if (investMap.get("mobile") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("mobile").toString());
					investMap.put("mobile", realname.substring(0, 3) + "****"
							+ realname.substring(realname.length() - 4, realname.length()));
				}
				if (investMap.get("cardNo") != null) {
					if (!investMap.get("cardNo").equals(0)) {
						String cardNo = CalendarUtil.ToDesToStr(investMap.get("cardNo").toString());

						investMap.put("cardNo", cardNo.substring(0, 3) + "*********"
								+ cardNo.substring(cardNo.length() - 4, cardNo.length()));
					}
				}
				lastMap.add(investMap);
			}
		}
		return lastMap;
	}

	/**  
	 * getName(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param map
	 * @return   
	 *List<Map<String,Object>>  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static List<Map<String, Object>> getName(List<Map<String, Object>> map) {
		List<Map<String, Object>> lastMap = new ArrayList<Map<String, Object>>();
		if (map != null && map.size() > 0) {
			int x = map.size();
			for (int i = 0; i < x; i++) {
				String sex = null;
				Map<String, Object> investMap = map.get(i);
				if (investMap.get("id_cardNo") != null) {
					if (!investMap.get("id_cardNo").equals(0)) {
						String cardNo = CalendarUtil.ToDesToStr(investMap.get("id_cardNo").toString());
						sex = cardNo.substring(cardNo.length() - 2, cardNo.length() - 1);
						if (Integer.parseInt(sex) % 2 == 0) {
							sex = "女士";
						} else {
							sex = "先生";
						}
					}
				}
				if (investMap.get("realname") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("realname").toString());
					investMap.put("realname", realname.substring(0, 1) + sex);
				}
				if (investMap.get("mobile") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("mobile").toString());
					investMap.put("mobile", realname.substring(0, 3) + "****"
							+ realname.substring(realname.length() - 4, realname.length()));
				}
				if (investMap.get("remark") != null) {

					String remark = investMap.get("remark").toString();
					if (remark.length() >= 8) {
						investMap.put("remark", remark.substring(0, 8) + "...");
					}
				}
				lastMap.add(investMap);
			}
		}
		return lastMap;

	}

	/**  
	 * getLastMap(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param map
	 * @return   
	 *List<Map<String,Object>>  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static List<Map<String, Object>> getLastMap(List<Map<String, Object>> map) {
		List<Map<String, Object>> lastMap = new ArrayList<Map<String, Object>>();
		if (map != null && map.size() > 0) {
			int x = map.size();
			for (int i = 0; i < x; i++) {
				Map<String, Object> investMap = map.get(i);
				if (investMap.get("realname") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("realname").toString());
					investMap.put("realname", realname.substring(0, 1) + "**");
				}
				if (investMap.get("mobile") != null) {
					String mobile = CalendarUtil.ToDesToStr(investMap.get("mobile").toString());
					investMap.put("mobile", mobile.substring(0, 4) + "***" + mobile.substring(mobile.length() - 4));
				}
				lastMap.add(investMap);
			}
		}
		return lastMap;
	}

	
	public static List<Map<String, Object>> getPersonMap(List<Map<String, Object>> map) {
		List<Map<String, Object>> lastMap = new ArrayList<Map<String, Object>>();
		if (map != null && map.size() > 0) {
			int x = map.size();
			for (int i = 0; i < x; i++) {
				Map<String, Object> investMap = map.get(i);
				if (investMap.get("realname") != null) {
					String realname = CalendarUtil.ToDesToStr(investMap.get("realname").toString());
					investMap.put("realname", realname);
				}
				if (investMap.get("mobile") != null) {
					String mobile = CalendarUtil.ToDesToStr(investMap.get("mobile").toString());
					investMap.put("mobile", mobile);
				}
				lastMap.add(investMap);
			}
		}
		return lastMap;
	}
	
	
	/**  
	 * isMobile(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param str
	 * @return   
	 *boolean  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,7,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**  
	 * isPassword(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param str
	 * @return   
	 *boolean  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static boolean isPassword(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$");
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	
	public static boolean isnotChinese(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[^\u4e00-\u9fa5]{0,}$");
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**  
	 * isCard(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param str
	 * @return   
	 *boolean  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static boolean isCard(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[a-zA-Z0-9]{6,15}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

	/**  
	 * isRealName(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param str
	 * @return   
	 *boolean  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static boolean isRealName(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[\u4e00-\u9fa5]{2,4}$"); // 真实姓名
		m = p.matcher(str);
		b = m.matches();
		return b;
	}


	/**  
	 * getPayMsg(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param scatteredReType
	 * @param scatteredYield
	 * @param scatteredPeriod
	 * @param amount
	 * @return   
	 *String  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static String getPayMsg(String scatteredReType, Double scatteredYield, Integer scatteredPeriod,
			Double amount) {
		String str = "";
		if (scatteredReType.equals("等额本息")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.generateRepayFeeByDEBX(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}
		if (scatteredReType.equals("按月付息，到期还本")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.generateRepayFeeByFXHB(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}
		if (scatteredReType.equals("一次还本付息")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.getRepayDQHB(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		}
		return str;
	}

	/**  
	 * getPayMsgByTpe(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param scatteredReType
	 * @param scatteredYield
	 * @param scatteredPeriod
	 * @param amount
	 * @return   
	 *BigDecimal  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static BigDecimal getPayMsgByTpe(String scatteredReType, Double scatteredYield, Integer scatteredPeriod,
			Double amount) {
		BigDecimal str = BigDecimal.ZERO;
		if (scatteredReType.equals("等额本息")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.generateRepayFeeByDEBX(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		if (scatteredReType.equals("按月付息，到期还本")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.generateRepayFeeByFXHB(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		if (scatteredReType.equals("一次还本付息")) {
			BigDecimal lx = BigDecimal
					.valueOf(FeeMsgUtils.getRepayDQHB(amount, scatteredPeriod, scatteredYield / 100.00, 2));
			str = lx.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return str;
	}

	/**  
	 * getBorrowLastList(这里用一句话描述这个方法的作用)  
	 * (这里描述这个方法适用条件 – 可选)  
	 * @param map
	 * @return   
	 *List<Map<String,Object>>  
	 * @exception   
	 * @since  1.0.0  
	*/
	public static List<Map<String, Object>> getBorrowLastList(List<Map<String, Object>> map) {

		List<Map<String, Object>> lastMap = new ArrayList<Map<String, Object>>();

		if (map != null && map.size() > 0) {

			int x = map.size();

			for (int i = 0; i < x; i++) {

				Map<String, Object> investMap = map.get(i);

				if (investMap.get("borrow_name") != null) {

					String realname = CalendarUtil.ToDesToStr(investMap.get("borrow_name").toString());

					investMap.put("borrow_name", realname);
				}
				if (investMap.get("borrow_mobile") != null) {

					String realname = CalendarUtil.ToDesToStr(investMap.get("borrow_mobile").toString());

					investMap.put("borrow_mobile", realname);
				}
				lastMap.add(investMap);
			}

		}
		return lastMap;

	}

	/**
	 * 
	 * 转
	 *
	 * @param map
	 * @return Map<String,Object>
	 * @exception @since
	 *                1.0.0
	 */
	public static Map<String, Object> getLastMap(Map<String, Object> map) {
		// Map<String, Object> lastMap = new HashMap<String, Object>();
		if (map.get("realname") != null) {
			String realname = CalendarUtil.ToDesToStr(map.get("realname").toString());
			map.put("realname", realname.substring(0, 1));
		}
		if (map.get("userRealName") != null) {
			String realname = CalendarUtil.ToDesToStr(map.get("userRealName").toString());
			map.put("userRealName", realname.substring(0, 1) + "**");
		}
		if (map.get("mobile") != null) {
			String realname = CalendarUtil.ToDesToStr(map.get("mobile").toString());
			map.put("mobile",
					realname.substring(0, 3) + "****" + realname.substring(realname.length() - 4, realname.length()));
		}
		if (map.get("cardNo") != null) {
			if (!map.get("cardNo").equals(0)) {
				String cardNo = CalendarUtil.ToDesToStr(map.get("cardNo").toString());
				map.put("cardNo",
						cardNo.substring(0, 3) + "*********" + cardNo.substring(cardNo.length() - 4, cardNo.length()));
			}
		}
		return map;
	}

	public static String hideSomeChar(String str,String sign) {
		// TODO Auto-generated method stub
		
		String lastStr="";
		
		if(sign.equals(Constants.MOBILE)){
			lastStr=str.substring(0, 4) + "***" + str.substring(str.length() - 4);
		}
		
		if(sign.equals(Constants.IDCARD)){
			lastStr=str.substring(0, 3) + "*********" + str.substring(str.length() - 4, str.length());
		}
		
		if(sign.equals(Constants.REALNAME)){
			lastStr=str.substring(0, 1) + "**";
		}
		
		return lastStr;
	}
	
	
	
	
	
	
	
}
