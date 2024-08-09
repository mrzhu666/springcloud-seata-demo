package org.mrzhuyk.practice.springcloudseatademo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import org.mrzhuyk.practice.springcloudseatademo.domain.OrderTbl;
import org.mrzhuyk.practice.springcloudseatademo.service.AccountTblService;
import org.mrzhuyk.practice.springcloudseatademo.service.BusinessService;
import org.mrzhuyk.practice.springcloudseatademo.service.OrderTblService;
import org.mrzhuyk.practice.springcloudseatademo.mapper.OrderTblMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mrzhu
* @description 针对表【order_tbl】的数据库操作Service实现
* @createDate 2024-08-09 22:50:55
*/
@Service
public class OrderTblServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl>
    implements OrderTblService{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTblService.class);
    
    @Resource
    private AccountTblService accountTblService;
    
    @Resource
    private OrderTblMapper orderTblMapper;
    
    /**
     * @param userId        用户ID
     * @param commodityCode 商品编号
     * @param orderCount    订购数量
     */
    @Override
    public void create(String userId, String commodityCode, int orderCount) {
        LOGGER.info("Order Service Begin ... xid: " + RootContext.getXID());
        OrderTbl order = new OrderTbl();
        order.setUser_id(userId);
        order.setCommodity_code(commodityCode);
        order.setCount(orderCount);
        int orderMoney = calculate(commodityCode, orderCount);
        order.setMoney(orderMoney);
        
        orderTblMapper.insert(order);
        accountTblService.debit(userId, orderMoney);
    }
    
    
    /**
     * 计算总价
     *
     * @param commodityCode
     * @param count
     * @return
     */
    private int calculate(String commodityCode, int count) {
        return 200 * count;
    }
}




