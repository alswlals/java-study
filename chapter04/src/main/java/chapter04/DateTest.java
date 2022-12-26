package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now); //Mon Dec 26 13:01:03 KST 2022
		
		printDate01(now);
		printDate02(now);
	}

	private static void printDate01(Date d) {
		// 2022-12-26 13:01:06
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(d);
		
		System.out.println(date);
	}
	
	private static void printDate02(Date d) {
		/* 년도*/
		int year = d.getYear();  //(year+1900)+"-"
		
		/* 월(0~11, +1)*/
		int month = d.getMonth();
		
		/* 일 */
		int date = d.getDate();
		
		// 시
		int hours = d.getHours();
		
		// 분
		int minutes = d.getMinutes();
		
		// 초
		int seconds = d.getSeconds();
		
		System.out.println((year+1900)+"-"+(month+1)+"-"+date+" "+hours+":"+minutes+":"+seconds);
	}

}
