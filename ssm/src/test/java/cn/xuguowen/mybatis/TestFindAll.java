package cn.xuguowen.mybatis;

import cn.xuguowen.mapper.AccountMapper;
import cn.xuguowen.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 徐国文
 * @create 2021-10-24 20:04
 */
public class TestFindAll {

    @Test
    public void testFindAll() throws IOException {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取sqlsessionfactory工厂对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        // 3.获取sqlsession会话对象
        SqlSession sqlSession = factory.openSession();
        // 4.获取mapper代理对象
        AccountMapper accountDao = sqlSession.getMapper(AccountMapper.class);
        // 5.执行语句
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        // 6.释放资源
        sqlSession.close();
    }
}
