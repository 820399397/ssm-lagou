package cn.xuguowen.servie.impl;

import cn.xuguowen.mapper.AccountMapper;
import cn.xuguowen.pojo.Account;
import cn.xuguowen.servie.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-24 20:59
 */
@Service
public class AccountServiceImpl implements AccountService {

    // 需要用到dao层的代理对象
    @Autowired
    private AccountMapper accountMapper;
    /**
     * 调用dao完成查询所有
     * @return
     */
    public List<Account> findAll() {
        List<Account> list = accountMapper.findAll();
        return list;
    }

    /**
     * 调用dao完成保存
     * @param account
     */
    public void save(Account account) {
        accountMapper.save(account);
    }

    /**
     * 根据id查询指定的用户，进行数据的回显
     * @param id
     * @return
     */
    public Account findById(Integer id) {
        return accountMapper.findById(id);
    }

    /**
     * 修改账户信息
     * @param account
     */
    public void update(Account account) {
        accountMapper.update(account);
    }

    /**
     * 删除选中账户信息
     * @param ids
     */
    public void deleteBatch(Integer[] ids) {
        accountMapper.deleteBatch(ids);
    }
}
