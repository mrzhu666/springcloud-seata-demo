package org.mrzhuyk.practice.springcloudseatademo.service.impl;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.mrzhuyk.practice.springcloudseatademo.service.AccountTblService;
import org.mrzhuyk.practice.springcloudseatademo.service.BusinessService;
import org.mrzhuyk.practice.springcloudseatademo.service.OrderTblService;
import org.mrzhuyk.practice.springcloudseatademo.service.StockTblService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class BusinessServiceImpl implements BusinessService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);
    
    @Resource
    private StockTblService stockTblService;
    @Resource
    private OrderTblService orderTblService;
    
    
    private final Random random = new Random();
    
    @Override
    @GlobalTransactional(timeoutMills = 300000, name = "spring-seata-tx")
    public void purchase(String userId, String commodityCode, int orderCount) {
        LOGGER.info("purchase begin ... xid: " + RootContext.getXID());
        stockTblService.deduct(commodityCode, orderCount);
        orderTblService.create(userId, commodityCode, orderCount);
        
        // 模拟异样，异常后事务能得到回滚
        //if (random.nextBoolean()) {
            throw new RuntimeException("random exception mock!");
        //}
    }
}
