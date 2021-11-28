package cn.xuguowen.service;

import cn.xuguowen.pojo.Account;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-30 13:32
 */
public interface AccountService {
    /**
     * 调用dao完成查询所有账户信息
     * @return
     */
    List<Account> findAll();
}
