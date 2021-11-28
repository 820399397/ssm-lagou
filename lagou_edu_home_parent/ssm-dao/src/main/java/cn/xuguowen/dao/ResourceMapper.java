package cn.xuguowen.dao;

import cn.xuguowen.pojo.Resource;
import cn.xuguowen.pojo.ResourceVo;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-11 20:49
 * 资源列表功能的dao层
 */
public interface ResourceMapper {
    /**
     * 查询所有资源信息/多条件查询资源信息，并且进行分页查询
     * @param resourceVo
     * @return
     */
    List<Resource> findAllResourceByPage(ResourceVo resourceVo);

    /**
     * 保存资源信息
     * @param resource
     */
    void saveResource(Resource resource);

    /**
     * 根据id修改资源信息
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 根据id删除资源信息
     * @param id
     */
    void deleteResource(Integer id);
}
