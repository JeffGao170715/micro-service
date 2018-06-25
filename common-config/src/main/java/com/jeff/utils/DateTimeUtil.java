package com.jeff.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期时间工具类
 * Created by Jeff on 2018/6/22.
 */
public final class DateTimeUtil {

    /**
     * 获取当前时间
     * @return
     */
    public static LocalDateTime now(){
        return LocalDateTime.now();
    }

    /**
     * 格式化输出当前时间：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getDateTime_Formated(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取当前日期：yyyy-MM-dd
     * @return
     */
    public static LocalDate getDate(){
        return LocalDate.now();
    }


    /**
     * 获取当前时间的毫秒级时间戳
     * @return
     */
    public static long getTimeStamp(){
        return Instant.now().toEpochMilli();
    }



    public static void main(String[] args){
        System.out.println(getTimeStamp());

    }
}
