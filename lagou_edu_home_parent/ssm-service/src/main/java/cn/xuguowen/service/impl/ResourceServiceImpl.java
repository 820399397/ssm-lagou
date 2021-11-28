package cn.xuguowen.service.impl;

import cn.xuguowen.dao.ResourceMapper;
import cn.xuguowen.pojo.Resource;
import cn.xuguowen.pojo.ResourceVo;
import cn.xuguowen.service.ResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-11 21:03
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询所有资源信息/多条件查询资源信息 并且进行分页查询
     * @param resourceVo
     * @return
     */
    @Override
    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo) {
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());

        List<Resource> allResourceByPage = resourceMapper.findAllResourceByPage(resourceVo);
        PageInfo<Resource> pageInfo = new PageInfo<>(allResourceByPage);

        return pageInfo;
    }

    /**
     * 保存资源信息
     * @param resource
     */
    @Override
    public void saveResource(Resource resource) {
        // 补全信息
        Date date = new Date();
        resource.setCreatedTime(date);
        resource.setUpdatedTime(date);

        resource.setCreatedBy("system");
        resource.setUpdatedBy("system");

        resourceMapper.saveResource(resource);
    }

    /**
     * 修改资源信息
     * @param resource
     */
    @Override
    public void updateResource(Resource resource) {
        // 补全信息
        resource.setUpdatedTime(new Date());

        resourceMapper.updateResource(resource);
    }

    /**
     * 根据id删除资源信息
     * @param id
     */
    @Override
    public void deleteResource(Integer id) {
        resourceMapper.deleteResource(id);
    }
}
