package com.ydzstu.furn.service.impl;

import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.dao.FurnMapper;
import com.ydzstu.furn.service.FurnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FurnServiceImpl implements FurnService {
    @Resource
    private FurnMapper furnMapper;
    //储存商品信息
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        return furnMapper.selectByExample(null);
    }

    @Override
    public void updateFurn(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void delFurn(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }
}
