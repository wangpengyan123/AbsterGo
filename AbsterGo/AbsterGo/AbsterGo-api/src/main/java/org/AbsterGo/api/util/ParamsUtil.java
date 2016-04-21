package org.AbsterGo.api.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**   
* @Title: ParamsUtil.java 
* @Package mob.util 
* @Description:  
* @author 王晓鹏
* @date 2015年1月12日 上午10:03:18 
* @version V1.0   
*/
public class ParamsUtil {

	public static String getStrParamter(Map<String, Object> reqMap, String name) {

		Object obj = reqMap.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof Object[]) {
			if (obj instanceof String[]) {
				String values[] = (String[]) obj;
				if (values.length > 0 && values[0] != null
						&& !values[0].trim().equals("")) {
					return values[0];
				}

			} else if (obj instanceof Integer[]) {
				Integer values[] = (Integer[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].intValue());
				}
			} else if (obj instanceof Double[]) {
				Double values[] = (Double[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].doubleValue());
				}
			} else if (obj instanceof Long[]) {
				Long values[] = (Long[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].longValue());
				}
			} else if (obj instanceof BigDecimal[]) {
				BigDecimal values[] = (BigDecimal[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].doubleValue());
				}
			}else if (obj instanceof Date[]) {
				Date values[] = (Date[]) obj;
				if (values.length > 0 && values[0] != null) {
					return values[0].toString();
				}
			} else {
				Object values[] = (Object[]) obj;
				if (values.length > 0 && values[0] != null) {
					return values[0].toString();
				}
			}

		}else{
			if (obj instanceof String) {
				return obj.toString();
			} else if (obj instanceof Integer) {
				return String.valueOf(((Integer)obj).intValue());
			} else if (obj instanceof Double) {
				return String.valueOf(((Double)obj).doubleValue());
			} else if (obj instanceof Long) {
				return String.valueOf(((Long)obj).longValue());
			} else if (obj instanceof BigDecimal) {
				return String.valueOf(((BigDecimal)obj).doubleValue());
			} else if (obj instanceof Date) {
				return ((Date) obj).toString();
			}else {
				return obj.toString();
			}
		}

		return null;
	}
	
	
	

	public static Object getObjParamter(Map<String, Object> reqMap, String name) {
		Object obj = reqMap.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof Object[]) {
			Object values[] = (Object[]) obj;
			if (values.length > 0 && values[0] != null) {
				return values[0];
			}else{
				return null;
			}

		}else{
			return obj;
		}
	}




	public static Object getStrParamter(Map<?, ?> userAk, String upperCase,
			String strParamter, String string, String buy_amt, String uf_mob,
			String string2, String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
	/***
	 * 
	 * filterNullValue(过滤空字符串)
	 * @param params 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public static void filterNullValue(Map<String,Object> params){
		Iterator<Entry<String, Object>> ite = params.entrySet().iterator();
		while (ite.hasNext()) {
			Entry<String, Object> entry = ite.next();
			Object value = entry.getValue();
			if(value==null||StringUtils.isBlank(value.toString())){
				ite.remove();
			}else if(value instanceof String){
				entry.setValue(value.toString().trim());
			}
		}
	}
	/****
	 * 
	 * listToString(集合类型的数据转化为字符串)
	 * @param list
	 * @param joinStr
	 * @return 
	 * String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String listToString(List<?> list,String joinStr){
		if(CollectionUtils.isEmpty(list)){
			return "";
		}else{
			StringBuilder sb = new StringBuilder();
			for (Object object : list) {
				sb.append(joinStr+object);
			}
			sb.deleteCharAt(0);
			return sb.toString();
		}
	}
	/**
	 * 
	 * replaceAllForSql(like 查询用到的字符串过滤)
	 * @param condition
	 * @return 
	 * String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String replaceAllForSql(String condition){
		return condition.replaceAll("'", "''").replaceAll("/", "//").replaceAll("%", "/%").replaceAll("_", "/_");
	}
	
	//加密真实姓名
	public static String jiaMiRealName(String realName){
		if(StringUtils.isEmpty(realName)){
			return null;
		}
		if(StringUtils.isNotEmpty(realName) && ifChineseName(realName)){
			return CalendarUtil.ToDesCret(realName);
		}
		return CalendarUtil.ToDesCret(realName);
	}
	//解密真实姓名
	public static String jieMiRealName(String realName){
		if(StringUtils.isEmpty(realName)){
			return null;
		}
		if(StringUtils.isNotEmpty(realName) && ifChineseName(realName)){
			return realName;
		}
		if(StringUtils.isNotEmpty(realName)){
			try {
				return CalendarUtil.ToDesToStr(realName);
			} catch (Exception e) {
				return realName;
			}
		}
		return realName;
	}
	//加密身份证号
	public static String jiaMiIdCardno(String idCardno){
		if(StringUtils.isEmpty(idCardno)){
			return null;
		}
		if(StringUtils.isNotEmpty(idCardno) && ifIdCardno(idCardno)){
			return CalendarUtil.ToDesCret(idCardno);
		}
		return CalendarUtil.ToDesCret(idCardno);
	}
	//解密身份证号码
	public static String jieMiIdCardNo(String idCardno){
		if(StringUtils.isEmpty(idCardno)){
			return null;
		}
		if(StringUtils.isNotEmpty(idCardno) && ifIdCardno(idCardno)){
			return idCardno;
		}
		if(StringUtils.isNotEmpty(idCardno)){
			try {
				return CalendarUtil.ToDesToStr(idCardno);
			} catch (Exception e) {
				return idCardno;
			}
		}
		return idCardno;
	}
	//加密手机号码
	public static String jiaMiMobile(String mobile){
		if(StringUtils.isEmpty(mobile)){
			return null;
		}
		if(StringUtils.isNotEmpty(mobile) && ifMobile(mobile)){
			return CalendarUtil.ToDesCret(mobile);
		}
		if(StringUtils.isNotEmpty(mobile)){
			return mobile;
		}
		return CalendarUtil.ToDesCret(mobile);
	}
	//解密手机号码
	public static String jieMiMobile(String mobile){
		if(StringUtils.isEmpty(mobile)){
			return null;
		}
		if(StringUtils.isNotEmpty(mobile) && ifMobile(mobile)){
			return mobile;
		}
		if(StringUtils.isNotEmpty(mobile)){
			try {
				return CalendarUtil.ToDesToStr(mobile);
			} catch (Exception e) {
				return mobile;
			}
		}
		return mobile;
	}
	/**
	 * 
	 * ifChineseName(判断是否为中文姓名)
	 * @param name
	 * @return 
	 * boolean
	 * @exception 
	 * @since  1.0.0
	 */
	private static boolean ifChineseName(String name) {
		return name.matches("[\u4e00-\u9fa5]{2,5}");
    }
	/**
	 * 
	 * ifChineseName(判断是否为身份证号码)
	 * @param name
	 * @return 
	 * boolean
	 * @exception 
	 * @since  1.0.0
	 */
	private static boolean ifIdCardno(String idCardno) {
		Pattern p = Pattern.compile("^\\d{15}|^\\d{17}([0-9]|X|x)$");
	    
	    Matcher m = p.matcher(idCardno);
	
		return m.matches();
    }
	
    /**判断是否为手机号码**/
    public static boolean ifMobile(String mobile){
         Pattern p = Pattern.compile("^[1][3,7,4,5,8][0-9]{9}$"); // 验证手机号  
         Matcher m = p.matcher(mobile);  
         return  m.matches();   
    }
    /**判断是否为邮件**/
    public static boolean ifEmail(String email){
         Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"); // 验证邮件 
         Matcher m = p.matcher(email);  
         return  m.matches();   
    }
    /**金额相加**/
    public static BigDecimal add(BigDecimal b1,BigDecimal b2){
    	if(b1==null){
    		b1 = BigDecimal.ZERO;
    	}
    	if(b2==null){
    		b2 = BigDecimal.ZERO;
    	}
    	return b1.add(b2);
    }
    /**金额相加**/
    public static Long add(Long b1,Long b2){
    	if(b1==null){
    		b1 = 0L;
    	}
    	if(b2==null){
    		b2 = 0L;
    	}
    	return b1.longValue()+b2.longValue();
    }
    /***获得时间文件名称**/
    public static String getTimeFileName(){
    	// 得到当前时间
		Date now = new Date();
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		String t = dataformat.format(now);
		// 得到一个随机数
		String ran = new Random().nextInt(100)+"";
		// 以当前时间加上一个随机数获取下载的文件以保证不重名
		return t + "-" + ran;
    }
    /***动态隐藏字符串**/
    public static String hideSomeChar(String param){
    	if(StringUtils.isNotEmpty(param)||param.length()==1){
    		boolean hideFlag = false;
    		int len = param.length();
    		StringBuilder sb = new StringBuilder();
    		Random random = new Random();
    		int r = random.nextInt(10);
    		while(!hideFlag){
    			for(int i=0;i<len;i++){
    				if(r>4){
    					sb.append("*");
    					hideFlag = true;
    				}else{
    					sb.append(param.charAt(i));
    				}
    				r = random.nextInt(10);
    			}
    		}
    		return sb.toString();
    	}else{
    		return param;
    	}
    }
    
    /**
     * 
     * replayMobileAndIdCardno(判断是否回复手机号@身份证号)  
     * @param Content
     * @return   
     *boolean  
     * @exception   
     * @since  1.0.0
     */
    public static boolean replayMobileAndIdCardno(String Content){
    	if(StringUtils.isNotEmpty(Content)){
    		String[] datas = Content.split("@");
    		if(datas.length==2){
    			return ifMobile(datas[0])&&ifIdCardno(datas[1]);
    		}
    	}else{
    		return false;
    	}
    	return false;
    }
    /**
     * 
     * replayMobileAndIdCardno(判断是否回复手机号@身份证号)  
     * @param Content
     * @return   
     *boolean  
     * @exception   
     * @since  1.0.0
     */
    public static boolean replayMobileAndValidateCode(String Content){
    	Pattern p = Pattern.compile("^[1][3,7,4,5,8][0-9]{9}@\\d{4,10}$");
	    
	    Matcher m = p.matcher(Content);
	
		return m.matches();
    }
    
}
