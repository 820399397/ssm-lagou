package cn.xuguowen.servie;

import cn.xuguowen.pojo.Account;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-24 20:58
 */
public interface AccountService {
    /**
     * 调用dao完成查询所有
     * @return
     */
    List<Account> findAll();

    void save(Account account);

    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
