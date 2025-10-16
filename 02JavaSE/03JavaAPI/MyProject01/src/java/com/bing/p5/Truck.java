package com.bing.p5;

/**
 * 卡车
 */
public class Truck extends Car {
    public Truck() {
    }

    public Truck(String no, String name, Integer price, int load) {
        super(no, name, price);
        this.load = load;
    }

    // 载重
    private int load;

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public Integer calcPrice(int days) {
        int total = days * this.getPrice();
        if(days>7){
            total += (days-7) * this.getPrice() * this.getLoad() * 0.01;
        }
        return total;
    }
}
