package com.zs.pms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author admin 时间类工具
 */
public class DateUtil {
	public static String getStrDate() {
		// 获得日历对象
		Calendar cal = Calendar.getInstance();
		// 当前的年
		int year = cal.get(Calendar.YEAR);
		// 当前的月
		int month = cal.get(Calendar.MONTH) + 1;
		// 当前的日
		int date = cal.get(Calendar.DATE);
		// 当前的小时（24）
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		// 当前的分
		// int minute = cal.get(Calendar.MINUTE);
		// 当前的秒
		// int second = cal.get(Calendar.SECOND);
		// 通过获得的当前小时来判断是上午、中午、下午
		String str = "";
		if (hour >= 6 && hour <= 11) {
			str = "上午好！";
		} else if (hour > 11 && hour <= 14) {
			str = "中午好！";
		} else if (hour > 14 && hour <= 18) {
			str = "下午好！";
		} else if (hour > 18 && hour < 24) {
			str = "晚上好！";
		} else {
			str = "夜已深！";
		}
		return year + "-" + month + "-" + date + str;
	}

	/**
	 * 字符串转Date的方法
	 * 
	 * @param time：字符串
	 * @param parrten：输入
	 * @return date的时间
	 * @throws ParseException
	 */
	public static Date getStrToDate(String time, String parrten) throws ParseException {
		// 获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(parrten);
		// 返回格式化好的时间
		return sdf.parse(time);
	}

	/**
	 * date转String时间的方法
	 * 
	 * @param time：date类的时间
	 * @param parrten：吧时间格式化成什么样
	 * @return：字符串类的时间
	 */
	public static String getDateToStr(Date time, String parrten) {
		// 获得格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat(parrten);
		// 返回格式化好的时间
		return sdf.format(time);
	}

}
