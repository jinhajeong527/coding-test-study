package com.jjh.study.ds;

import java.util.*;

public class Graph {
    public static void main(String[] args) {

        Graph graph = new Graph();
        //노드를 만든다
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        //노드 간 연결해준다
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.traverseDepthFirst("A");

    }
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjecencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjecencyList.put(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if(fromNode==null)
            throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if(fromNode==null)
            throw new IllegalArgumentException();

        adjecencyList.get(fromNode).add(toNode);
    }

    public void print() {
        for(Node source: adjecencyList.keySet()) {
            List<Node> targets = adjecencyList.get(source);
            if(!targets.isEmpty()) {
                System.out.println(source + " is connected to "+ targets);
            }
        }
    }

    public void removeNode(String label) {
        //지우려는 노드
        Node node = nodes.get(label);
        if(node == null) return;
        //다른 노드에서 지우려는 타겟 노드의 커넥션 없애주어야 한다.
        for(Node n : adjecencyList.keySet())
            adjecencyList.get(n).remove(node);

        adjecencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if(fromNode == null || toNode == null)
            return;

        //fromNode에서 타겟 노드 지워준다.
        adjecencyList.get(fromNode).remove(toNode);
    }
    /* DFS 메서드 (recursive)
    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;

        traverseDepthFirst(node, new HashSet<>());
    }
    private void traverseDepthFirst(Node root, Set<Node> visited){
        System.out.println(root);
        visited.add(root);

        for(Node node: adjecencyList.get(root))
            //방문한 노드가 아니라면
            if(!visited.contains(node))
                traverseDepthFirst(node, visited);
    }
    */
    public void traverseDepthFirst(String root) {
        Node node = nodes.get(root);
        if(node == null)
            return;

        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);

        while(!stack.isEmpty()) {
            Node current = stack.pop();

            //방문한 적 있으면, while문의 처음으로 돌아가 스택에서 다른 노드 얻어온다.
            if(visited.contains(current))
                continue;

            System.out.println(current);
            visited.add(current);//방문한 적 있는 노드에 추가한다.
            //해당 노드의 모든 방문한 적 없는 이웃 노드들을 스택에 추가한다.
            for(Node neighbour: adjecencyList.get(current)) {
                if(!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }
    }
}
