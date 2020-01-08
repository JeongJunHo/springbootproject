package com.ssafy.safefood.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public static String getNowDateFormatYYYYMMDD() {
		SimpleDateFormat format = new SimpleDateFormat ("yyyy/MM/dd");
				
		Calendar time = Calendar.getInstance();
		       
		String format_time = format.format(time.getTime());
		
		return format_time;
	}
}
