package com.atguigu.gulimall.coupn.dao;

import com.atguigu.gulimall.coupn.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author yfd
 * @email 1490253514@qq.com
 * @date 2023-01-15 14:25:03
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
