package com.jjh.study.ds;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int capacity){
        items = new int[capacity];
    }

    public void enqueue(int item){
        if(count == items.length) //큐가 꽉차게 되면, 예외를 던진다.
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear+1) % items.length;
        count++;//아이템을 추가할 때마다 카운트가 1씩 증가된다.
    }
    public int dequeue() {
        int item = items[front]; //front 인덱스 값의 데이터 값 받아와서 리턴해준다.
        items[front] = 0; // 해당 인덱스의 값을 0으로 초기화 해준다.
        front = (front +1) % items.length;
        count--;
        return item;
    }
    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
