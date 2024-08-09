package org.mrzhuyk.practice.springcloudseatademo.service;

import org.mrzhuyk.practice.springcloudseatademo.domain.AccountTbl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author mrzhu
* @description 针对表【account_tbl】的数据库操作Service
* @createDate 2024-08-09 22:50:55
*/
public interface AccountTblService extends IService<AccountTbl> {
    /**
     * 余额扣款
     *
     * @param userId 用户ID
     * @param money  扣款金额
     */
    void debit(String userId, int money);
}
