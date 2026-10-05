package oom;

import java.util.Collections;

public enum OrderStatus {
    PENDING(1, "待处理"),
    PAID(2, "已支付"),
    SHIPPED(3, "已发货"),
    DELIVERED(4, "已送达"),
    CANCELLED(5, "已取消");   // 注意：常量列表最后一个要用分号结束

    private final int code;
    private final String description;


    private OrderStatus(int code,String description){
        this.code=code;
        this.description=description;
    }


}
