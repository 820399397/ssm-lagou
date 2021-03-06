package cn.xuguowen.dao;

import cn.xuguowen.pojo.PromotionSpace;

import java.util.List;

/**
 * @author 徐国文
 * @create 2021-11-03 13:45
 */
public interface PromotionSpaceMapper {
    /**
     * 对promotion_space完成查询所有的操作
     * @return
     */
    List<PromotionSpace> findAllPromotionSpace();

    /**
     * 保存广告位信息
     * @param promotionSpace
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /**
     * 根据广告位表中的某一个id查询某一个广告位信息，做回显用的
     * @param id
     * @return
     */
    PromotionSpace findPromotionSpaceById(Integer id);

    /**
     * 根据广告位id修改广告位
     * @param promotionSpace
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);
}
