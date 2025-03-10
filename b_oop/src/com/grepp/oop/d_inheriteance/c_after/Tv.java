package com.grepp.oop.d_inheriteance.c_after;

// Device 클래스를 상속 받는다.
public class Tv extends Device{

    private int size;
    
    // super() : 부모 클래스의 생성자, 생성자의 첫 줄에서 위치
    // super : 부모 클래스의 인스턴스를 참조하는 변수
    public Tv(String brand, String name, int price, int size) {
        super(brand, name, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Tv{" +
            "size=" + size +
            ", brand='" + super.brand + '\'' +
            ", name='" + super.name + '\'' +
            ", price=" + super.price +
            '}';
    }
}
