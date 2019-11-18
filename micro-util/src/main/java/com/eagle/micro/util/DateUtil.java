package com.eagle.micro.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 日期工具
 * 
 * @author jiangyonghua
 * @date 2019年10月14日
 */
public class DateUtil {

	private static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
		return sdf.format(date);
	}
}
