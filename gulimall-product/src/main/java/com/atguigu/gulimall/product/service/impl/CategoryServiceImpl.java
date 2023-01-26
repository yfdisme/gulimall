package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> tree() {
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        List<CategoryEntity> collect = categoryEntities.stream()
                .filter(categoryEntity ->
                        categoryEntity.getParentCid() == 0L)
                .map((menu) -> {
                    menu.setTreeList(chidMenu(menu, categoryEntities));
                    return menu;
                }).sorted((menu1, menu2) ->
                        (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort())
                ).collect(Collectors.toList());
        return collect;
    }

    public List<CategoryEntity> chidMenu(CategoryEntity menu, List<CategoryEntity> all) {
        List<CategoryEntity> collect = all.stream()
                .filter(item -> {
                    return item.getParentCid() == menu.getCatId();
                })
                .map(item -> {
                            item.setTreeList(chidMenu(item, all));
                            return item;
                        }
                ).sorted((menu1, menu2) ->
                        (menu1.getSort() == null ? 0 : menu1.getSort()) - (menu2.getSort() == null ? 0 : menu2.getSort())
                ).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteByIds(Long[] catIds) {
        List<Long> ids = Arrays.asList(catIds);
        baseMapper.deleteBatchIds(ids);
    }
}