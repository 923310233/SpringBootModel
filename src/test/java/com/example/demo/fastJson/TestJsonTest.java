package com.example.demo.fastJson;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 10:20 AM
 * @Version 1.0
 */
public class TestJsonTest {


    @Test
    public void testTreeMap(){
        TreeMap<Integer, String> treemap = new TreeMap<>();
        SortedMap<Integer, String> treemapincl;

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        treemapincl = treemap.tailMap(2,true);

        return;

    }

    @Test
    public void testLinkedMap(){
        LinkedHashMap<Integer,Integer>map = new LinkedHashMap<>(100);
        for(int i = 0 ;i<50 ;i++){
            map.put(i,i);
        }


        for(int j =0;j<400;j++){
            map.remove(j);
        }
        return;
    }

}