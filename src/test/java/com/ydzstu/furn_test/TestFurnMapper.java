package com.ydzstu.furn_test;

import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.dao.FurnMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class TestFurnMapper {
    @Test
    public void testInsertSelective(){
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn();
        furn.setName("梳子");
        furn.setPrice(BigDecimal.valueOf(2.00));
        furn.setMaker("样式家具");
        furn.setStock(20);
        furn.setSales(10);
        furn.setImgPath("assets/images/product-image/2.jpg");
        int i = furnMapper.insertSelective(furn);
        System.out.println(i);
    }
}
