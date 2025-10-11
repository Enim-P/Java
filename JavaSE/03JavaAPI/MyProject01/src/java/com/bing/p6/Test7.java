package com.bing.p6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            this.add("A,B");
            this.add("C,D");
            this.add("E,F");
        }};
        System.out.println(list);
        list = list.stream()
                .flatMap(e -> Arrays.stream(e.split(",")))  //分隔字符串并生成新的流，在合并成一个总流
                        .collect(Collectors.toList());
        System.out.println(list);
    }
}
