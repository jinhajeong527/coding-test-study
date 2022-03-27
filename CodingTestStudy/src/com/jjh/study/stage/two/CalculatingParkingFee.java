package com.jjh.study.stage.two;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//주차요금계산
public class CalculatingParkingFee {
    public static void main(String[] args) throws ParseException {
        CalculatingParkingFee cp = new CalculatingParkingFee();
        cp.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN",
                "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }
    public int[] solution(int[] fees, String[] records) throws ParseException {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i=0; i <records.length ; i++) {
            String[] strArr = records[i].split("\\s");//공백 기준으로 스플릿한다.
            if("IN".equals(strArr[2])) map.put(strArr[1], strArr[0]);//입차일 경우에 차 번호를 키 입차 시간을 값으로 하여 map에 담아준다.
            else if("OUT".equals(strArr[2])) { // 출차일 경우에는 입차 시간 알아내서 분차이 계산해야 한다.
                String inTime = map.get(strArr[1]);
                String outTime = strArr[0];
                int diffMin = getMinDifference(inTime, outTime);
                //영업 시간내에 입차와 출차 한번 초과하여 이루어질 수 있기 때문에 여기도 조건문 필요하다.
                if(map2.containsKey(strArr[1])) map2.put(strArr[1], map2.get(strArr[1]) + diffMin);
                else map2.put(strArr[1],diffMin);//출차 시에 분차이 계산해서 새로운 맵 map2 에다가 저장해 놓는다.

                map.remove(strArr[1]);//계산 끝났으면 맵에서 삭제한다 ==> 계산 끝나지 않고 IN만 남아있는 차 판별해야 하기 때문.
            }
        }
        //IN만 있고, OUT 없었던 경우는 => 23:59가 출차인 경우
        if(!map.isEmpty()) {
            for(String carNum: map.keySet()) {
                String inTime = map.get(carNum);
                String outTime = "23:59";
                int diffMin = getMinDifference(inTime, outTime);

                //이미 전에 입차 및 출차해서 map2에 주차 시간 기록 있는 차일 경우에 기존 시간 및 현재 계산 시간 합쳐준다.
                if(map2.containsKey(carNum)) map2.put(carNum, map2.get(carNum) + diffMin);
                else map2.put(carNum, diffMin);
            }
        }
        //주차 시간
        for(String carNum : map2.keySet()) {
            int stayedTime = map2.get(carNum);
            if(stayedTime < fees[0]) { // 기본시간보다 적게 머물렀다면
                map2.replace(carNum, fees[1]); //기본 요금만 내면 된다.
            }else {
                //둘다 인트형이므로 소수점이 나올 수도 있는 가능성에 대해서는 double로의 형변환을 통해 명시하기
                int fee = fees[1] + (int)Math.ceil(((map2.get(carNum) - fees[0])/(double)fees[2])) * fees[3];
                map2.replace(carNum, fee);
            }
        }
        int[] answer = new int[map2.size()];

        //차번호 작은 순서대로 answer 리턴해주기 위해 맵 순서 정렬해주어야 한다.
        //LinkedHashMap의 사용
        Map<String, Integer> map3 = sortMapByKey(map2);
        int index = 0;
        for (Map.Entry<String, Integer> entry : map3.entrySet()) {
            answer[index] = entry.getValue();
            index++;
        }
        return answer;
    }
    public int getMinDifference(String inTime, String outTime) throws ParseException {
        Date format1 = new SimpleDateFormat("HH:mm").parse(inTime);
        Date format2 = new SimpleDateFormat("HH:mm").parse(outTime);
        int diffMin = (int)(format2.getTime() - format1.getTime()) / 60000; //입차시간과 출차시간의 분 차이 구하기
        return diffMin;
    }
    //LinkedHashMap을 사용한 정렬
    public static LinkedHashMap<String,Integer> sortMapByKey(Map<String,Integer> map2) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map2.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
