package com.bing.pojo;

import java.util.List;
import java.util.Map;

public class Employee {
    private String name;  //姓名
    private int age;  //年龄
    private Car car;  //汽车
    private List<String> hobbies;  //爱好
    private List<Double> moneys;   //收入
    private Map<String,Double> score;  //成绩

    public Map<String, Double> getScore() {
        return score;
    }

    public void setScore(Map<String, Double> score) {
        this.score = score;
    }

    public List<Double> getMoneys() {
        return moneys;
    }

    public void setMoneys(List<Double> moneys) {
        this.moneys = moneys;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayHi(){
        System.out.println("大家好！我叫"+name+"，今年"+age+"岁");
    }

    public void showCar(){
        System.out.println("我的车辆信息："+car);
    }

    public void showHobbies(){
        System.out.println("我的爱好有："+hobbies);
    }

    public void showMoney(){
        System.out.println("我的收入："+moneys);
    }

    public void showScore(){
        System.out.println("我的成绩："+score);
    }
}
