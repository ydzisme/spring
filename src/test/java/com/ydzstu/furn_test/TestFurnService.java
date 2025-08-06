package com.ydzstu.furn_test;

import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class TestFurnService {
    private FurnService furnService;
    @Before
    public void init(){
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        furnService = ioc.getBean(FurnService.class);
    }
    @Test
    public void TestFindAll(){
        List<Furn> furns = furnService.findAll();
        for (Furn furn:furns){
            System.out.println(furn);
        }
    }
    @Test
    public void TestUpdateFurn(){
        Furn furn = new Furn
                (1,"带灯光的梳妆镜","样式家具",BigDecimal.valueOf(200),20,10,"assets/images/product-image/1.jpg");
        furnService.updateFurn(furn);
    }
    @Test
    public void TestDelFurn(){
        Integer id = 5;
        furnService.delFurn(id);
    }
}
