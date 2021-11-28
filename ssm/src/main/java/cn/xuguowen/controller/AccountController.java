package cn.xuguowen.controller;

import cn.xuguowen.pojo.Account;
import cn.xuguowen.servie.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-25 21:17
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        // 调用service查询
        List<Account> list = accountService.findAll();
        // 使用假数据
//        ArrayList<Account> list = new ArrayList<Account>();
//        list.add(new Account(1,"张三",1000d));
//        list.add(new Account(2,"李四",2000d));
        // 将数据存储到request域中
        model.addAttribute("list",list);

        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account) {

        accountService.save(account);
        return "redirect:/account/findAll";
    }

    @RequestMapping("/findById")
    public String findById(Integer id,Model model) {
        Account account = accountService.findById(id);
        System.out.println(account);
        // 要进行数据的回显：我就要把account对象存储到request域当中去
        model.addAttribute("account",account);

        return "update";
    }

    /**
     * 根据表单中的参数修改账户信息
     * @param account
     * @return
     */
    @RequestMapping("/update")
    public String update(Account account) {
        accountService.update(account);
        return "redirect:/account/findAll";
    }

    /**
     * 删除选中的账户信息
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids) {
        accountService.deleteBatch(ids);

        return "redirect:/account/findAll";
    }
}
