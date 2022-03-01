package com.jjh.study.stage.two;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//프린터
public class Printer {
    class Document { //위치정보와 중요도 담은 클래스
        int location;
        int priority;

        public Document(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

    }
    public int solution(int[] priorities, int location) {
        Queue<Document> queue = new LinkedList<>(); //클래스 Document
        int answer = 0;
        for(int i=0; i < priorities.length; i++) {
            queue.add(new Document(i, priorities[i]));
        }
        int now =0;
        while(!queue.isEmpty()) {
            Document doc = queue.poll();
            boolean flag = false;
            for(Document d: queue) {
                if(d.priority> doc.priority) {
                    flag = true;//표시해준다.
                }
            }
            if(flag) {//뒤로보내준다.
                queue.add(doc);
            } else { //우선순위 더 큰값이 없다면 출력한다.
                now++;
                if(location == doc.location){
                    answer = now;
                    break;
                }
            }
        }

        return answer;

    }


}


