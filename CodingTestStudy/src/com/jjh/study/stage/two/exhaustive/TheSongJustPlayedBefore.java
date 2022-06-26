package com.jjh.study.stage.two.exhaustive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//방금그곡
public class TheSongJustPlayedBefore {
	public static void main(String[] args) {
		TheSongJustPlayedBefore sp = new TheSongJustPlayedBefore();
		sp.solution("CC#BCC#BCC#", new String[] { "03:00,03:08,FOO,CC#B", "23:00,23:59,BELLO,A#" });
	}

	public String solution(String m, String[] musicinfos) {
		int maxPlayTime = -1;
		// C# 과 같이 한 음이면서 한글자가 아닌 음을 한글자의 대문자 알파벳으로 바꿔주는 메서드
		m = changeMelodyWithNumberSign(m);
		String answer = "";
		for (int i = 0; i < musicinfos.length; i++) {
			// 배열 String 예시 데이터 : "12:00,12:14,HELLO,CDEFGAB"
			String[] infoSplits = musicinfos[i].split(",");
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			long minDiff = 0;
			
			try {
				Date startTime = dateFormat.parse(infoSplits[0]);
				Date endTime = dateFormat.parse(infoSplits[1]);
				minDiff = (endTime.getTime() - startTime.getTime()) / 60000;
			} catch (ParseException e) {
				e.printStackTrace();
			}

			infoSplits[3] = changeMelodyWithNumberSign(infoSplits[3]);
			char[] melodyArr = infoSplits[3].toCharArray();
			StringBuilder sb = new StringBuilder();
			int index = 0;
			for(int j = 0; j < minDiff; j++) {
				sb.append(melodyArr[index]);
				index++;
				if(index == melodyArr.length) index = 0;
			}
			// 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환
			if(sb.toString().contains(m) && minDiff > maxPlayTime) {
				 answer = infoSplits[2];
				 maxPlayTime = (int) minDiff;
			}

		}
		return maxPlayTime != -1 ? answer : "(None)";
	}
	
	public String changeMelodyWithNumberSign(String melody) {

		melody = melody.replaceAll("C#", "H");
		melody = melody.replaceAll("D#", "I");
		melody = melody.replaceAll("F#", "J");
		melody = melody.replaceAll("G#", "K");
		melody = melody.replaceAll("A#", "L");

		return melody;
	}
}
