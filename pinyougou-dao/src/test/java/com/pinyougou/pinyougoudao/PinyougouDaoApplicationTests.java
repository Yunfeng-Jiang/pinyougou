package com.pinyougou.pinyougoudao;

import com.pinyougou.mapper.MybatisSpringApplication;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisSpringApplication.class)
public class PinyougouDaoApplicationTests {

    @Autowired
    private TbBrandMapper brandMapper;


    @Test
    public void contextLoads() {
        List<TbBrand> list = brandMapper.selectByExample(null);
        System.out.println(list);
    }

}
