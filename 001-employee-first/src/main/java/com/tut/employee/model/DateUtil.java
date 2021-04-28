package com.tut.employee.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public String randomDate(String beginDate,String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = sdf.parse(beginDate);
        Date end = sdf.parse(endDate);

        if(begin.getTime() >= end.getTime()){
            return null;
        }
        long date = random(begin.getTime(),end.getTime());
        return sdf.format(new Date(date));
    }
    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }
}
