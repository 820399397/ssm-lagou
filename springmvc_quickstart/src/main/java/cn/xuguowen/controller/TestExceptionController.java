package cn.xuguowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 徐国文
 * @create 2021-10-23 11:45
 * 测试自定义异常类
 */
@Controller
public class TestExceptionController {
    /**
     * 如果没有编写实现HanderExceptionResolver接口的实现类，那就会使用mvc框架提供的实现类，为我们处理异常
     * 但是：实际开发中：异常处理我们需要自定义。因为异常的种类有很多种
     * 所以就需要自定义异常类实现HanderExceptionResolver异常处理器这个接口
     * @return
     */
    @RequestMapping("/testException")
    public String testException() {
        int i = 1 / 0;
        // 逻辑视图：拼接前缀和后缀
        return "success";
    }
}
