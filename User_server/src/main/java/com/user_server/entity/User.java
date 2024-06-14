package com.user_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "u_id", type = IdType.AUTO)
    private int uid;
    @TableField(value = "u_name")
    private String uname;
    @TableField(value = "u_password")
    private String upassward;
    @TableField(value = "u_telephone")
    private String utelephone;
    @TableField(value = "u_balance")
    private String ubalance;
    @TableField(value = "u_brand")
    private String ubrand;
    @TableField(value = "u_address")
    private String uaddress;
    @TableField(value = "o_uid")
    private int o_uid;
    @TableField(value = "u_status")
    private int ustatus;
}
