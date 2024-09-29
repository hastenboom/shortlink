package com.hasten.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hasten.shortlink.admin.common.convention.exception.ClientException;
import com.hasten.shortlink.admin.common.enums.UserErrorCodeEnum;
import com.hasten.shortlink.admin.dao.entity.UserDO;
import com.hasten.shortlink.admin.dao.mapper.UserMapper;
import com.hasten.shortlink.admin.dto.resp.UserRespDTO;
import com.hasten.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author Hasten
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> eqWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);

        UserDO userDO = baseMapper.selectOne(eqWrapper);
        if (userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO result = new UserRespDTO();

        BeanUtils.copyProperties(userDO, result);

        return result;
    }

}
