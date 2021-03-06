package cn.xuguowen.service;

import cn.xuguowen.pojo.Menu;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-07 20:18
 * 菜单功能的业务逻辑层
 */
public interface MenuService {
    /**
     * 查询父子级菜单列表
     * @param pid
     * @return
     */
    List<Menu> findParentMenuAndSubMenu(Integer pid);

    /**
     * 查询所有菜单列表
     * @return
     */
    List<Menu> findAllMenu();

    /**
     * 根据菜单id查询菜单信息进行数据的回显
     * @param id
     * @return
     */
    Menu findMenuById(Integer id);

    /**
     * 保存菜单信息
     * @param menu
     */
    void saveMenu(Menu menu);

    /**
     * 根据id修改菜单信息
     * @param menu
     */
    void updateMenu(Menu menu);
}
