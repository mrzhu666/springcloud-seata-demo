package org.mrzhuyk.practice.springcloudseatademo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName account_tbl
 */
@TableName(value ="account_tbl")
public class AccountTbl implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String user_id;

    /**
     * 
     */
    private Integer money;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * 
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * 
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 
     */
    public void setMoney(Integer money) {
        this.money = money;
    }
}