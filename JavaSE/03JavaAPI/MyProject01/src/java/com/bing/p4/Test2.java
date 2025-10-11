package com.bing.p4;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速感受一下ArrayList集合的用法
 */
public class Test2 {
    public static void main(String[] args) {
        // 可以直接初始化ArrayList集合
        ArrayList list1 = new ArrayList();
        // 初始化ArrayList集合使用List接口接收
        List list2 = new ArrayList();
        // 注意：上面两个集合在初始化的时候每天添加泛型，这样的什么类型的数据都可以往集合中添加
        // 我们将这个操作称为：装箱，但是装箱容易拆箱难
        list2.add(100);
        list2.add(55.55);
        list2.add("你好");
        list2.add(false);
        // 由于集合没有采用泛型定义，所有往集合中添加的数据都会被转为Object类型存储
        // 这里拿数据的时候，还要将Object类型的数据转为它之前的类型（一旦转失败了，就会发生异常）
        double num = (double)list2.get(1);
        System.out.println(num);
        System.out.println("----------------------");
        // 所以大部分情况下，我们都是使用泛型集合
        List<Integer> list3 = new ArrayList<>();
        list3.add(100);  //向集合中添加元素
        list3.add(200);
        list3.add(300);
        list3.add(200);
        // 获取集合的长度
        System.out.println("长度："+list3.size());
        System.out.println(list3);
        // 根据索引获取指定的元素
        Integer num2 = list3.get(1);
        System.out.println(num2);
        // 判断集合中是否存在指定的元素
        if(!list3.contains(300)){
            list3.add(300);
        }
        // 根据索引移除集合中指定的元素
        list3.remove(1);
        System.out.println(list3);

    }
}
