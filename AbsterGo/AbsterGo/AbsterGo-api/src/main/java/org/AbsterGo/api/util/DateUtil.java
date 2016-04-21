package org.AbsterGo.api.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;



/**
 * @since v1.1
 * @history
 * @see
 */
public class DateUtil {
	public static String FORMAT_DATE = "yyyy-MM-dd";
	public static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	
    public static Date forToDateByDateFormat(String str) throws ParseException{
    	YZYDateFormat format = YZYDateFormat.getInstance(FORMAT_DATE);
		return format.parse(str);
    }
    public static Date forToDateByDateTimeFormat(String str) throws ParseException{
    	YZYDateFormat format = YZYDateFormat.getInstance(FORMAT_DATE_TIME);
		return format.parse(str);
    }
    public static String forToStrByDateFormat(Date date) {
    	if (date != null) {
			return YZYDateFormat.getInstance(FORMAT_DATE).format(date);
		} else {
			return "null";
		}
    }
    public static String forTStrByDateTimeFormat(Date date) {
    	if (date != null) {
			return YZYDateFormat.getInstance(FORMAT_DATE_TIME).format(date);
		} else {
			return "";
		}
    }
    /**
	 * 将时间转成"yyyy-MM-dd"格式的字符串
	 * 
	 * @param date
	 *            时间
	 * @return
	 * 
	 */
	public static String formatToYYYYMMDD(Date date) {
		if (date != null) {
			return YZYDateFormat.getInstance("yyyy-MM-dd").format(date);
		} else {
			return "null";
		}

	}

	public static String formatToYYYYMMDDMMHHSS(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

	public static Date formatToDayByYYYYMMDDMMHH(String s)
			throws ParseException {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy-MM-dd HH:mm");
		return format.parse(s);
	}

	public static String formatToYYYYMMDDMMHHSSSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
		return format.format(date);
	}

	public static String formatToYYYYMMDDSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy/MM/dd");
		return format.format(date);
	}

	public static String formatToYMZSlash(Date date) {
		YZYDateFormat format = YZYDateFormat.getInstance("yyyy年MM月dd日");
		return format.format(date);
	}

	public static String formatToYMZSMMHHSSSlash(Date date) {
		YZYDateFormat format = YZYDateFormat
				.getInstance("yyyy年MM月dd日 HH:mm:ss");
		return format.format(date);
	}

	/**
	 * 返回一个二维数组，单位分别是月和日，代表两个Date之差。 <br>
	 * 本方法忽略小时和分钟。 <br>
	 * <br>
	 * 例： <br>
	 * 1，2012年6月1日到2012年6月3日，返回值是[0,2] （2天） <br>
	 * 2，2012年6月15日到2012年8月4日，返回值是[1,20] （1个月零20天） <br>
	 * 3，2011年11月3日到2013年1月14日，返回值是[14,11] （14个月零11天）
	 * 
	 * @param olderDate
	 *            较早的日期
	 * @param newerDate
	 *            较晚的日期
	 * @return
	 * @throws Exception 
	 * @throws IllegalPlatformAugumentException
	 *             当olderDate晚于newerDate时
	 */
	public static int[] getDateDifferenceInMonthAndDay(Date olderDate,
			Date newerDate) throws Exception {
		int[] differenceInMonthAndDay = new int[2];
		int years = 0;
		int months = 0;
		int days = 0;

		Calendar older = Calendar.getInstance();
		Calendar newer = Calendar.getInstance();
		older.setTime(olderDate);
		newer.setTime(newerDate);

		if (olderDate.getTime() > newerDate.getTime()) {
			throw new Exception();
		} else {
			years = newer.get(Calendar.YEAR) - older.get(Calendar.YEAR);
			if (years >= 0) {

				months = newer.get(Calendar.MONTH) - older.get(Calendar.MONTH)
						+ 12 * years;
				older.add(Calendar.MONTH, months);
				days = newer.get(Calendar.DATE) - older.get(Calendar.DATE);

				if (days < 0) {
					months = months - 1;
					older.add(Calendar.MONTH, -1);
				}

				days = daysBetween(newer.getTime(), older.getTime());
				differenceInMonthAndDay[0] = months;
				differenceInMonthAndDay[1] = days;
			}

		}
		return differenceInMonthAndDay;
	}

	/**
	 * 取两个Date之间的天数差<br>
	 * <br>
	 * 例：newerDate是6月3日，olderDate是5月31日，则应返回3 <br>
	 * 一个更极端的列子：newerDate是6月3日 00:01，olderDate是6月2日
	 * 23:59，则应返回1，说明相差一天，即便实际上只差2分钟 <br>
	 * 此代码来自网上 <br>
	 * http://blog.csdn.net/rmartin/article/details/1452867
	 * 
	 * @param newerDate
	 * @param olderDate
	 * @return
	 */
	public static int daysBetween(Date newerDate, Date olderDate) {
		Calendar cNow = Calendar.getInstance();
		Calendar cReturnDate = Calendar.getInstance();
		cNow.setTime(newerDate);
		cReturnDate.setTime(olderDate);
		setTimeToMidnight(cNow);
		setTimeToMidnight(cReturnDate);
		long todayMs = cNow.getTimeInMillis();
		long returnMs = cReturnDate.getTimeInMillis();
		long intervalMs = todayMs - returnMs;
		return millisecondsToDays(intervalMs);
	}

	private static int millisecondsToDays(long intervalMs) {
		return (int) (intervalMs / (1000 * 86400));
	}

	private static void setTimeToMidnight(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
	}

	/**
	 * 得到距离当前时间前一个月的时间
	 * 
	 * @return
	 * 
	 */
	public static Date getLastMonthDate() {
		Calendar lastMonthDate = Calendar.getInstance();
		lastMonthDate.add(Calendar.MONTH, -1);
		return lastMonthDate.getTime();
	}

	/**
	 * 比较两个时间日期的大小
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int dateCompare(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(d1);
		c2.setTime(d2);
		return c1.compareTo(c2);
	}

	/**
	 * 解析日期zsj 20150302
	 * 
	 * @param dt
	 *            2015-03-01 23:59:59
	 * @param pattern
	 *            yyyy-MM-dd HH:mm:ss
	 */
	public static java.util.Date parseDate(String dt, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dt);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(getSecondFromDayEnd());
	}

	/**
	 * 得到当前时间距离当天截止偏移时间的秒数
	 * 
	 * @return
	 */
	public static int getSecondFromDayEnd() {
		Date cur = Calendar.getInstance().getTime();
		long end = getDayEnd(cur).getTime();
		long curs = Calendar.getInstance().getTimeInMillis();
		return (int) ((end - curs) / (1000));
	}

	/**
	 * 获取给定日的最后一刻。(10秒偏移)
	 * 
	 * @param when
	 *            给定日
	 * @return 最后一刻。例如：2006-4-19 23:59:50
	 */
	public static Date getDayEnd(Date when) {
		Date date = DateUtils.truncate(when, Calendar.DATE);
		date = addDays(date, 1, -30);
		date.setTime(date.getTime());
		return date;
	}

	/**
	 * 计算给定的日期加上给定的天数。
	 * 
	 * @param when
	 *            给定的日期
	 * @param amount
	 *            给定的天数
	 * @return 计算后的日期
	 */
	public static Date addDays(Date when, int amount, int offset) {
		return add(when, Calendar.DAY_OF_YEAR, amount, offset);
	}

	public static Date add(Date when, int field, int amount, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		calendar.add(field, amount);
		calendar.add(Calendar.SECOND, offset);
		return calendar.getTime();
	}
	/*****
	 * setCurrentDayLastSecond(设置时间当天最后一秒 xx-xx-xx:23:59:59)
	 * @param when
	 * @return 
	 * Date
	 * @exception 
	 * @since  1.0.0
	 */
	public static Date getCurrentDayLastSecond(Date when){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(when);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND,59);
		return calendar.getTime();
	}
}
