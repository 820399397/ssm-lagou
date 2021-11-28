package cn.xuguowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 徐国文
 * @create 2021-10-23 14:31
 * 目标controller 控制器
 */
@Controller
public class TargetController {
    /**
     * 目标方法：对该方法进行拦截
     * @return
     */
    @RequestMapping("/targetMethod")
    public String targetMethod() {
        System.out.println("targetMethod目标方法执行了！");
        return "success";
    }
}
