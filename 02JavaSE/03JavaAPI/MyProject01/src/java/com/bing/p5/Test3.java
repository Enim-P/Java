package com.bing.p5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合
 */
public class Test3 {
    public static void main(String[] args) {
        // Map是映射集合，通过一个键指向一个值的数据结构，所以Map又称为：键值对集合
        // 这里我们定义一个Map集合，键是String类型，值是Integer类型
        Map<String,Integer> map = new HashMap<>();
        // put方法，用于添加元素。指定一个key值，对应一个value值
        map.put("A",100);
        map.put("B",200);
        map.put("C",300);
        // 添加元素时，key值重复了，会覆盖之前的元素
        map.put("B",400);
        System.out.println(map);
        // get方法，用于获取指定key值的value
        Integer num = map.get("B");
        System.out.println(num);
        // 判断指定的key是否存在
        System.out.println(map.containsKey("B"));
        // 判断指定的value是否存在
        System.out.println(map.containsValue(100));
        System.out.println("--------------------");
        map.forEach((k,v)->{
            System.out.println("key："+k+" value:"+v);
        });
        System.out.println("--------------------");
        // map集合中的每一对键值对就是一个Entry实例
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            // 通过键值对实例，分别获取键和值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" -> "+value);
        }
        System.out.println("--------------------");
        // 单独获取所有key的集合，返回值是一个Set
        Set<String> keys = map.keySet();
        System.out.println(keys);
        // 单独返回所有value的集合，返回值是Collection
        Collection<Integer> values = map.values();
        System.out.println(values);
        System.out.println("--------------------");
        // 遍历所有的键
        for (String key : map.keySet()){
            // 根据键再获取对应的值
            System.out.println(key+" -> "+map.get(key));
        }
        System.out.println("--------------------");
        // 根据键删除值
        map.remove("B");
        System.out.println(map);
        System.out.println(map.get("B"));
        // getOrDefault方法，在获取值时，如果指定的key不存在，返回提供的默认值
        System.out.println(map.getOrDefault("B",10000));
        System.out.println(map.getOrDefault("A",20000));
    }
}
