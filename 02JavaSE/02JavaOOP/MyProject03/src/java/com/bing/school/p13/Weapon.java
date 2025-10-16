package com.bing.school.p13;

/**
 * 武器接口
 */
//定义的类的关键字是class，定义接口的关键字是interface
public interface Weapon {
    //通常情况下，我们在接口中只自定义公共的抽象方法，public abstract可以省略

    //定义一个机枪方法
    void gun();

    //从jdk8以后，在接口中可定义默认实现方法
    default void defaultFun(){
        System.out.println("接口的默认实现方法....");
    }

    //在接口中也可以定义公共的静态的final属性，public static final可以省略
    String type = "V2.0";

    // 总结：通常情况下，我们定义接口，都是只定义抽象方法，定义该接口具备哪些抽象行为（也叫能力），再由具体的实现类去实习该接口
}
