package com.cwl.qzzp.util;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author ：ChengWl
 * @date ：Created in 2021/5/31
 * @description：文件下载
 */
public class FileUtil {
    public static void down(HttpServletResponse res, String pathAddress) throws UnsupportedEncodingException {
        File file;
        file = new File(pathAddress);
        String fileName = file.getName();

        res.setHeader("content-type", "application/octet-stream");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),"iso-8859-1"));
        byte[] buff = new byte[1024];
        FileInputStream bis = null;
        OutputStream os = null;
        try {
            os = res.getOutputStream();
            bis = new FileInputStream(file);
            int readTmp = 0;
            while ((readTmp = bis.read(buff)) != -1) {
                os.write(buff, 0, readTmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
