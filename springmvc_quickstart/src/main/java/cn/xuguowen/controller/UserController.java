package cn.xuguowen.controller;

import cn.xuguowen.pojo.QueryVo;
import cn.xuguowen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-18 15:09
 *  把这个普通的类变为一个servlet类，然后还要指定类中方法的访问路径
 */
@Controller // 将创建的UserController对象存储到Spring MVC创建的ioc容器中（子容器）
@RequestMapping("/user")    // 一级访问目录
@SessionAttributes("username")  // model(request)域中存储的数据，会同步到session域中
public class UserController {

    // 1.@RequestMapping作用：用于建立请求URL和处理请求方法之间的对应关系（根据路径找到指定的方法执行）
    // 2.这个注解也可以在类上进行配置，表示一级访问目录，在方法上配置，表示二级访问目录
    // http://localhost:8080/springmvc_quickstart/一级访问目录/二级访问目录
    // 3.这个注解有很多属性的，其中我们只关心value、path、method、params属性
    // value属性用来指定请求的URL。他和path属性的作用是一样的
    // method属性：用来限定请求的方式 method = RequestMethod.POST 只能是post请求
    // params属性：用来限定请求参数的条件 params = {"accountName"}表示请求路劲中必须携带accountName的参数
    @RequestMapping(path = "/quick",method = RequestMethod.GET,params = {"accountName"})   // 二级访问目录
    public String quick() {
        System.out.println("Spring MVC 从入门到入土！");

        // 完成请求转发：逻辑视图名（并不是真正得物理地址），
        // 需要在springmvc核心配置文件中显示得配置视图解析器，拼接上前缀和后缀
        return "success";
    }

    /**
     * 接收前端基本类型的参数
     * @param id
     * @param username
     * @return
     */
    @RequestMapping("/simpleParams")
    public String simpleParams(Integer id,String username) {
        System.out.println("id：" + id);
        System.out.println("username：" + username);
        return "success";
    }

    /**
     * 将页面表单传递的参数封装到user实体中（按照一定的要求编写代码，mvc底层将我们完成）
     * 需要注意的就是：前端页面中文本框中的name属性值要和实体类中的属性名成一致，这样框架才会帮我们完成数据的封装
     * @param user
     * @return
     */
    @RequestMapping("/pojoParams")
    public String pojoParams(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 将复选框中value属性的值传递到ids参数上，
     * 注意的是：复选框中name属性的值要和形参中的数组名相同
     * @param ids
     * @return
     */
    @RequestMapping("/arrayParams")
    public String arrayParams(Integer[] ids) {
        System.out.println(Arrays.toString(ids));
        return "success";
    }

    /**
     * 接收页面传递的复杂参数类型（集合，实体对象）
     * @param vo
     * @return
     */
    @RequestMapping("/listParams")
    public String listParams(QueryVo vo) {
        System.out.println(vo);
        return "success";
    }

    /**
     * 页面传递的日期参数是 2022/12/12这样类型的日期参数，
     * 框架是可以自动进行转换的（将日期字符串自动转换为日期类型对象）
     * 但是如果前端页面就要传递2020-12-11这样格式的日期字符串，框架是不会将日期字符串解析成日期对象的，会出现400错误，Bad Request
     * 自定义类型转换器
     * @param birthday
     * @return
     */
    @RequestMapping("/converterParam")
    public String converterParam(Date birthday) {
        System.out.println(birthday);
        return "success";
    }

    /**
     * 演示@RequestParam注解：当页面传递的请求参数name和后台控制器中业务方法的形参名称不一致时，可以使用这个注解完成自动匹配
     * 页面传递的参数name是 pageNo，而方法中形参的名称是 pageNum,是无法完成自动匹配的
     * 此时需要借助@RequestParam注解来解决这个问题
     *  说明该注解中的属性
     *          1.name属性：表示页面传递参数的name
     *          2.defaultValue 如果页面中没有传递该name的值，那么默认值是 1
     *          3.required 设置前端页面是否必须传递该参数，默认值是true，表示必须携带该参数进行请求
     *                      但是当你设置了defaultValue属性后，它的值会自动改为false，表示传递该参数不是必须的
     * @param pageNum  当前页数
     * @param pageSize 每页显示的条数
     * @return
     */
    @RequestMapping("/findByPage")
    public String findByPage(@RequestParam(name = "pageNo",defaultValue = "1",required = false) Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println("当前页数:" + pageNum);   // 2
        System.out.println("每页显示的条数:" + pageSize);   // 5

        return "success";
    }

    /**
     * 通过@RequestHeader注解获取请求头中的所有值
     * @param cookie
     * @return
     */
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader String cookie) {
        System.out.println(cookie);
        return "success";
    }

    /**
     * 根据@CookieValue注解获取cookie中某一项的值
     * ctrl shift y IDEA快捷键，转换大小写
     * @param jsessionid
     * @return
     */
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
        return "success";
    }

    /**
     * 获取servlet原生的api，直接在方法形参上标识就ok，框架会帮我们自动注入
     * @param request
     * @param response
     * @param session
     * @return
     */
    @RequestMapping("/servletApi")
    public String servletApi(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }

    /**
     * 在业务方法中使用原生的servletAPI完成页面的转发以及重定向
     * 注意：该方法没有返回值
     * @param request
     * @param response
     */
    @RequestMapping("returnServlet")
    public void returnServlet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        // 1.请求转发到success.jsp页面
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 2.重定向到success.jsp页面上：发起两次请求
        // 所以重定向不能访问WEB-INF安全目录下的资源文件，如果想要访问该目录下的文件，就得是服务器内部转发访问
        // 是不允许客户端访问安全目录下得资源文件得
        // response.sendRedirect(request.getContextPath() + "/WEB-INF/pages/success.jsp");
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /**
     * 在实际开发中，我们不会使用原生得servletAPI完成转发以及重定向，但是底层采用的就是原生的API方式完成的
     * 所以是不会走视图解析器的，也就不会进行前缀和后缀的拼接
     * 最常用的还是返回字符串逻辑视图实现转发和重定向
     * return "forward:实际视图的url" == request.getRequestDispatcher("url").forward(request,response)
     * @param model
     * @return
     */
    @RequestMapping("/forward")
    public String forward(Model model) {
        // 借助模型对象存储数据（底层就是request.setAttribute("username":"zhangsan") ）
        model.addAttribute("username","MyikJ");
        // 1.转发到success.jsp页面上
        return "forward:/WEB-INF/pages/success.jsp";
        // 2.也可以转发到controller中的其他业务方法上
        // return "forward:/user/findAll";
    }

    /**
     * 如果没有在类上加上 @SessionAttributes，是无法获取到/forward请求下存储的数据 username
     * 如果在类上加上 @SessionAttributes ,就是将ruquest域中存储的数据存同步到session域中，
     * 那么在其他的请求中就可以获取到request域中的数据了（model中存储的数据）
     * @return
     */
    @RequestMapping("/returnString")
    public String returnString() {
        return "success";
    }

    /**
     * 使用字符串逻辑视图的方式实现重定向，其中项目路径（虚拟路径是可以省略的）
     *          response.sendRedirect(request.getContextPath() + "/index.jsp");
     *          return "redirect:[虚拟路径/项目路径]/index.jsp"
     * @param model
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect(Model model) {
        // 注意：向模型中添加属性，它的底层代码就是request.setAttribute("username","徐国文");
        // 数据存储的域范围是request
        // 如果重定向之后，模型中的数据会被拼接到url后面作为参数
        // http://localhost:8080/springmvc_quickstart/index.jsp?username=%E5%BE%90%E5%9B%BD%E6%96%87
        model.addAttribute("username","徐国文");
        // 项目路径可以省略不写，框架会帮助我们拼接的
        return "redirect:/index.jsp";
    }

    /**
     * 使用ModelAndView对象存储数据，并进行转发方式一(服务器内部转发)
     *      model:模型 来封装数据的
     *      view:视图 展示数据的
     * @return
     */
    @RequestMapping("/returnModelAndView1")
    public ModelAndView returnModelAndView1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","returnModelAndView1");
        // handler（controller）执行完毕之后返回modelAndView对象，然后处理器适配器将modelAndView
        // 对象返回给前端控制器，前端控制器调用视图解析器解析返回view对象
        // 所以它这里要经过视图解析器，也就会拼接上mvc配置文件中配置的前缀和后缀
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用ModelAndView对象存储数据，并进行转发方式二(服务器内部转发)
     * @param modelAndView
     * @return
     */
    @RequestMapping("/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView) {
        modelAndView.addObject("username","returnModelAndView2");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 将前端页面传递的json数据转换为java对象，借助@RequestBody
     * Springmvc默认用MappingJackson2HttpMessageConverter对json数据进行转换
     * @param list
     */
    @RequestMapping(value = "/ajaxRequestList",method = RequestMethod.POST)
    @ResponseBody
    public List<User> ajaxRequestList(@RequestBody List<User> list) {
        System.out.println(list);
        return list;
    }

    /**
     * 前端页面传递对象格式的json数据，然后将json数据自动封装到User实体类对象上，
     * 并且将实体类user转换为json数据
     * @param user
     * @return
     */
    @RequestMapping("/ajaxRequestPojo")
    @ResponseBody
    public User ajaxRequestPojo(@RequestBody User user) {
        System.out.println(user);
        return user;
    }
}
