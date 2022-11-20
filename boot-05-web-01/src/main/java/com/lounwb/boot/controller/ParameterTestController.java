package com.lounwb.boot.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {

    @RequestMapping("/car/{id}/user/{username}")
    public Map<String, Object> getCar(@PathVariable Integer id,
                                      @PathVariable String username
                                      ){

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);

    //    map.put("multiMap", multiMap);
    //    map.put("userAgent", userAgent);

        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content){

        Map<String, Object> map = new HashMap<>();

        map.put("content", content);
        System.out.println(URLDecoder.decode(content));
        return map;

    }
}
