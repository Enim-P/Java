package com.bing.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

// 文件上传和下载控制器
@Controller
public class UpAndDownController {

    // 上传文件
    @ResponseBody
    @PostMapping(value = "/upload",produces = "text/json;charset=UTF-8")
    public String upload(@RequestParam CommonsMultipartFile file) throws IOException {
        File fileObj = new File("/Users/a1/Desktop/mine/带班/班级授课/KG37/05SSM/SpringMVC/mvc3/src/main/resources/file/"+file.getOriginalFilename());
        // 将从前端上传进来的文件转移给我们创建的文件
        file.transferTo(fileObj);
        System.out.println("文件上传成功！");
        return "文件上传成功！";
    }

    // 下载文件
    @ResponseBody
    @GetMapping("/download")
    public void download(HttpServletResponse response){
        response.setContentType("multipart/form-data");
        try(
                // 拿到向前端输出的输出流
                OutputStream outputStream = response.getOutputStream();
                // 根据本地的一张图片，创建一个输入流
                InputStream inputStream = new FileInputStream("/Users/a1/Desktop/mine/带班/班级授课/KG37/05SSM/SpringMVC/mvc3/src/main/resources/file/dog.jpg");
        ){
            // 将输入流复制给输出流，再由输出流向前端输出
            IOUtils.copy(inputStream,outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
