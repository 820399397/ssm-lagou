package cn.xuguowen.spring;

import cn.xuguowen.pojo.Account;
import cn.xuguowen.servie.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-24 21:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestFindAll {

    // 注入accountService对象
    @Autowired
    private AccountService accountService;

    @Test
    public void test() {
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

}
