package com.zjiet.dto;

import lombok.Data;

/**
 * 交互的  文件
 * @author: Double
 * 2017/10/26 13:39
 */

@Data
public class FileInfoDTO {

    private  String  path;

    public  FileInfoDTO(String path){
        this.path = path;
    }
}
