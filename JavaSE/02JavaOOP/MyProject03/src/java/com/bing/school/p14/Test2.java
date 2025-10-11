package com.bing.school.p14;

public class Test2 {
    public static void main(String[] args) {
        Person p = new Person();
        p.eat();
        // 以前我们要实现接口，只能先定义一个类，让类实现接口的行为
        // 再创建这个类对象，通过类的对象，执行执行的接口方法
        System.out.println("---------------------");
        // 现在我们可以通过匿名内部类来实现
        Eat eat = new Eat(){
            @Override
            public void eat() {
                System.out.println("要吃东西了...");
            }
        };
        eat.eat();
        // 我们只是要实现一个接口的方法，每次都要先定义一个实现类，它麻烦了，可以使用匿名内部类来简化
        System.out.println("---------------------");
        // 从jdk8开始，又推出了lambda表达式，对匿名内部类进行简化
        // 可以将整个lambda表达式当成一个方法，用这个方法去重写接口中的抽象方法
        Eat eat2 = ()->{
            System.out.println("吃好吃的....");
        };
        eat2.eat();
        System.out.println("--------------------------------------");
        // 抽象类也可以使用匿名内部类在实现
        // lambda表达式只能实现接口，并且接口中只能有一个抽象方法，如果接口中不止一个方法，其他方法必须要有默认实现
        Car car = new Car() {
            @Override
            public void run() {
                System.out.println("汽车在行驶...");
            }

            @Override
            public void stop() {
                System.out.println("汽车停下了...");
            }
        };
        car.run();
        car.stop();
        System.out.println("--------------------------------------");
        // 这里的接口有两个抽象方法，所以，也不能改成lambda表达式来简化匿名内部类的写法
        Sleep sleep1 = new Sleep() {
            @Override
            public void sdSleep() {
                System.out.println("深度睡眠8小时");
            }

            @Override
            public void qdSleep() {
                System.out.println("浅度睡眠8小时");
            }
        };
        sleep1.sdSleep();
        sleep1.qdSleep();
    }
}
