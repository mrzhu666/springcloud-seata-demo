package org.mrzhuyk.practice.springcloudseatademo.service;

import org.mrzhuyk.practice.springcloudseatademo.domain.StockTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mrzhu
* @description 针对表【stock_tbl】的数据库操作Service
* @createDate 2024-08-09 22:50:55
*/
public interface StockTblService extends IService<StockTbl> {
    /**
     * 扣减库存
     *
     * @param commodityCode 商品编号
     * @param count         扣减数量
     */
    void deduct(String commodityCode, int count);
}
