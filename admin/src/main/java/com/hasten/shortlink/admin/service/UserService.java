package com.hasten.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hasten.shortlink.admin.dao.entity.UserDO;
import com.hasten.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.hasten.shortlink.admin.dto.resp.UserRespDTO;

/**
 * @author Hasten
 */
public interface UserService extends IService<UserDO> {

    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam
     */
    void register(UserRegisterReqDTO requestParam);


    /**
     * 根据用户名修改用户
     * @param requestParam
     */
    void update( UserRegisterReqDTO requestParam);
}
