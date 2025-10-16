package com.bing.p6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        // 列表集合
        List<String> list = new ArrayList<String>(){{
            this.add("A");
            this.add("B");
            this.add("C");
            this.add("D");
        }};
        // 将列表集合中的B删除
        /*for(int i=0;i<list.size();i++){
            if(list.get(i).equals("B")){
                list.remove(i);
            }
        }*/
        // 返回当前集合的迭代器
        Iterator<String> iterator = list.iterator();
        //hasNext方法，用于判断是否有下一个元素
        //next方法，用于获取下一个元素
        //remove方法，用于移除当前元素
        /*while (iterator.hasNext()){
            if(iterator.next().equals("B")){
                iterator.remove();
            }
        }*/
        //Stream流，就像工厂里面的流水线，将集合做为这个流水线上的商品
        //在生产线上对我们的集合做加工
        //Stream流对象的每个方法，就是一个环节
        list = list
                .stream()   //将当前集合转为stream流
                .filter(e->!e.equals("B"))  //过滤掉出不是B的元素
                .collect(Collectors.toList());  //重新将stream流转为List集合
        System.out.println(list);
    }
}
