package org.mrzhuyk.practice.springcloudseatademo.service;

import org.mrzhuyk.practice.springcloudseatademo.domain.OrderTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mrzhu
* @description 针对表【order_tbl】的数据库操作Service
* @createDate 2024-08-09 22:50:55
*/
public interface OrderTblService extends IService<OrderTbl> {
    
    /**
     * 创建订单
     *
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    void create(String userId, String commodityCode, int orderCount);
}
