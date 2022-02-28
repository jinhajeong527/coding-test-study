package com.jjh.study.stage.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//방금그곡
public class TheSongJustPlayedBefore {
	public static void main(String[] args) {
		TheSongJustPlayedBefore sp = new TheSongJustPlayedBefore();
		sp.solution("CC#BCC#BCC#", new String[] { "03:00,03:08,FOO,CC#B", "23:00,00:00,BELLO,A#" });
	}

	public String solution(String m, String[] musicinfos) {
		int maxPlayTime = -1;
		m = changeMelodyWithNumberSign(m);
		String answer = "";
		for (int i = 0; i < musicinfos.length; i++) {
			
			String[] infoSplits = musicinfos[i].split(",");
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			long minDiff = 0;
			
			try {
				Date startTime = dateFormat.parse(infoSplits[0]);
				Date endTime = dateFormat.parse(infoSplits[1]);
			
				minDiff = (endTime.getTime() - startTime.getTime())/60000;
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
				if(index==melodyArr.length) index = 0;
			}
			
			if(sb.toString().contains(m) && minDiff > maxPlayTime) {
				 answer = infoSplits[2];
				 maxPlayTime = (int) minDiff;
			}

		}
		System.out.println(answer);
		return maxPlayTime != -1 ? answer : "(None)";
	}
	
	public String changeMelodyWithNumberSign(String melody) {
		if(melody.contains("C#")) {
			melody = melody.replaceAll("C#", "H");
		}else if(melody.contains("D#")) {
			melody = melody.replaceAll("D#", "I");
		}else if(melody.contains("F#")) {
			melody = melody.replaceAll("F#", "J");		
		}else if(melody.contains("G#")) {
			melody = melody.replaceAll("G#", "K");		
		}else if(melody.contains("A#")) {
			melody = melody.replaceAll("A#", "L");		
		}
		return melody;
		
	}
}
