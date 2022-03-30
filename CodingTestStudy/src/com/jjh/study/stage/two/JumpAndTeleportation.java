package com.jjh.study.stage.two;

//점프와 순간이동
public class JumpAndTeleportation {
	//top down 의 문제 해결 방법
	public int solution(int n) {
        int ans = 0;
        while(true) {
        	if(n % 2 == 0) n /= 2;
        	if(n % 2 == 1) {
        		n -= 1;
        		ans++;
        	}
        	if(n==0) break;
        }
        
        return ans;
    }

}
