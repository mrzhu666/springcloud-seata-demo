package org.mrzhuyk.practice.springcloudseatademo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName order_tbl
 */
@TableName(value ="order_tbl")
public class OrderTbl implements Serializable {
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
    private String commodity_code;

    /**
     * 
     */
    private Integer count;

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
    public String getCommodity_code() {
        return commodity_code;
    }

    /**
     * 
     */
    public void setCommodity_code(String commodity_code) {
        this.commodity_code = commodity_code;
    }

    /**
     * 
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 
     */
    public void setCount(Integer count) {
        this.count = count;
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