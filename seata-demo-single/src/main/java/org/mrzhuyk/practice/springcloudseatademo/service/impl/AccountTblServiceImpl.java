package org.mrzhuyk.practice.springcloudseatademo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.mrzhuyk.practice.springcloudseatademo.domain.AccountTbl;
import org.mrzhuyk.practice.springcloudseatademo.service.AccountTblService;
import org.mrzhuyk.practice.springcloudseatademo.mapper.AccountTblMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author mrzhu
* @description 针对表【account_tbl】的数据库操作Service实现
* @createDate 2024-08-09 22:50:55
*/
@Service
public class AccountTblServiceImpl extends ServiceImpl<AccountTblMapper, AccountTbl>
    implements AccountTblService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTblService.class);
    
    @Resource
    private AccountTblMapper accountMapper;
    
    @Override
    public void debit(String userId, int money) {
        LOGGER.info("Account Service ... xid: " + RootContext.getXID());
        LOGGER.info("Deducting balance SQL: update account_tbl set money = money - {} where user_id = {}", money,
            userId);
        LambdaQueryWrapper<AccountTbl> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AccountTbl::getUser_id, userId);
        
        AccountTbl account = accountMapper.selectOne(queryWrapper);
        account.setMoney(account.getMoney()-money);
        accountMapper.updateById(account);
        LOGGER.info("Account Service End ... ");
    }
}




