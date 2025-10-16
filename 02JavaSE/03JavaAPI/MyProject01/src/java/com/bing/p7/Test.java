package com.bing.p7;

public class Test {
    public static void main(String[] args) {
        /*
            有一家宠物商店，里面有各种各样的宠物，
            用户要注册成为这家宠物商店的会员，然后就可以在这家宠物商店里面领养宠物
            一个用户可以领养多只宠物，如果不想要了，还可以退化给商店
            领域回去的宠物，用户还要照顾它的饮食，还要陪它玩耍
        */
        PetShop petShop = new PetShop();
        petShop.systemMenu();
    }
}
