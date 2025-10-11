package com.bing.p6;

import java.util.*;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        // 每隔3秒钟生成一组双色球的中间号码
        // 前6组号码是0-32之间不重复的随机数，第7组号码是0-16之间的随机数
        List<Integer> nums = new ArrayList<>();
        System.out.println("开始生成本期中间号码...");
        System.out.println("前六组号码是：");
        for (int i=1;i<=6;i++){
            new TimerTask(()->{
                while (true){
                    // 生成0-32之间的随机数
                    int num = random.nextInt(33);
                    // 判断随机数不能在集合中出现过
                    if(nums.stream().filter(r->r.intValue()==num).collect(Collectors.toList()).size()==0){
                        System.out.println(num);
                        nums.add(num);  //添加到集合中
                        nums.sort((a,b)->a-b);   //升序排列
                        break;
                    }
                }
            },i*2000).start();
        }

        new TimerTask(()->{
            System.out.println("第七组号码是：");
            int num = random.nextInt(17);
            System.out.println(num);
            nums.add(num);
            try {
                Thread.sleep(1000);
                System.out.println("本期双色球中奖号码为："+nums);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },7*2000).start();

    }

    // 定义一个定时器类（指定是时间后执行）
    static class TimerTask{
        // 线程对象（工作线程）
        Runnable task;
        // 定时时间
        long time;

        // 通过构造方法，给定时器的两个成员赋值
        public TimerTask(Runnable runnable,long time){
            this.task = runnable;
            this.time = time;
        }

        // 开启定时器的方法
        public void start(){
            // 创建一个线程
            new Thread(()->{
                try {
                    Thread.sleep(time);  //休眠指定的时间
                    task.run();          // 再运行我们的工作线程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
