package com.fanstudy.project;

import java.util.Arrays;


/**
 * 优先队列 大顶堆
 */
public class MyPriorityQueue {

    private  int[] array;
    private int size;
    public MyPriorityQueue(){
        array = new int[32];
    }

    /**
     * 入队
     * @param key 入队元素
     */
    public void enQueue(int key){
        if (size>= array.length){
            resize();
        }
        array[size++]=key;
        upAdjust();
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception{
        if (size<0){
            throw new Exception("the queue is empty!");
        }
        //获取堆顶元素
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0]=array[--size];
        downAdjust();
        return head;
    }

    private void downAdjust() {
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex<size){
            if (childIndex+1<size&&array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            if (temp>=array[childIndex]){
                break;
            }
            array[parentIndex]=array[childIndex];
            parentIndex =childIndex;
            childIndex = 2*childIndex+1;
        }
        array[parentIndex] = temp;

    }

    private void upAdjust() {
        int childIndex = size -1;
        int parentIndex = (childIndex-1)/2;

        int temp = array[childIndex];
        while (childIndex>0&&temp>array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;

        }
        array[childIndex] = temp;
    }

    private void resize() {
        //队列容量翻倍
        int newSize = this.size<<1;
        this.array = Arrays.copyOf(this.array,newSize);
    }


    public static void main(String[] args) throws Exception {
        MyPriorityQueue priorityQueue = new MyPriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);

        System.out.println("出队元素:"+priorityQueue.deQueue());
        System.out.println("出队元素:"+priorityQueue.deQueue());

    }
}
