package com.zjiet.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * file上传
 * @author: linlc
 * 2017/10/25 16:55
 */

public class UploadUtil {

    public static  Boolean uploadFile(HttpServletRequest request, HttpServletResponse response) {
        // 检测是否为上传请求
        String contentType = request.getContentType();
        MultipartFile file=null;
        String filename ="";
        if (contentType != null && contentType.toLowerCase().startsWith("multipart/")) {
            MultipartHttpServletRequest multipartRequest =
                    WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            Iterator<String> it =multipartRequest.getFileNames();
            while (it.hasNext()) {
                filename= it.next();
            }
            file = multipartRequest.getFile(filename);
        }
        if(!file.isEmpty()){
            try {
                //定义输出流 将文件保存在D盘    file.getOriginalFilename()为获得文件的名字
                String path="c:\\ftpServer\\"+DateUtils.getDate("yyyyMMdd");
                File fileDir = new File(path);
                if (!fileDir.exists()) { //如果不存在 则创建
                    fileDir.mkdirs();
                    System.out.println("创建文件夹路径为："+ path);
                }
                FileOutputStream os = new FileOutputStream(path+"/"+file.getOriginalFilename());
                InputStream in = file.getInputStream();
                int b = 0;
                while((b=in.read())!=-1){ //读取文件
                    os.write(b);
                }
                os.flush(); //关闭流
                in.close();
                os.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                return  true;
            }
        }

        return false;
    }
}
