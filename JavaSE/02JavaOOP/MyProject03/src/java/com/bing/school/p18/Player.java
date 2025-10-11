package com.bing.school.p18;

/**
 * 播放器类
 */
// 在程序中可以会在各个页面中创建播放器对象，而每次创建的又必须是同一个对象，这个时候就可以采用单例模式设计
public class Player {
    // 是否正在播放
    private boolean isPlaying;

    // 第一步：定义一个静态的自己
    private static Player player=null;
    // 第二步：构造方法私有化
    private Player(){}
    // 第三步：定义一个静态方法，在静态方法中实例自己，并返回自己
    public static Player createPlayer(){
        // 注意：必须要判断自己是不是为null，为null再创建，不为null直接返回
        if(player==null){
            System.out.println("初始化播放器对象.....");
            player = new Player();
        }
        return player;
    }


    // 播放
    public void run(){
        if(isPlaying){
            System.out.println("播放器正在播放...");
        }else{
            isPlaying = true;
            System.out.println("开始播放音乐...");
        }
    }

    // 暂停
    public void pause(){
        if(isPlaying){
            isPlaying = false;
            System.out.println("停止播放音乐...");
        }else{
            System.out.println("播放器已经暂停...");
        }
    }
}
