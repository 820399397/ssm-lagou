package cn.xuguowen.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 徐国文
 * @create 2021-10-23 14:15
 * 自定义拦截器2
 */
public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * 在执行目标方法之前执行
     * @param request
     * @param response
     * @param handler
     * @return false:表示不放行 true:表示放行
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle2执行了！");
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
        System.out.println("postHandle2执行了！");
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
        System.out.println("afterCompletion2执行了！");
    }
}
