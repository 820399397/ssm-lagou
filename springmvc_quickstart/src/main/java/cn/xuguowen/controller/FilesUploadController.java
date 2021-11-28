package cn.xuguowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author 徐国文
 * @create 2021-10-22 22:41
 */
@Controller
public class FilesUploadController {
    /**
     * 多文件上传：文件上传解析器解析多个文件，将后将这多个文件对象封装为MultipartFile[]数组对象
     * @param username
     * @param filePic
     * @return
     */
    @RequestMapping("/filesUpload")
    public String filesUplodad(String username, MultipartFile[] filePic) {
        System.out.println(username);

        // 遍历数组。获取到每个文件对象，单独操作
        for (MultipartFile multipartFile : filePic) {
            try {
                // 获取原始的文件名称
                String originalFilename = multipartFile.getOriginalFilename();
                // 将文件上传到本地磁盘中
                multipartFile.transferTo(new File("D:/尚硅谷 2021/" + originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
