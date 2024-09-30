package com.hasten.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Hasten
 */
@Data
@TableName("t_group")
public class GroupDO {

//    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    /**
     * id
     */
    private Long id;

    /**
     * 短链接分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * username
     */
    private String username;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * update_time
     */
    private Date updateTime;

    /**
     * del_flag
     */
    private Integer delFlag;

    public GroupDO() {

    }
}