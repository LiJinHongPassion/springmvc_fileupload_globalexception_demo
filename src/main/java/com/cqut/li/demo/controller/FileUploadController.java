package com.cqut.li.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**springmvc文件上传
 * @author Li
 * @date 2019/4/15-9:35
 */
@Controller
public class FileUploadController {


    @ResponseBody
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public List<String> handleFormUpload(@RequestParam("name") String name,
                                         @RequestParam("file") MultipartFile file) {
        List<String> result = new ArrayList<>();


//        result.add(handleFormUploadByStream(name, file));
        result.add(handleFormUploadByByte(name, file));
        return result;
    }

    /***
     * 流的方式处理
     * @param name 文件名称
     * @param file 文件
     * @return
     */
    private String handleFormUploadByStream(String name, MultipartFile file) {
        InputStream is = null;
        try {
            long begin = System.currentTimeMillis();
            //获取到文件输入流
            is = file.getInputStream();
            if(is != null){
                //利用commons-io包的工具，输出到文件;file.getOriginalFilename()获取文件名+文件类型
                FileUtils.copyInputStreamToFile(is, new File("d://stream" + file.getOriginalFilename()));
                long end = System.currentTimeMillis();

                return "stream====>uploadSuccess   time: " + (end-begin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "uploadFailure";
    }


    /***
     * 利用字节方式写入文件
     * @param name
     * @param file
     * @return
     */
    private String handleFormUploadByByte(String name, MultipartFile file) {
        //可利用nio对接收到的bytes做持久化操作
        if (!file.isEmpty()) {
            try {
                long begin = System.currentTimeMillis();

                byte[] bytes = file.getBytes();
                FileUtils.writeByteArrayToFile(new File("d://byte" + file.getOriginalFilename()), bytes);
                long end = System.currentTimeMillis();

                return "byte====>uploadSuccess   time: " + (end-begin);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "uploadFailure";
    }

}
