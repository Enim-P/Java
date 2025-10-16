package com.bing.school.p12;

/**
 * 客车
 */
public class Bus extends Car {
    //座位数量
    private int seatNum;
    public Bus() {
    }

    public Bus(String no, String name, String color, double rent,boolean status, int seatNum) {
        super(no, name, color, rent,status);
        this.seatNum = seatNum;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    // 客车重写计算总租金的方法
    @Override
    public double calcPrice() {
        // 租用天数在7天以内，按照日租金计算总价，超过7天的部分，每天每个座位加收1%的日租金
        double total = this.getRent() * this.getDays();
        if(this.getDays()>7){
            int d = this.getDays()-7;
            total += this.getRent()*0.01*d*this.getSeatNum();
        }
        return total;
    }
}
