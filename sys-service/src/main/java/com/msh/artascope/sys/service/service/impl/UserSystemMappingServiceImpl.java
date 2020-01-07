package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.UserSystemMappingDao;
import com.msh.artascope.sys.service.service.UserSystemMappingService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.UserSystemMappingPO;
import com.msh.artascope.sys.client.qo.UserSystemMappingQO;
import com.msh.artascope.sys.client.vo.UserSystemMappingVO;
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
public class UserSystemMappingServiceImpl extends BaseServiceImpl<UserSystemMappingPO,UserSystemMappingQO> implements UserSystemMappingService {
    @Autowired
    private UserSystemMappingDao userSystemMappingDao;
    @Autowired
    private UserSystemMappingService userSystemMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(UserSystemMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<UserSystemMappingPO>> list(UserSystemMappingQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(UserSystemMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<UserSystemMappingPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(UserSystemMappingQO param) {
        long result = userSystemMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<UserSystemMappingVO>> listUserSystemMappingVO(UserSystemMappingQO param) {
        List<UserSystemMappingPO> userSystemMappingPOList = userSystemMappingService.list(param).getResult();
        if(null == userSystemMappingPOList || userSystemMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<UserSystemMappingVO> userSystemMappingVOList = new ArrayList<>(userSystemMappingPOList.size());
        for(UserSystemMappingPO userSystemMappingPO: userSystemMappingPOList){
            UserSystemMappingVO userSystemMappingVO = new UserSystemMappingVO(userSystemMappingPO);
            userSystemMappingVOList.add(userSystemMappingVO);
        }

        return CommonResult.successReturn(userSystemMappingVOList);
    }
}
