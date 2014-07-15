package com.app4j.tradeobserver.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateUtil {
	public static String addYmdDay(Date date, int year, int month, int day){
		date = DateUtils.addYears(date, year);
		date = DateUtils.addMonths(date, month);
		date = DateUtils.addDays(date, day);
		
		return DateFormatUtils.format(date, "yyyyMMdd");
	}
	
	public static Date getYmdFormatDate(String ymdDay) throws ParseException {
		return new SimpleDateFormat("yyyyMMdd").parse(ymdDay);
	}

}
