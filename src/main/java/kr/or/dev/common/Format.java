package kr.or.dev.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Format {
	
	// yyyy-MM-dd 폼
	public static String dateFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	// yyyy-MM-dd hh:mm 폼 
	public static String timeFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		return sdf.format(date);
	}
	
	// MM/dd 폼
	public static String monthFormat(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		return sdf.format(date);
	}

	
	/**
	* Method : minuteModi
	* 최초작성일 : 2018. 9. 12.
	* 작성자 : 김진영
	* 변경이력 :
	* @param date
	* @param duty
	* @return
	* @throws ParseException
	* Method 설명 : 알람 설정 메서드, 인자값으로 String date, 알람설정값인자 duty
	*/
	public static String notificationFormatter(String date, int duty)
			throws ParseException {

		// 현재시스템 시간값으로 캘린더 객체 생성
		Calendar now = Calendar.getInstance();

		// String 문자열을 date형으로 변환키위한 데이트포멧생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");

		// String 변수값(sdf.parse(date)을 톨해 Date타입으로 변경됨)으로 캘린더를 setTime.
		now.setTime(sdf.parse(date));

		// 위에서 세팅된 값을 duty(알림설정값)로 변경 -> 캘린더값이 변경됨
		// 현재는 분단위로 세팅(ex:-60 = 1시간전, -1440 = 1일전)
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.HOUR_OF_DAY),
				now.get(Calendar.MINUTE) + duty);

		// 캘린더에의 값을 각각의 변수에 저장
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);

		// return할 내용을 String 변수에 저장 
		String reDate = year + "-" + ((month < 10) ? "0" : "") + month + "-"
				+ ((day < 10) ? "0" : "") + day + " "
				+ ((hour < 10) ? "0" : "") + hour + ":"
				+ ((minute < 10) ? "0" : "") + minute;
		
		return reDate;
	}
	
	
	
	public static String dateCal(String start_time, String alert_time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		
		//두개의 String을 Date형으로 변경
		Date start = sdf.parse(start_time);
		Date alert = sdf.parse(alert_time);
		
		// 시간 차이를 시간, 분, 초를 곱한 값으로 나누면 하루 단위가 나옴
		long diff = start.getTime() - alert.getTime();
		long stringFormatMinute = diff/(60*1000);
		String date = "";
		
		if(stringFormatMinute==0){
			date = null;
		}else if(stringFormatMinute==10){
			date = "10 분";
		}else if(stringFormatMinute==30){
			date = "30분";
		}else if(stringFormatMinute==60){
			date = "1시간";
		}else if(stringFormatMinute==120){
			date = "2시간";
		}else if(stringFormatMinute==180){
			date = "3시간";
		}else if(stringFormatMinute==1440){
			date = "1일";
		}else if(stringFormatMinute==2880){
			date = "2일";
		}else if(stringFormatMinute==10080){
			date = "7일";
		}else{
			System.out.println("에러");
		}
				
		return date;
	}
	
	
}
