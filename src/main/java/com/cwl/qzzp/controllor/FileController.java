package com.cwl.qzzp.controllor;

import com.cwl.qzzp.dto.DocumentFile;
import com.cwl.qzzp.util.FileUtil;
import com.cwl.qzzp.util.GetUUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/25
 * @description：TODO
 */
@Slf4j
@RestController
public class FileController {


    @PostMapping("document/upload")
    public String upload(@RequestParam("file") MultipartFile file, String id){
        String pathString=null;
        if(file!=null){
            pathString="D:/upload/"+ GetUUIDUtil.getUUID()+ "/"+file.getOriginalFilename();
            //将上传的文件信息写入数据库
            DocumentFile documentFile=new DocumentFile();
            documentFile.setName(file.getOriginalFilename());
            documentFile.setPath(pathString);
            documentFile.setTime(new Date());
        }
        try {
            File files = new File(pathString);
            if(!files.getParentFile().exists()){
                files.getParentFile().mkdirs();
            }
            file.transferTo(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"code\":0,\"filepath\":\""+pathString+"\"}";
    }

    @RequestMapping(value="/down", produces = {"application/text;charset=UTF-8"})
    public String down(HttpServletResponse response, String path){
        try {
            //根据文件路径下载文件信息
            FileUtil.down(response, path);
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            return "下载成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "下载失败";
    }

}
