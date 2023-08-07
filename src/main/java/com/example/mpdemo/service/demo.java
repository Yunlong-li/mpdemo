package com.example.mpdemo.service;

import com.example.mpdemo.util.ExcelColumn;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: demo
 * @date 2023-08-07 11:14:36
 */
public class demo {
    public static <T> void writeExcelZH(HttpServletResponse response, List<T> dateList, Class<T> cls, String FileName){
        Field[] fields = cls.getDeclaredFields();
        List<Field> fieldList = Arrays.stream(fields)
                .filter(field -> {
                    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                    if (annotation != null && annotation.col()>0){
                        return true;
                    }
                    return false;
                }).sorted(Comparator.comparing(field -> {
                    int col = 0;
                    ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
                    if (annotation != null) {
                        col = annotation.col();
                    }
                    return col;
                })).collect(Collectors.toList());
    }
}
