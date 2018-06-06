package meiHu.dao;


import meiHu.entity.Order;
import meiHu.entity.OrderItem;

import java.util.List;

public interface OrderMapper {

    //保存订单信息
    public void save(Order order);
    //保存订单信息的同时，向shop_item中插入多条信息
    public void saveItem(OrderItem oi);
    //根据用户id查询我的订单信息
    public List<Order> findMyOrders(int uid);
    //用户取消订单
    public void deleteOrderItem(int orderid);
    public void deleteOrder(int orderid);

    //用户查询已发货的订单
    public List<Order> getRunOrder(int uid);
    //用户查询已完成的订单
    public List<Order> getDoneOrder(int uid);

}