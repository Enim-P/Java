package com.bing.p7;

import com.bing.p7.proj.Cat;
import com.bing.p7.proj.Dog;
import com.bing.p7.proj.Pet;

import java.util.*;

/**
 * 宠物商店
 */
public class PetShop {
    Scanner input = new Scanner(System.in);
    // 宠物商量的宠物集合
    private List<Pet> pets = new ArrayList<>();
    // 宠物商店的注册会员
    private Map<String,Master> masters = new HashMap<>();
    // 当前登录会员
    private Master currentMaster = null;

    public PetShop(){
        // 初始化两个集合中的数据
        Pet pet1 = new Dog("琪琪","雌性",3);
        Pet pet2 = new Dog("丽丽","雄性",4);
        Pet pet3 = new Dog("旺财","雌性",2);
        Pet pet4 = new Cat("小白","雌性",4);
        Pet pet5 = new Cat("小蓝","雄性",5);
        Pet pet6 = new Cat("小花","雄性",6);
        pets.add(pet1);
        pets.add(pet2);
        pets.add(pet3);
        pets.add(pet4);
        pets.add(pet5);
        pets.add(pet6);
        Master master1 = new Master("test1","123456","王杰");
        Master master2 = new Master("test2","123456","张杰");
        masters.put(master1.getLoginId(),master1);
        masters.put(master2.getLoginId(),master2);
    }

    // 获取我的宠物
    public Pet getMyPet(){
        System.out.print("请输入宠物的名称：");
        String name = input.next();
        // 根据名称查找宠物
        Pet pet = currentMaster.pets.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        return pet;
    }

    // 我的菜单
    public void myMenu(){
        System.out.println("***************我的菜单****************");
        System.out.println("1.查看我的宠物");
        System.out.println("2.选择宠物独白");
        System.out.println("3.选择宠物喂食");
        System.out.println("4.选择宠物玩耍");
        System.out.println("0.退出");
        System.out.println("*************************************");
        System.out.print("请选择：");
        int no = input.nextInt();
        if(no==1){
            System.out.println("名称\t性别\t年龄\t类型");
            currentMaster.pets.forEach(pet -> {
                System.out.println(pet.getName()+"\t"+pet.getSex()+"\t"+pet.getAge()+"\t"+
                        ((pet instanceof Cat) ? "猫咪" : "狗狗"));
            });
        }else if(no==2){
            Pet pet = getMyPet();   //调用获取我的宠物的方法
            if(pet!=null){
                pet.sayHi();  //调用宠物的独白方法
            }else{
                System.out.println("抱歉！你没有这只宠物！！！");
            }
        }else if(no==3){
            Pet pet = getMyPet();   //调用获取我的宠物的方法
            if(pet!=null){
               pet.eat();  //调用宠物的喂食方法
            }else{
                System.out.println("抱歉！你没有这只宠物！！！");
            }
        }else if(no==4){
            Pet pet = getMyPet();   //调用获取我的宠物的方法
            if(pet!=null){
                pet.play();  //调用宠物的玩耍的方法
            }else{
                System.out.println("抱歉！你没有这只宠物！！！");
            }
        }else{
            System.out.println("成功退出！");
            return;
        }
        myMenu();   //递归调用
    }

    // 业务菜单
    public void workMenu(){
        System.out.println("***************业务菜单****************");
        System.out.println("1.领养宠物");
        System.out.println("2.查看我的宠物");
        System.out.println("3.归还宠物");
        System.out.println("0.退出");
        System.out.println("*************************************");
        System.out.print("请选择：");
        int no = input.nextInt();
        if(no==1){
            System.out.println("名称\t性别\t年龄\t类型");
            pets.forEach(pet -> {
                System.out.println(pet.getName()+"\t"+pet.getSex()+"\t"+pet.getAge()+"\t"+
                        ((pet instanceof Cat) ? "猫咪" : "狗狗"));
            });
            System.out.print("请输入你要领养的宠物名称：");
            String name = input.next();
            // 根据名称查找宠物
            Pet pet = pets.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
            if(pet!=null){
                // 将宠物添加到主人集合
                pet.setMaster(currentMaster.getName());   //设置宠物主人的姓名
                currentMaster.pets.add(pet);    //将宠物添加到主人的宠物集合中
                pets.remove(pet);  //从宠物商店中移除该宠物信息
                System.out.println("成功领养！！！！");
            }else{
                System.out.println("你要领养的宠物不存在！");
            }
        }else if(no==2){
            myMenu();  // 调用我的菜单
        }else if(no==3){
            System.out.println("名称\t性别\t年龄\t类型");
            currentMaster.pets.forEach(pet -> {
                System.out.println(pet.getName()+"\t"+pet.getSex()+"\t"+pet.getAge()+"\t"+
                        ((pet instanceof Cat) ? "猫咪" : "狗狗"));
            });
            System.out.print("请输入你要归还的宠物名称：");
            String name = input.next();
            // 根据名称查找宠物
            Pet pet = currentMaster.pets.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
            if(pet!=null){
                pet.setMaster("");  //将宠物的主人信息擦除
                pets.add(pet);   //将宠物信息添加回宠物商店的宠物集合中
                currentMaster.pets.remove(pet);  //从主人的宠物集合中移除该宠物
                System.out.println("成功归还！！！！");
            }else{
                System.out.println("你要归还的宠物不存在！");
            }
        }else{
            System.out.println("成功退出！");
            return;
        }
        workMenu();  //递归调用
    }

    // 系统菜单
    public void systemMenu(){
        System.out.println("***************系统菜单****************");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("0.退出");
        System.out.println("*************************************");
        System.out.print("请选择：");
        int no = input.nextInt();
        if(no==1){
            System.out.print("请输入账号：");
            String loginId = input.next();
            System.out.print("请输入密码：");
            String loginPwd = input.next();
            Master m = masters.get(loginId);
            if(m!=null){
                if(m.getLoginPwd().equals(loginPwd)){
                    System.out.println("登录成功！");
                    currentMaster = m;
                    // 跳转到业务菜单
                    workMenu();
                }else{
                    System.out.println("密码错误！登录失败！");
                }
            }else{
                System.out.println("账号错误！登录失败！");
            }
        }else if(no==2){
            System.out.print("请输入账号：");
            String loginId = input.next();
            if(masters.containsKey(loginId)){
                System.out.println("账号已经存储！注册失败！");
                systemMenu();
                return;
            }
            System.out.print("请输入密码：");
            String loginPwd = input.next();
            System.out.print("请输入姓名：");
            String name = input.next();
            Master master = new Master(loginId,loginPwd,name);
            masters.put(loginId,master);
            System.out.println("注册成功！");
        }else{
            System.out.println("成功退出系统！");
            return;
        }
        systemMenu();   //采用递归调用
    }

}
