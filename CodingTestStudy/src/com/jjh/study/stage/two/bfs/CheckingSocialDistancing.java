package com.jjh.study.stage.two.bfs;

import java.util.LinkedList;
import java.util.Queue;

// 거리두기 확인하기
public class CheckingSocialDistancing {
	// 현재 위치에서 상하좌우로 움직였을 때의 값 확인하기 위해 작성함
	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { -1, 0, 1, 0 };
	public int[] solution(String[][] places) {
		
        int[] answer = new int[places.length];
        for(int i = 0; i < places.length; i++) {
        	answer[i] = isKeepingSocialDistancing(places[i]);
        }
        return answer;
    }
	private int isKeepingSocialDistancing(String[] waitingRoom) {
		
		for(int i = 0; i < waitingRoom.length; i++) {
			for(int j = 0; j < waitingRoom[i].length(); j++) {
				// 사람 앉아 있는 위치 발견하면 너비 우선 탐색 사용해서 거리두기가 잘 지켜지고 있는지 확인한다.
				if(waitingRoom[i].charAt(j) == 'P') { 
					if(!bfs(waitingRoom, i, j)) return 0;
				}
			}
		}
		return 1;
	}
	
	private boolean bfs(String[] waitingRoom, int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] visited = new boolean[waitingRoom.length][waitingRoom[0].length()];
		queue.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node cuNode = queue.poll();
			for(int i = 0; i < dx.length; i++) {
				int nx = cuNode.x + dx[i];
				int ny = cuNode.y + dy[i];
				int manhattan = Math.abs(nx-x) + Math.abs(ny-y);
				// 탐색범위 벗어났을 경우 continue
				if(nx < 0 || ny < 0 || nx >= waitingRoom.length || ny >= waitingRoom.length) continue;
				// 방문한 적 있거나 맨하탄 거리가 2를 초과할 경우 continue
				if(visited[nx][ny] || manhattan > 2) continue;
				
				visited[nx][ny] = true;

				if(waitingRoom[nx].charAt(ny) == 'X') continue;
				else if(waitingRoom[nx].charAt(ny) == 'P') return false;
				else queue.offer(new Node(nx, ny));
			}
			
		}
		return true;
	}

	public class Node {
		
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
