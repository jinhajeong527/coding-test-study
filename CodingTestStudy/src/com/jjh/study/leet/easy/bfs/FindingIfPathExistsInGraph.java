package com.jjh.study.leet.easy.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 넓이 우선 탐색으로 풀어보기
public class FindingIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 노드 방문 표시
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graphs = new HashSet[n];
        for(int i = 0; i < n; i++) {
            graphs[i] = new HashSet<>();
        }
        for(int i = 0; i < edges.length; i++) {
            graphs[edges[i][0]].add(edges[i][1]);
            graphs[edges[i][1]].add(edges[i][0]);
        }
        if(graphs[source].contains(destination)) return true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int current;
        visited[source] = true;
        while(!queue.isEmpty()) {
            current = queue.poll();
            if(current == destination) return true;
            for(int value : graphs[current]) {
                if(!visited[value]) {
                    visited[value] = true;
                    queue.offer(value);
                }
            }
        }
        return false;
    }
}
