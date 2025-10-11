package com.bing.p11;

@MyAnnotion()   //使用注解中的属性默认值
@MyAnnotion2(abc = "李四")  //给注解的abc属性赋值
public class Test {
    @MyAnnotion("张三")   //给注解的value属性赋值
    public String name;

    // 这里会报错，因为我们规定了该注解，只能在类和字段上使用
    //@MyAnnotion
    //虽然value属性是一个属性，如果只传一个值，可以直接赋值
    @MyAnnotion3("aaa")
    public void sayHi(){

    }

    //如果要传多个只，需要使用{}包裹
    @MyAnnotion3({"嘻嘻","呵呵"})
    public void sayHello(){

    }
}
