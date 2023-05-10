package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.Orders;
import com.example.mpdemo.entity.User;
//import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

    @Select("select * from orders where uid = #{uid}")
    List<Orders> selectByUid(int uid);

//  查询所有的订单，同时查询订单的用户
    @Select("select * from orders")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user",javaType = User.class,
                one=@One(select = "com.example.mpdemo.mapper.UserMapper.selectById")
            )
    })
    List<Orders> selectAllOrdersAndUser();
}
