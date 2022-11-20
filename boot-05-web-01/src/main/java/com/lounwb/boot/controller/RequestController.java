package com.lounwb.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @RequestMapping("/goto")
    public String goToPage(HttpServletRequest request){

        request.setAttribute("msg", "success......");
        return "forward:/success";

    }

    @ResponseBody
    @RequestMapping("/success")
    public String success(@RequestAttribute("msg") String msg){
        return msg;
    }

    @ResponseBody
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;
    }

    @ResponseBody
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(name = "age", pathVar = "empId") Integer empAge,
                    @PathVariable("bossId") Integer bossId,
                    @PathVariable("empId") Integer empId){
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        map.put("bossId", bossId);
        map.put("empId", empId);
        return map;
    }
}
