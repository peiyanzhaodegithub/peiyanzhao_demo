package com.example.demo.queue;

import com.alibaba.fastjson.JSON;

public class MyCircularQueue {
    private int data[];// 数组容器
    private int front;// 头
    private int rear;// 尾
    private int maxsize;// 最大长度
    public MyCircularQueue(int k) {
        data = new int[k+1];
        front = 0;
        rear = 0;
        maxsize = k+1;
    }


    public boolean enQueue(int value)  {
        if (isFull())
            return  false;
        else {
            data[rear] = value;
            rear=(rear + 1) % maxsize;
        }
        return  true;
    }


    public boolean deQueue() {
        if (isEmpty())
            return false;
        else {
            front=(front+1)%maxsize;
        }
        return  true;
    }


    public int Front() {
        if(isEmpty())
            return -1;
        return data[front];
    }


    public int Rear() {
        if(isEmpty())
            return -1;
        return data[(rear-1+maxsize)%maxsize];
    }


    public boolean isEmpty() {
        return rear == front;
    }


    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(10);
        for (int i = 0; i < 100; i++){
            queue.enQueue(i);
            queue.deQueue();
        }
        System.out.println(JSON.toJSONString(queue));
        System.out.println(queue.Front());
        System.out.println(queue.Rear());
    }
}

