package com.user_server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
    @TableId(value = "id", type = IdType.AUTO)
    private int uid;
    private String uname;
    private String upassward;
    private String utelephone;
    private String ubalance;
    private String ubrand;
    private String uaddress;
    private int o_uid;
    private int ustatus;
}
