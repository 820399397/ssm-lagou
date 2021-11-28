package cn.xuguowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


/**
 * @author 徐国文
 * @create 2021-10-22 21:46
 */
@Controller
public class FileUploadController {
    /**
     * 实现单文件上传
     * 需要注意的是：表单中name的值一定要和controller中的业务方法的形参名称相同，这样框架才会帮助我们完成封装
     * @param username
     * @param filePic 就是通过文件上传解析器解析之后的文件对象
     * @return
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile filePic) {
        System.out.println("名称：" + username);
        // System.out.println(filePic);
        try {
            // 获取文件的原始名称来充当上传后的文件名称
            String originalFilename = filePic.getOriginalFilename();
            // 1.实现文件的上传
            filePic.transferTo(new File("D:/尚硅谷 2021/" + originalFilename));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 文件上传成功 跳转到success.jsp页面上，视图解析器会为逻辑视图拼接上前缀和后缀的
        return "success";
    }
}
