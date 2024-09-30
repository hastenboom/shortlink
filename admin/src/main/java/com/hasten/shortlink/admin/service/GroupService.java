package com.hasten.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hasten.shortlink.admin.dao.entity.GroupDO;
import com.hasten.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * @author Hasten
 */
public interface GroupService extends IService<GroupDO> {


    /**
     * 新增短链接分组，这里只需要单纯的groupName即可。而不需要整个GroupReqDO;
     * @param groupName
     */
    void saveGroup(String groupName);

    List<ShortLinkGroupRespDTO> listGroup();
}
