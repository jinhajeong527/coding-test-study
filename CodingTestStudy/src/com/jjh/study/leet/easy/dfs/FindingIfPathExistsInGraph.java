package com.jjh.study.leet.easy.dfs;

import java.util.HashSet;

public class FindingIfPathExistsInGraph {
    boolean result;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 노드의 개수 n을 사용해서 해당 노드 방문한 적 있는지 여부 표시하는 visited 배열 선언한다.
        boolean visited[] = new boolean[n];
        // 해당 노드가 연결되어 있는 노드가 무엇인지 담아주기 위한 HashSet 노드를 선언한다.
        HashSet<Integer>[] graph = new HashSet[n];
        // 각 그래프 마다 해쉬셋 선언해준다.
        for(int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        // 양방향 연결이므로 각 그래프 양방향 연결 표시 해준다.
        for(int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        // 바로 가는 길이 있을 경우에 true를 리턴한다.
        if(graph[source].contains(destination)) return true;
        result = false;
        // 깊이 우선 탐색의 시작.
        dfs(graph, visited, source, destination);

        return result;
    }

    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int source, int destination) {
        if(!visited[source] && !result) {
            if(source == destination) {
                result = true;
                return;
            }
            // source 노드 방문 표시 해주고, 깊이 우선 탐색을 source 부터 시작한다.
            visited[source] = true;
            // neighbor 해당 노드에서 연결 되어 있는 노드의 값이다.
            for(Integer neighbor : graph[source]) {
                dfs(graph, visited, neighbor, destination);
            }
        }
    }
}
