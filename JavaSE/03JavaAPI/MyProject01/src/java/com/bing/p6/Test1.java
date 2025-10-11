package com.bing.p6;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        System.out.println(map);
        // 对指定key的value重新计算
        map.compute(1,(k,v)->{
            return v+"M";
        });
        // compute方法，如果找不到指定的key，也会执行，此时的value为null
        map.compute(3,(k,v)->{
            return v+"W";
        });
        System.out.println(map);
        // computeIfPresent方法，也是用于指定key的value值做重新计算
        // 当key不存在时，不执行
        map.computeIfPresent(1,(k,v)->{
            return v+"M";
        });
        System.out.println(map);
        map.computeIfPresent(4,(k,v)->{
            return v+"X";
        });
        System.out.println(map);
        // computeIfAbsent方法，用于添加key不存在的元素
        map.computeIfAbsent(1,(k)->{
           return "Hello";
        });
        System.out.println(map);
        // 其实就是先判断key是否不存在，然后再添加指定的值
        map.computeIfAbsent(5,(k)->{
            return "World";
        });
        System.out.println(map);
    }
}
