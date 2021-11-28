package cn.xuguowen.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 徐国文
 * @create 2021-10-23 11:53
 * 自定义异常类的实现步骤
 *  1.定义自定义异常类
 *  2.在mvc核心配置文件中配置自定义异常类实例对象：xml方式 / 注解方式
 *  3.编写错误页面：就是出现异常要跳转的页面
 *  4.测试异常跳转：请求/testException这个业务方法实现测试效果
 */
// @Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    /**
     * 当出现异常时，会执行这个方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 实际抛出的异常对象
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error",e.getMessage());
        // 逻辑视图名称：会经过视图解析器进行前缀和后缀的拼接
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
