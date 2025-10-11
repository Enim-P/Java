package com.bing.school.p17;

/**
 * 工厂类
 */
public class Factory {
    // 工厂生产手机的方法
    public static Phone createPhone(String name,String color,String size,String brand){
        Phone phone = null;
        switch (brand){
            case "苹果":
                phone = new IPhone(name,color,size);
                break;
            case "小米":
                phone = new Xiaomi(name,color,size);
                break;
            case "诺基亚":
                phone = new Nokia(name,color,size);
                break;
        }
        return phone;
    }

    // 这个就是多态的第二种方式：父类类型作为返回类型，在方法创建的是具体的实现类型，统一以父类形式返回。
    // 这种写法，在设计模式中又称为：简单工厂设计模式
}
