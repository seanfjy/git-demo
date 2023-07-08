package com.fanstudy.project;

import org.junit.jupiter.api.Test;

class MyLinkedListTest {

    @Test
    void test()throws Exception{
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3,0);
        myLinkedList.insert(7,1);
        myLinkedList.insert(9,2);
        myLinkedList.insert(5,3);
        myLinkedList.insert(6,1);
        myLinkedList.remove(0);
        myLinkedList.output();

    }
}