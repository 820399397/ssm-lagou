package cn.xuguowen.service.impl;

import cn.xuguowen.dao.AccountMapper;
import cn.xuguowen.pojo.Account;
import cn.xuguowen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-30 13:33
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;
    /**
     * 调用dao完成查询所有
     * @return
     */
    @Override
    public List<Account> findAll() {
        List<Account> all = accountMapper.findAll();
        return all;
    }
}
