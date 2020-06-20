package org.csu.management.persistence;

import org.csu.management.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Order getOrder(int orderId);
    List<Order> serachOrderList(String keywords);
    List<Order> getOrderList();

    void updateOrder(Order order);//更改订单
    void deleteOrder(Order order);//删除订单
}
