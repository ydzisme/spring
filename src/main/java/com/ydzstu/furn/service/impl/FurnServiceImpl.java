package com.ydzstu.furn.service.impl;

import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.bean.FurnExample;
import com.ydzstu.furn.dao.FurnMapper;
import com.ydzstu.furn.service.FurnService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public List<Furn> findFurnByName(String name) {
        FurnExample furnExample = new FurnExample();
        FurnExample.Criteria criteria = furnExample.createCriteria();
        if(StringUtils.hasText(name)){
            criteria.andNameLike("%"+name+"%");
        }
        return furnMapper.selectByExample(furnExample);
    }
}
