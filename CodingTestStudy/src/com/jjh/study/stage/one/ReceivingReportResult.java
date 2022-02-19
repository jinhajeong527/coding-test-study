package com.jjh.study.stage.one;

import java.util.*;

//신고 결과 받기
public class ReceivingReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {
        //신고당한 사람이 자신을 신고한 사람의 리스트를 갖고 있는다.
        //중복 신고는 카운트되지 않으므로, Set을 사용했다.
        Map<String, Set<String>> map = new HashMap<>();
        //신고당한 사람 키값, 신고인 set으로 값 심어준다.
        for(int i=0; i< report.length; i++) {
            String[] splitArr = report[i].split("\\s");
            if(!map.containsKey(splitArr[1])) {//아직 신고자 키값이 없으면
                HashSet<String> set = new HashSet<>();
                set.add(splitArr[0]);
                map.put(splitArr[1], set);
            }else{//이미 신고자 키가 있으면, 신고한 사람 리스트에 추가해준다.
                Set<String> set = map.get(splitArr[1]);
                set.add(splitArr[0]);
            }
        }
        //신고자가 자기가 신고한 사람이 k번 이상 신고당했을 때 메일을 받을 것이므로,
        //신고자가 키 값, 메일 받는 회수 Integer로 HashMap 선언해준다.
        Map<String,Integer> reporterMap = new HashMap<>();
        //각 키값의 길이가 k이상 일 때, 신고한 사람을 키값으로 Integer를 늘려준다.
        for(Map.Entry<String, Set<String>> entry: map.entrySet()){
            if(entry.getValue().size() >= k) {
                for(String reporter: entry.getValue()){
                    int x = 0;
                    if(reporterMap.containsKey(reporter))  {
                        x = reporterMap.get(reporter);
                    }
                    reporterMap.put(reporter, x+1);
                }
            }
        }
        int idLength = id_list.length;
        int[] answer = new int[idLength];
        for(int i=0; i < idLength; i++) {
            if(reporterMap.get(id_list[i]) != null) answer[i] = reporterMap.get(id_list[i]);
        }

        return answer;
    }
}
