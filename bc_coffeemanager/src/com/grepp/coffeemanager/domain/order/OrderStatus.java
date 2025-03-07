package com.grepp.coffeemanager.domain.order;

// fixme : enum으로 리펙토링
public class OrderStatus {

    public static final OrderStatus OK = new OrderStatus(0, "주문 생성 성공");
    public static final OrderStatus FAIL_SOLD_OUT = new OrderStatus(1, "재고 부족으로 주문을 취소합니다.");
    public static final OrderStatus FAIL_SEASON = new OrderStatus(2, "비시즌 입니다.");

    private int code;
    private String desc;

    private OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public boolean isOk(){
        return code == 0;
    }

    public String desc(){
        return desc;
    }
}
