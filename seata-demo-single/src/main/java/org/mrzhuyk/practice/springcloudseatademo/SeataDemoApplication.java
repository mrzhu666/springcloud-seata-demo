package org.mrzhuyk.practice.springcloudseatademo;

import org.mrzhuyk.practice.springcloudseatademo.service.BusinessService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("org.mrzhuyk.practice.springcloudseatademo.**.mapper")
public class SeataDemoApplication implements BeanFactoryAware {
    private static BeanFactory BEAN_FACTORY;
    
    public static final String USER_ID = "U100001";
    public static final String COMMODITY_CODE = "C00321";
    
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SeataDemoApplication.class, args);
        
        BusinessService businessService = BEAN_FACTORY.getBean(BusinessService.class);
        
        Thread thread = new Thread(() -> {
            while (true){
                businessService.purchase(USER_ID, COMMODITY_CODE, 2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
        
        //keep run
        //Thread.currentThread().join();
    }
    
    @Resource
    private JdbcTemplate jdbcTemplate;
    
    @PostConstruct
    public void initData() {
        jdbcTemplate.update("delete from account_tbl");
        jdbcTemplate.update("delete from order_tbl");
        jdbcTemplate.update("delete from stock_tbl");
        jdbcTemplate.update("insert into account_tbl(user_id,money) values('" + USER_ID + "','10000') ");
        jdbcTemplate.update(
            "insert into stock_tbl(commodity_code,count) values('" + COMMODITY_CODE + "','100') ");
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BEAN_FACTORY = beanFactory;
    }
}
