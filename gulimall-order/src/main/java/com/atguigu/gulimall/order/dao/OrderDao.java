package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author yfd
 * @email 1490253514@qq.com
 * @date 2023-01-15 14:59:43
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
