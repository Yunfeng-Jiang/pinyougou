package com.pinyougou.manager.controller;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
 		return brandService.findAll();
	}

    @RequestMapping("/findPage")
    public PageResult findPage(int page, int size) {
         return brandService.findPage(page, size);
    }


}
