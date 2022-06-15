package com.jjh.study.stage.two.dp;

public class Friends4Blocks {
	static char[][] map;
	public static void main(String[] args) {
		Friends4Blocks f4b = new Friends4Blocks();
        f4b.solution(4, 5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"});
	}
	public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        // 이차원 배열로 만들기
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) 
        		map[i][j] = board[i].charAt(j);
        }
        
        while(true) {
        	int count = checkBlock(m, n);
        	if(count == 0) break;
        	answer += count;
        	dropBlock(m, n);
        }
        
        return answer;
    }
	
	private int checkBlock(int m, int n) {
		boolean[][] dp = new boolean[m][n];
        for(int i = 1; i < m ; i++) {
        	for(int j = 1; j < n; j++) {
        		if(map[i][j] != '.') {
        			char cur = map[i][j];
        			if(cur == map[i-1][j-1] && cur == map[i-1][j] && cur == map[i][j-1]) {
        				dp[i][j] = true;
        				dp[i][j-1] = true;
        				dp[i-1][j-1] = true;
        				dp[i-1][j] = true;
        			}
        		}
        	}
        }
                
		return countBlock(m, n, dp);
	}
	private int countBlock(int m, int n, boolean[][] dp) {
		int count = 0;
		for(int i = 0; i < m ; i++) {
			for(int j = 0; j < n ; j++) {
				if(dp[i][j]) {
					count++;
					map[i][j] = '.';
				}
			}
		}
		return count;
	}
	private void dropBlock(int m, int n) {
		for(int i = m - 1; i > 0; i--) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] =='.') {
					for(int k = i - 1; k >= 0; k--) {
						if(map[k][j] !='.') {
							map[i][j] = map[k][j];
							map[k][j] ='.';
							break;
						}
					}
				}
			}
		}
	}
}
