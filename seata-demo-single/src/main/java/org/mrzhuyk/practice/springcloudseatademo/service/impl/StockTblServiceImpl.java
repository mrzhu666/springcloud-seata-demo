package org.mrzhuyk.practice.springcloudseatademo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import org.mrzhuyk.practice.springcloudseatademo.domain.StockTbl;
import org.mrzhuyk.practice.springcloudseatademo.service.OrderTblService;
import org.mrzhuyk.practice.springcloudseatademo.service.StockTblService;
import org.mrzhuyk.practice.springcloudseatademo.mapper.StockTblMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mrzhu
* @description 针对表【stock_tbl】的数据库操作Service实现
* @createDate 2024-08-09 22:50:55
*/
@Service
public class StockTblServiceImpl extends ServiceImpl<StockTblMapper, StockTbl>
    implements StockTblService{
    private static final Logger LOGGER = LoggerFactory.getLogger(StockTblService.class);
    
    @Resource
    private StockTblMapper storageMapper;
    
    @Override
    public void deduct(String commodityCode, int count) {
        LOGGER.info("Stock Service Begin ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting inventory SQL: update stock_tbl set count = count - {} where commodity_code = {}", count,
            commodityCode);
        
        LambdaQueryWrapper<StockTbl> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StockTbl::getCommodity_code, commodityCode);
        
        StockTbl stock = storageMapper.selectOne(queryWrapper);
        
        stock.setCount(stock.getCount() - count);
        storageMapper.updateById(stock);
        LOGGER.info("Stock Service End ... ");
    }
}




