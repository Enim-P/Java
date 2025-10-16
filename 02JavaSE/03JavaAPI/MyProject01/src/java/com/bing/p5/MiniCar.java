package com.bing.p5;

/**
 * 轿车
 */
public class MiniCar extends Car {
    public MiniCar() {
    }

    public MiniCar(String no, String name, Integer price) {
        super(no, name, price);
    }

    @Override
    public Integer calcPrice(int days) {
        int total = days * this.getPrice();
        if(days>7){
            total += (days-7) * this.getPrice() * 0.1;
        }
        return total;
    }
}
