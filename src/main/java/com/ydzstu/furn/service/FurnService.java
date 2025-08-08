package com.ydzstu.furn.service;

import com.ydzstu.furn.bean.Furn;

import java.util.List;

public interface FurnService {
    //添加家具信息
    public void save(Furn furn);
    //取出全部的家具信息，以便页面展示
    public List<Furn> findAll();
    //修改家具信息
    public void updateFurn(Furn furn);
    //删除家具信息
    public void delFurn(Integer id);
    // 通过名字模糊查询家具信息
    public List<Furn> findFurnByName(String name);
}
