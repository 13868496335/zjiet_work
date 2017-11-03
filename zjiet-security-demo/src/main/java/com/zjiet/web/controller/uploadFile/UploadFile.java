package com.zjiet.web.controller.uploadFile;

import com.zjiet.VO.ResultVO;
import com.zjiet.dto.FileInfoDTO;
import com.zjiet.utils.DateUtils;
import com.zjiet.utils.ResultVOUtil;
import com.zjiet.utils.UploadUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件上传————控制器
 * @author: Double
 * 2017/10/25 17:35
 */
@RestController
@RequestMapping("/file")
public class UploadFile {


    String path = "D:\\boot\\test\\zjiet-security\\zjiet-security-demo\\src\\main\\java\\com\\zjiet\\web\\controller\\uploadFile";
    String actualPath = "D:\\boot\\test\\zjiet-security\\zjiet-security-demo\\src\\main\\java\\com\\zjiet\\web\\controller";


    /**
     * 上传到  aliyun/远程服务器
     * @param request
     * @param response
     * @return
     */
    public ResultVO  uploadFile(HttpServletRequest request, HttpServletResponse response){

        Boolean bool = UploadUtil.uploadFile(request,response);

        if(bool)
           return ResultVOUtil.SUCCESS(null,"上传成功!");
        else
           return ResultVOUtil.Error("上传失败!","400");
    }


    /**
     * 文件上传、下载到本地的  (将需要上传的文件，指定路径、上传名称)
     * @param file
     * @return
     * @throws Exception
     */

    @PostMapping
    public FileInfoDTO upload(MultipartFile file) throws Exception {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        File localFile = new File(path, DateUtils.formatDate(new Date(),"yyyyMMdd").concat(RandomStringUtils.randomNumeric(4)) + ".txt");

        file.transferTo(localFile);

        return new FileInfoDTO(localFile.getAbsolutePath());
    }



    /**
     * 设定response的头信息，为下载.  指定下载后的文件名    （将输出流里面的内容 copy 到输入流  ）
     * @param id
     * @param request
     * @param response
     * @throws Exception
     */

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        try (
              InputStream inputStream = new FileInputStream(new File(actualPath, id + ".txt"));
             OutputStream outputStream = response.getOutputStream();
             ) {

            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            //将输出流里面的东西  copy到  输入流
            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }

}
