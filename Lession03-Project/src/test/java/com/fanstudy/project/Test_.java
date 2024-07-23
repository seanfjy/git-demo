package com.fanstudy.project;

import java.util.HashSet;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class Test_ {
    @Test
    void  testLinkedList(){
        LinkedList<String> list = new LinkedList<>();
        list.add("first");

    }
    @Test
    void testSet(){
        HashSet set = new HashSet();
        set.add("jack");
        set.add("jack");
        set.forEach(System.out::println);
    }

}
