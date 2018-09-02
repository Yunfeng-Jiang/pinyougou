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

	
}
