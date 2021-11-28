package cn.xuguowen.dao;

import cn.xuguowen.pojo.Account;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-29 22:16
 */
public interface AccountMapper {
    /**
     * 查询account表中所有的记录
     * @return
     */
    public List<Account> findAll();
}
