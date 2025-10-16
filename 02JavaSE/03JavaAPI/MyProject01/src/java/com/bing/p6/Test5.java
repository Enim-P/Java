package com.bing.p6;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(){{
            this.add(55);
            this.add(27);
            this.add(12);
            this.add(33);
            this.add(68);
            this.add(9);
            this.add(27);
            this.add(12);
            this.add(33);
            this.add(55);
            this.add(48);
            this.add(39);
            this.add(22);
            this.add(9);
            this.add(68);
            this.add(12);
            this.add(39);
            this.add(27);
        }};
        System.out.println(list);
        // 对集合进行去重，降序排列后每个元素再加10，跳过前3个元素，返回后3个元素，并将保留最终结果
        List<Integer> list2 = list.stream()  //转为stream流
                .distinct() //去重
                .sorted((a, b) -> b - a)   //降序排列
                .map(e -> {
                    System.out.println("aaaa");
                    return e + 10;
                })   //映射，这里是每个元素+10
                .skip(3)    //跳过指定数量
                .limit(3)  //返回指定数量
                .collect(Collectors.toList());
        System.out.println(list2);
        // 通过断点调试会发现：stream流的方法并不是一个一个执行
        // 它是先记录每一步操作，当整个链式调用完成后，再依次执行
        // 这样做的目的是：优化循环次数。
    }
}
