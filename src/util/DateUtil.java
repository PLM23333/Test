package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateUtil {
	private DateUtil() {}
	/*
	 * ��ʱ��ת�����ַ�����ʽ
	 */
	public static String dateToStr(Date d, String form) {
		return new SimpleDateFormat(form).format(d);
	}
	/*
	 * ���ַ���ת����ʱ���ʽ
	 */
	public static Date dateParse(String d2, String form) throws ParseException {
		return new SimpleDateFormat(form).parse(d2);	
	}
}
