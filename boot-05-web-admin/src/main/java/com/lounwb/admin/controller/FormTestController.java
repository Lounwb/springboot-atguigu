package com.lounwb.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("profile") MultipartFile profile,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息:email={},username={},profile={},photos={}"
                ,email,username,profile.getSize(),photos.length);
        if (!profile.isEmpty()) {

            String originalFilename = profile.getOriginalFilename();
            profile.transferTo(new File("E:\\cache\\"+originalFilename));

        }
        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\" + originalFilename));
                }
            }
        }
        return "redirect:/main.html";
    }
}
