package com.hisham.blackjack;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.annotation.SuppressLint;
import android.text.format.DateUtils;

@SuppressLint("SimpleDateFormat")
public class DateConversion {
	TimeZone calcutta = TimeZone.getTimeZone("Asia/Calcutta");
	DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public DateConversion() {
		dfm.setTimeZone(calcutta);
	}
	
	// get date - example 20 min ago
	public String getDate(String created)
	{
		try {
		Date date = dfm.parse(created);

		String result = (String) DateUtils.getRelativeTimeSpanString(
				date.getTime(), new Date().getTime(), DateUtils.SECOND_IN_MILLIS);
		return result;

		} catch (ParseException e) {
			return "Invalid date";
		}
	}

	// get date - example 20 min ago
	public String getDate(Date created) {
		String result = (String) DateUtils.getRelativeTimeSpanString(created.getTime(), new Date().getTime(), DateUtils.SECOND_IN_MILLIS);
		return result;
	}
	// example - 2014-01-12 14:25:50
	public String getSQLDate(long timestamp)
	{
		Date date = new Date(timestamp);
		return dfm.format(date);
	}
	
	// get time in milliseconds example - 101541201200 
	public long getTimeStamp(String created)
	{
		try {
		Date date = dfm.parse(created);
		return date.getTime();
		} catch (ParseException e) {
			return new Date().getTime();
		}
	}
	
	

}
