package cn.xuguowen.mapper;

import cn.xuguowen.pojo.Account;
import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-24 19:46
 */
public interface AccountMapper {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 保存用户
     * @param account
     */
    void save(Account account);

    /**
     * 根据id查询指定的用户
     * @return
     */
    Account findById(Integer id);

    void update(Account account);

    void deleteBatch(Integer[] ids);
}
