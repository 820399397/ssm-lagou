package cn.xuguowen.controller;

import cn.xuguowen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 徐国文
 * @create 2021-10-22 18:22
 */
// @Controller
@RestController // 组合注解：相当于@Controller + @ResponseBody 两个注解的功能
@RequestMapping("/restful")     // 一级访问路径
public class RestfulController {
    /**
     * 模拟查询所有用户信息
     * 传统开发要想访问到这个方法，需要编写的请求路径是：localhost:8080/项目名称/restful/user?id=2
     * 现在使用Restful风格，请求路径是：localhost:8080/项目名称/restful/user/2 + 请求方式
     * @return
     */
    // {id}是Restful中的占位符。请求路径和请求方式组合起来就是根据id查询用户的功能
    // @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    // @ResponseBody
    public String findById(@PathVariable  Integer id) {
        // 实际开发中，要调用业务层的的查询方法，将获取到的id值传递
        // 那么问题来了:如何获取到参数id的值并且将赋值给形参中的id呢？
        // 解决问题：使用注解@PathVariable将参数id值赋值给形参id

        // 问题二：这样写返回值，框架会认为是字符串逻辑视图名称，那么视图解析器会拼接前缀和后缀，这样的话就会出现404的错误
        // 如何解决这个问题呢？使用@ResponseBody注解，就不会经过视图解析器了，就是将字符串内容写在了页面上
        return "findById:" + id;
    }

    /**
     * 使用Restful风格编写查询所有用户信息
     * @return
     */
    // 原始请求url：localhost:8080/项目名称/restful/user
    // Restful请求方式：localhost:8080/项目名称/restful/user + 请求方式
    // @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    // @ResponseBody
    public String findAll() {
        return "findAll";
    }

    /**
     * Restful风格下插入用户信息
     * 将表单中的数据都封装到user对象中
     * @param user
     * @return
     */
    // @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    // @ResponseBody
    public String insert(User user) {
        System.out.println(user);
        return "insert";
    }

    // 修改(put)和删除(delete)用户信息的测试可以在postman软件中测试

    /**
     * Restful风格下实现根据id修改用户信息
     * @return
     */
    // @RequestMapping(value = "/user/1",method = RequestMethod.PUT)
    @PutMapping("/user/{id}")
    // @ResponseBody
    public String update(@PathVariable Integer id) {
        System.out.println("用户的id是：" + id);
        return "update";
    }

    /**
     * Restful风格下根据用户id删除用户信息
     * @return
     */
    // @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    // @ResponseBody
    public String delete(@PathVariable Integer id) {
        System.out.println("用户的id值为 " + id);
        return "delete";
    }
}
