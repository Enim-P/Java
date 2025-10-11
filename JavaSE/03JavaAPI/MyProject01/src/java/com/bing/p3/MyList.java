package com.bing.p3;

/**
 * 集合类
 * @param <T> 集合类型
 */
public class MyList<T> {
    // 集合的长度
    private int length = 5;
    // 数组
    private Object[] list;

    public MyList(){
        this.list = new Object[this.length];
    }
    public MyList(int length){
        this.length = length;
        this.list = new Object[this.length];
    }

    // 向集合中添加数据
    public void add(T t){
        for (int i = 0; i < list.length; i++) {
            if(list[i]==null){
                list[i] = t;
                break;
            }
        }
    }

    // 根据下标获取集合中指定的数据
    public T get(int index){
        return (T)list[index];
    }
}
