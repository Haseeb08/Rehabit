package com.vikingzorros.rehabit.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeController {

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;
    private static final int WEEK_MILLIS = 7 * DAY_MILLIS;
    private static final int YEAR_MILLIS = 365 * DAY_MILLIS;

    public static String convert(String inputDateTime){

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date date = df.parse(inputDateTime);
            long dateTimeEpoch = date.getTime();

            long now = new Date().getTime();
            long diff = now - dateTimeEpoch;

            //System.out.println(now+"-"+dateTimeEpoch+"="+YEAR_MILLIS);

            if (diff < MINUTE_MILLIS) {
                return "just now";
            } else if (diff < 2 * MINUTE_MILLIS) {
                return "a minute ago";
            } else if (diff < 50 * MINUTE_MILLIS) {
                return diff / MINUTE_MILLIS + " minutes ago";
            } else if (diff < 90 * MINUTE_MILLIS) {
                return "an hour ago";
            } else if (diff < 24 * HOUR_MILLIS) {
                return diff / HOUR_MILLIS + " hours ago";
            } else if (diff < 48 * HOUR_MILLIS) {
                return "yesterday";
            } else if (diff < 7 * DAY_MILLIS) {
                return diff / DAY_MILLIS + " days ago";
            } else if (diff < 2 * WEEK_MILLIS) {
                return "a week ago";
            } else if (diff < YEAR_MILLIS) {
                SimpleDateFormat df1 = new SimpleDateFormat("MMM-dd");
                return df1.format(date);
            } else {
                SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MMM-dd");
                return df1.format(date);
            }
        }catch (ParseException parseException){
            return "";
        }
    }

}