package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;

import java.util.List;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {
    /**
     * 查询品牌集合
     * @return
     */
    List<TbBrand> findAll();

    /**
     * 分页
     * @param pageNum 当前第几页
     * @param pageSize 每页记录数
     * @return
     */
    PageResult findPage(int pageNum, int pageSize);

    /**
     * 新增商户
     * @param tbBrand
     */
    void add(TbBrand tbBrand);

    /**
     * 根据ID查询实体类
     * @param id
     * @return
     */
    TbBrand findOne(Long id);

    /**
     * 修改实体类
     * @param tbBrand
     */
    void update(TbBrand tbBrand);

    /**
     * 根据ID删除对象
     * @param ids
     */
    void delete(Long[] ids);

}
