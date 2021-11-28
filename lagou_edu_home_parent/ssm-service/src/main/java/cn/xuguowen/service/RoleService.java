package cn.xuguowen.service;

import cn.xuguowen.pojo.Role;
import cn.xuguowen.pojo.RoleMenuVo;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-07 14:39
 * 角色模块service层
 */
public interface RoleService {
    /**
     * 查询所有角色信息 并且也可以实现根据角色名称实现模糊查询
     * @param role
     * @return
     */
    List<Role> findAllAndCondition(Role role);

    /**
     * 根据角色id查询当前角色所具有的菜单信息
     * 目的是在页面上进行菜单信息的回显
     * @param id
     * @return
     */
    List<Integer> findMenuIdByRoleId(Integer id);

    /**
     * 完成为角色分配菜单的功能
     * @param roleMenuVo
     */
    void roleContextMenu(RoleMenuVo roleMenuVo);

    /**
     * 根据id删除角色信息
     * 注意：删除某个角色的时候一定要先删除当前角色所关联的菜单信息，然后再删除这个角色
     * @param roleId
     */
    void deleteRoleByRoleId(Integer roleId);

    /**
     * 保存角色信息：新增一个角色
     * @param role
     */
    void saveRole(Role role);

    /**
     * 根据角色id修改角色西信息
     * @param role
     */
    void updateRole(Role role);
}
