package com.ydzstu.furn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.bean.MSG;
import com.ydzstu.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class FurnController {
    @Resource
    private FurnService furnService;
    // 保存数据
    @PostMapping("/save")
    @ResponseBody
    public MSG save(@RequestBody Furn furn){
        furnService.save(furn);
        //返回成功
        MSG success = MSG.success();
        return success;
    }
    // 查询全部数据
    @RequestMapping("/findAll")
    @ResponseBody
    public MSG findAll(){
        List<Furn> furns = furnService.findAll();
        MSG success = MSG.success();
        success.addBackInfo("furns",furns);
        return success;
    }
    // 修改
    @PostMapping("/update")
    @ResponseBody
    public MSG updateFurn(@RequestBody Furn furn){
        furnService.updateFurn(furn);
        MSG success = MSG.success();
        return success;
    }
    //删除
    @PostMapping("/delete")
    @ResponseBody
    public MSG delFurn(@RequestBody Map<String,Object> request){
        Integer id = (Integer)request.get("id");
        furnService.delFurn(id);
        MSG success = MSG.success();
        return success;
    }
    // 分页
    @RequestMapping("/findAllByPage")
    @ResponseBody
    public MSG findAllByPage
    (@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        // 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> furns = furnService.findAll();
        PageInfo pageInfo = new PageInfo(furns,pageSize);
        MSG msg = MSG.success().addBackInfo("pageInfo", pageInfo);
        return msg;
    }
    @GetMapping("/findFurnsByName")
    @ResponseBody
    public MSG findFurnsByName(@RequestParam(defaultValue = "") String name,
                               @RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "5") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Furn> furns = furnService.findFurnByName(name);
        PageInfo pageInfo = new PageInfo(furns, pageSize);
        return MSG.success().addBackInfo("pageInfo",pageInfo);
    }
}
