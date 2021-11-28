package cn.xuguowen.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 徐国文
 * @create 2021-10-23 14:15
 * 1.Spring MVC中的拦截器类似于java web中的过滤器Filter，用于对处理器（Controller）进行预处理和后处理
 * 2.但是他俩也不是完全的一样，还是有差别的。（面试题）
 *      ①使用范围：拦截器 interceptor是Spring mvc框架自己的，只有使用了Spring mvc框架的工程才可以使用
 *               过滤器是servlet规范中的一部分，任何的java web工程都可以使用
 *      ②拦截范围：拦截器只会拦截你要访问的控制器中的方法，如果访问的是jsp,html,css,image,js 是不会被拦截的
 *                过滤器在url-pattern中配置上 /*之后，可以对所有要访问的资源进行拦截
 * 3.Spring mvc中的拦截器也是AOP思想的具体体现：在不改变controller中的方法的前提下，对方法进行增强
 * 4.HandlerInterceptor拦截器接口，该接口中提供了3个默认方法(jdk9)
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 在执行目标方法之前执行
     * @param request
     * @param response
     * @param handler
     * @return false:表示不放行 true:表示放行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle1执行了！");
        // 放行
        return true;
    }

    /**
     * 在目标方法执行之后，视图对象返回之前 执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle1执行了！");
    }

    /**
     * 在流程都完毕之后 执行（这一整次的请求和响应执行完毕之后执行）
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion1执行了！");
    }
}
