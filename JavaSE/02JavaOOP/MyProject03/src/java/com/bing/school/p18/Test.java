package com.bing.school.p18;

public class Test {
    public static void main(String[] args) {
        Player p1 = Player.createPlayer();
        Player p2 = Player.createPlayer();
        System.out.println(p1==p2);
        System.out.println("-------------------");
        p1.run();
        p2.pause();


    }
}
