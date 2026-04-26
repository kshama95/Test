package org.bubududu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue
    int orderId;
    String orderName;
    Order(int orderId,String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }
    public int getOrderId(){
        return orderId;
    }
    public String getOrderName(){
        return orderName;
    }
    public Order() {
    }


}
