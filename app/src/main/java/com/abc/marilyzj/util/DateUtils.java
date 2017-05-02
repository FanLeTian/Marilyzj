package com.abc.marilyzj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class DateUtils {

    public static String addDate(String d, long day)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        long lt = new Long(d);
        Date date = new Date(lt);
        long time = date.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return simpleDateFormat.format(new Date(time));
    }
    public static String addDateToFull(String d, long day)  {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(d);
        Date date = new Date(lt);
        long time = date.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return simpleDateFormat.format(new Date(time));
    }
    public static String addStringToDate(String d, long day) {
        long lt = new Long(d);
        Date date = new Date(lt);
        long time = date.getTime();
        day = day * 24 * 60 * 60 * 1000;
        time += day;
        return new Date(time).getTime() + "";
    }

    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM月dd日");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static String stampToDateFull(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
    public static boolean compareDate(String Date1, String Date2) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA);
            Date d1 = sdf.parse(Date1);
            Date d2 = sdf.parse(Date2);
            return d1.before(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return false;
        }
    }
}
