package cn.xuguowen.controller;

import cn.xuguowen.pojo.Course;
import cn.xuguowen.pojo.CourseVO;
import cn.xuguowen.pojo.ResponseResult;
import cn.xuguowen.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 徐国文
 * @create 2021-10-31 16:35
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByCondition(@RequestBody CourseVO courseVO) {
        List<Course> courseList = courseService.findCourseByCondition(courseVO);

        // 根据接口文档的要求：按照接口文档中的规定响应数据：json数据
        // 我可以将返回的数据封装到一个对象中，然后通过@ResponseBody注解将对象转换为json格式的数据
        ResponseResult responseResult = new ResponseResult(true,200,"响应成功",courseList);
        return responseResult;
    }

    /**
     * 新建课程信息中的图片上传：
     * 1.要完成图片的上传，图片上传到tomcat服务器上，用户可以通过网络访问的
     * 2.图片还要进行回显，也就是访问图片的地址，然后显示到页面上（所以要将图片的信息响应到前台）
     *
     * 需要注意的点是:MultipartFile file 形参的名字必须和表单中的文件上传表单项的name值一样
     * 如果不一样可以使用@RequestParam注解来解决
     * 这个注解的name属性值必须和表单中的文件上传表单项的name值一样，这样就可以将文件信息封装到file形参对象中
     *
     * 3.注意：测试成功后，无法通过响应到前端页面的文件路径访问到文件， http://localhost:8080/upload/1635677479024.png
     *          那是因为你没有把upload这个项目部署到tomcat上，所以无法访问
     * @param file
     * @return
     */
    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam(name = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        // 1.先判断下这个file对象是否为空，如果为空，说明没有获取到上传文件的信息
        if (file.isEmpty()) {
            throw new RuntimeException();
        }
        // 2.获取项目的真实路径 D:\java\apache-tomcat-8.5.31-windows-64位\apache-tomcat-8.5.31\webapps\ssm_web
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("该项目的真实路径是：" + realPath);
        // 我想在tomcat中webapps目录下新建一个upload文件夹，这个文件夹中存储的是客户上传的文件
        // D:\java\apache-tomcat-8.5.31-windows-64位\apache-tomcat-8.5.31\webapps\
        String webapps = realPath.substring(0, realPath.indexOf("ssm_web"));
        System.out.println("webapps所在的目录是：" + webapps);

        // 3.获取该文件的名称，给他一个新的名称
        String originalFilename = file.getOriginalFilename();   // 文件的初始名称
        System.out.println("文件的初始名称：" + originalFilename);
        System.out.println("文件的后缀名是：" + originalFilename.substring(originalFilename.lastIndexOf(".")));
        // 4.通过时间戳的方式拼接一个新的文件名称，目的就是为了避免文件的名称重复
        long time = System.currentTimeMillis();
        System.out.println("获取到的时间戳是：" + time);
        String newFileName = time + originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println("文件的 新名称是：" + newFileName);

        // 5.我上面获取到了webapps目录，然后通过字符串的拼接使得创建一个upload的目录
        String uploadPath = webapps + "upload\\";

        // 6.通过文件对象创建拼接出来的目录
        // uploadPath 表示文件要上传的位置
        // newFileName 表示文件的名称
        File filePath = new File(uploadPath, newFileName);
        File parentFile = filePath.getParentFile();
        System.out.println("文件上传的父目录位置：" + parentFile);
        // 7.判断该文件的父目录是否存在，如果不存在则要创建。
        if (!filePath.getParentFile().exists()) {
            // 这里需要注意的是：我们需要创建多级目录，因为父目录就是一个多级目录
            // D:/java/apache-tomcat-8.5.31-windows-64位/apache-tomcat-8.5.31/webapps/upload
            if (filePath.getParentFile().mkdirs()) {
                System.out.println("创建成功！");
            } else {
                System.out.println("创建失败！");
            }
        }

        // 8.完成图片的上传
        file.transferTo(filePath);

        // 9.将文件的信息保存到map集合中
        HashMap<String, String> map = new HashMap<>();
        map.put("fileName",newFileName);
        // 要通过网页的形式访问该图片

        map.put("filePath","http://localhost:8080/upload/" + newFileName);

        // 10.封装数据，响应结果
        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);

        return result;
    }

    /**
     * 新建课程的操作
     * 注意：前端表单页面传递的是json数据，所以需要借助 @RequestBody注解 将json字符串转换为courseVO对象
     * 更新课程操作 ：这个操作会把id传递过来，所以可以根据id是否为空，来区别是新增还是更新操作
     * @param courseVO
     * @return
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {

        if (courseVO.getId() == null) {
            // 说明是新增操作

            // 1.调用service完成保存课程信息
            courseService.saveCourseOrTeacher(courseVO);
            // 2.响应json格式的数据
            ResponseResult responseResult = new ResponseResult(true, 200, "新增课程成功", null);
            return responseResult;
        } else {
            // 说明是修改操作

            // 1.调用service完成g更新课程信息
            courseService.updateCourseOrTeacher(courseVO);
            // 2.响应json格式的数据
            ResponseResult responseResult = new ResponseResult(true, 200, "更新课程成功", null);
            return responseResult;
        }
    }

    /**
     * 修改课程信息只回显课程信息和讲师信息
     * @param id
     * @return
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id) {
        CourseVO courseVO = courseService.findCourseById(id);

        ResponseResult responseResult = new ResponseResult(true,200,"根据课程id查询课程信息成功！",courseVO);

        return responseResult;
    }

    /**
     * 根据课程id和课程状态完成修改课程状态功能
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status) {

        courseService.updateCourseStatus(id,status);

        // 1.按照接口文档中的响应示例格式进行响应
        Map<String,Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult(true,200,"响应成功！",map);
        return responseResult;
    }
}
