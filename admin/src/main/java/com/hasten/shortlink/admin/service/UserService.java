package com.hasten.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hasten.shortlink.admin.dao.entity.UserDO;
import com.hasten.shortlink.admin.dto.resp.UserRespDTO;

/**
 * @author Hasten
 */
public interface UserService extends IService<UserDO> {

    UserRespDTO getUserByUsername(String username);


}
