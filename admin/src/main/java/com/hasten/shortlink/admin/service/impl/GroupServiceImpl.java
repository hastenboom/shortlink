package com.hasten.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hasten.shortlink.admin.dao.entity.GroupDO;
import com.hasten.shortlink.admin.dao.mapper.GroupMapper;
import com.hasten.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;
import com.hasten.shortlink.admin.service.GroupService;
import com.hasten.shortlink.admin.toolkit.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hasten
 */
@Service
@RequiredArgsConstructor
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    @Override
    public void saveGroup(String groupName) {

        String gid;

        //keep generating the random gid until it's unique
        //？为什么不用雪花算法呢？
        do {
            gid = RandomGenerator.generateRandom();
        } while (!hasGid(gid));


        GroupDO groupDO = GroupDO.builder()
                .gid(gid)
                .name(groupName)
                .sortOrder(0)
                .build();

        baseMapper.insert(groupDO);
    }

    @Override
    public List<ShortLinkGroupRespDTO> listGroup() {
        /*TODO: get the user*/

        LambdaQueryWrapper<GroupDO> wrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, null/*TODO:获取当前登录用户*/)
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);

        List<GroupDO> groupList = baseMapper.selectList(wrapper);

        return BeanUtil.copyToList(groupList, ShortLinkGroupRespDTO.class);
    }


    private boolean hasGid(String gid) {
//        String gid = RandomGenerator.generateRandom();

        LambdaQueryWrapper<GroupDO> eqWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, null/*TODO:获取当前登录用户*/);

        return baseMapper.selectOne(eqWrapper) == null;

    }

}
