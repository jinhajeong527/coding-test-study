package com.jjh.study.leet.easy.dfs;

public class FloodFill {
    // 방문 표시
    static boolean visited[][];
    // 기존 컬러
    static int originalColor;
    // 바꾸고자 하는 컬러
    static int aimedColor;
    static int[][] newImage;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        originalColor = image[sr][sc];
        aimedColor = color;
        newImage = image;
        visited = new boolean[image.length][image[0].length];
        dfs(visited, newImage, sr, sc, aimedColor);
        return newImage;
    }

    private void dfs(boolean[][] visited, int[][] newImage, int sr, int sc, int aimedColor) {
        if(!visited[sr][sc]) {
            visited[sr][sc] = true;
            if(originalColor == newImage[sr][sc]) {
                newImage[sr][sc] = aimedColor;
                // 조건 하나하나 써주는 대신 아래와 같이 한 번에 OR 연산으로 정리할 수도 있음.
                // if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) return;
                // 왼쪽 탐색
                if(sc-1 >= 0) dfs(visited, newImage, sr, sc - 1, aimedColor);
                // 오른쪽 탐색
                if(sc+1 < newImage[0].length) dfs(visited, newImage, sr, sc + 1, aimedColor);
                // 위쪽 탐색
                if(sr-1 >= 0) dfs(visited, newImage, sr - 1, sc, aimedColor);
                // 아래쪽 탐색
                if(sr+1 < newImage.length) dfs(visited, newImage, sr + 1, sc, aimedColor);
            }
        }
    }
}
