package com.jjh.study.stage.two.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public static void main(String[] args) {
        ColoringBook cb = new ColoringBook();
        int[] arr = new int[2];
        arr = cb.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };
    boolean[][] visited;
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    bsf(picture, i , j);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void bsf(int[][] picture, int x, int y) {
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(x,y));
        //해당 영역 카운트 하고 시작한다.
        int count = 1;
        while(!queue.isEmpty()) {
            Node curNode = queue.poll();

            for(int i = 0; i < dx.length; i++) {
                // 상하좌우 값 계산한다.
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                // 탐색 범위를 벗어났을 경우는 continue
                if(nx < 0 || ny < 0 || nx >= picture.length || ny >= picture[0].length) continue;
                // 방문한 적 있을 경우 continue;
                if(visited[nx][ny]) continue;

                if(picture[nx][ny] == picture[x][y]) {
                    count++; // 값 같으면 카운트 늘리고
                    visited[nx][ny] = true; //방문 표시하기
                    queue.offer(new Node(nx,ny)); //해당 nx, ny도 주변 탐색해야 하므로 큐에 집어넣는다.
                }
                else { // 같지 않으면 continue
                    continue;
                }
            }
        }
        maxSizeOfOneArea = count > maxSizeOfOneArea ? count : maxSizeOfOneArea;
        numberOfArea++;
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
