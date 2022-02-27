package com.jjh.study.stage.two;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//방금그곡
public class TheSongJustPlayedBefore {
    public static void main(String[] args) {
        TheSongJustPlayedBefore sp = new TheSongJustPlayedBefore();
        sp.solution("ABCDEFG",new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"});
    }
    public String solution(String m, String[] musicinfos) {
        String[] str = musicinfos[0].split(",");

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        try {
            Date startTime = dateFormat.parse(str[0]);
            System.out.println(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String answer = "";
        return answer;
    }
}
