package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.SystemAuthorityMappingDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.SystemAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.SystemAuthorityMappingQO;
import com.msh.artascope.sys.client.vo.SystemAuthorityMappingVO;
import com.msh.artascope.sys.service.service.SystemAuthorityMappingService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class SystemAuthorityMappingServiceImpl extends BaseServiceImpl<SystemAuthorityMappingPO,SystemAuthorityMappingQO> implements SystemAuthorityMappingService {
    @Autowired
    private SystemAuthorityMappingDao systemAuthorityMappingDao;
    @Autowired
    private SystemAuthorityMappingService systemAuthorityMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(SystemAuthorityMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<SystemAuthorityMappingPO>> list(SystemAuthorityMappingQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(SystemAuthorityMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<SystemAuthorityMappingPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(SystemAuthorityMappingQO param) {
        long result = systemAuthorityMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<SystemAuthorityMappingVO>> listSystemAuthorityMappingVO(SystemAuthorityMappingQO param) {
        List<SystemAuthorityMappingPO> systemAuthorityMappingPOList = systemAuthorityMappingService.list(param).getResult();
        if(null == systemAuthorityMappingPOList || systemAuthorityMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<SystemAuthorityMappingVO> systemAuthorityMappingVOList = new ArrayList<>(systemAuthorityMappingPOList.size());
        for(SystemAuthorityMappingPO systemAuthorityMappingPO: systemAuthorityMappingPOList){
            SystemAuthorityMappingVO systemAuthorityMappingVO = new SystemAuthorityMappingVO(systemAuthorityMappingPO);
            systemAuthorityMappingVOList.add(systemAuthorityMappingVO);
        }

        return CommonResult.successReturn(systemAuthorityMappingVOList);
    }
}
