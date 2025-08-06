package com.ydzstu.furn.controller;

import com.ydzstu.furn.bean.Furn;
import com.ydzstu.furn.bean.MSG;
import com.ydzstu.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class FurnController {
    @Resource
    private FurnService furnService;
    @PostMapping("/save")
    @ResponseBody
    public MSG save(@RequestBody Furn furn){
        furnService.save(furn);
        //返回成功
        MSG success = MSG.success();
        return success;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public MSG findAll(){
        List<Furn> furns = furnService.findAll();
        MSG success = MSG.success();
        success.addBackInfo("furns",furns);
        return success;
    }
    @PostMapping("/update")
    @ResponseBody
    public MSG updateFurn(@RequestBody Furn furn){
        furnService.updateFurn(furn);
        MSG success = MSG.success();
        return success;
    }
    @PostMapping("/delete")
    @ResponseBody
    public MSG delFurn(@RequestBody Map<String,Object> request){
        Integer id = (Integer)request.get("id");
        furnService.delFurn(id);
        MSG success = MSG.success();
        return success;
    }
}
