package com.dbms.article.controller;

import com.dbms.article.util.ResultInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/admin/api/upload")
public class FileController {

    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public Object uploadImg(@RequestParam(value = "file") MultipartFile file){
        ResultInfo<String> result = new ResultInfo<>();
        if(file.isEmpty()){
            result.setMessage("删除失败，文件为空！");
            result.setData(null);
            result.setStatusCode(0);
            return  result;
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;

        result.setData(fileName);
        result.setStatusCode(1);
        result.setMessage("文件上传成功！");

        return result;
    }

}
