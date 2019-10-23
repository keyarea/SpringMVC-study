package net.qipo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    /**
     * 多文件上传
     * @param username
     * @param file
     * @param modelMap
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam(value = "username",required = false) String username, @RequestParam("headerimg") MultipartFile[] files, ModelMap modelMap)  {
        System.out.println("上传的文件信息");
        for (MultipartFile file: files) {
            if (!file.isEmpty()){
                try {
                    file.transferTo(new File("E:\\"+ file.getOriginalFilename()));
                    modelMap.addAttribute("msg", "文件上传成功了");
                } catch (Exception e) {
                    modelMap.addAttribute("msg", "文件上传失败了" + e.getMessage());
                }
            }
        }

        return "forward:/index.jsp";
    }

    /**
     * 单文件上传
     */
//    @RequestMapping("/upload")
//    public String upload(@RequestParam(value = "username",required = false) String username, @RequestParam("headerimg") MultipartFile file, ModelMap modelMap)  {
//        System.out.println("上传的文件信息");
//        System.out.println("文件项的name:" + file.getOriginalFilename());
//        System.out.println("文件的名字:" + file.getName());
//
//        //文件保存
//        try {
//            file.transferTo(new File("E:\\"+ file.getOriginalFilename()));
//            modelMap.addAttribute("msg", "文件上传成功了");
//        } catch (Exception e) {
//            modelMap.addAttribute("msg", "文件上传失败了" + e.getMessage());
//        }
//
//        return "forward:/index.jsp";
//    }
}
