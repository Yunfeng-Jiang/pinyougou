package com.pinyougou.manager.controller;

import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return new Result(true, "添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败！");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
	   return brandService.findOne(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    //必须添加@RequestBody注解，否则后台无法获取属性值，因为angular提交的是json对象
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            return new Result(false, "修改失败！");
        }
    }

    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
        } catch (Exception e) {
            return new Result(false, "删除失败！");
        }
        return new Result(true, "删除成功！");
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PageResult search(@RequestBody TbBrand tbBrand, int page, int size) {
        return brandService.findPage(tbBrand, page, size);
    }

    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }


}
