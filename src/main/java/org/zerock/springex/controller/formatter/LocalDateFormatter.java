package org.zerock.springex.controller.formatter;


import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//Formatter 인터페이스는 문자열 포맷을 이용해 특정한 객체로 변환하는 경우에 사용
public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale){
        return LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public String print(LocalDate object, Locale locale){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(object);
    }

}
