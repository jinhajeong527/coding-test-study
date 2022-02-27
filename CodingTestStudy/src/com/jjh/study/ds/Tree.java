package com.jjh.study.ds;


public class Tree {
    private class Node {
        private int value;
        private Node leftChild;//왼쪽 자식 레퍼런스
        private Node rightChild;//오른쪽 자식 레퍼런스

        public Node(int value) {
            this.value = value;
        }
        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root; //이제 insert operation 구현할 수 있음.

    public void insert(int value) {
        //Tree가 Empty한 경우: root를 new node로 셋팅 해준다.
            if(root == null){
                root = new Node(value);
                return;
            }
        //Tree가 Empty하지 않은 경우: 새로운 노드(value)의 부모를 찾아주어야 한다.
            Node current = root;
            while(true) {
                if(value < current.value){
                    if(current.leftChild == null) {//부모노드 찾았다는 뜻이 된다.
                        current.leftChild = new Node(value);
                        break;
                    }
                    current = current.leftChild;
                }
                else {
                    if(current.rightChild == null) {
                        current.rightChild = new Node(value);
                        break;
                    }
                    current = current.rightChild;
                }
            }
    }

    public boolean find(int value) {
        Node current = root;
        while(current != null) { //Tree가 비어있다면 이코드는 실행되지 않을 것.
            if(value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }
}
