package cn.xuguowen.service.impl;

import cn.xuguowen.dao.MenuMapper;
import cn.xuguowen.pojo.Menu;
import cn.xuguowen.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-07 20:19
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询父子级菜单列表
     * @param pid
     * @return
     */
    @Override
    public List<Menu> findParentMenuAndSubMenu(Integer pid) {
        List<Menu> parentMenuAndSubMenu = menuMapper.findParentMenuAndSubMenu(pid);

        return parentMenuAndSubMenu;
    }

    /**
     * 查询所有菜单列表
     * @return
     */
    @Override
    public List<Menu> findAllMenu() {
        List<Menu> menuList = menuMapper.findAllMenu();
        return menuList;
    }

    /**
     * 根据菜单id查询菜单信息进行数据的回显
     * @param id
     * @return
     */
    @Override
    public Menu findMenuById(Integer id) {
        Menu menu = menuMapper.findMenuById(id);
        return menu;
    }

    /**
     * 保存菜单信息
     * @param menu
     */
    @Override
    public void saveMenu(Menu menu) {
        menuMapper.saveMenu(menu);
    }

    /**
     * 根据id修改菜单信息
     * @param menu
     */
    @Override
    public void updateMenu(Menu menu) {
        menu.setUpdatedTime(new Date());
        menuMapper.updateMenu(menu);
    }
}
