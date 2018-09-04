package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrandExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Service;

/**
 * @author frankJiang
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;
	
	@Override
	public List<TbBrand> findAll() {

		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<TbBrand> brandList = brandMapper.selectByExample(null);
        PageInfo<TbBrand> pageInfo = new PageInfo(brandList);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
	}

    @Override
    public void add(TbBrand tbBrand) {
        brandMapper.insert(tbBrand);
    }

    @Override
    public TbBrand findOne(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand tbBrand) {
        brandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbBrandExample brandExample = new TbBrandExample();
        TbBrandExample.Criteria criteria = brandExample.createCriteria();
        if (tbBrand != null) {
            if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
        }
        List<TbBrand> brandList = brandMapper.selectByExample(brandExample);
        PageInfo<TbBrand> pageInfo = new PageInfo(brandList);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }

}
