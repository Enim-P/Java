package com.bing.p6;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        // 集合在定义的时候，是可以嵌套的
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A",new ArrayList<>());
        map.put("B",new LinkedList<>());
        // 获取A对应的List集合，再往集合中添加元素
        map.get("A").add(100);
        // 集合可以无限嵌套
        Map<String,Map<String,Map<String,Integer>>> map2 = new HashMap<>();
        map2.put("A",new HashMap<>());
        map2.get("A").put("B",new HashMap<>());
        map2.get("A").get("B").put("C",100);

    }
}
