package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.UserRoleMappingDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.UserRoleMappingPO;
import com.msh.artascope.sys.client.qo.UserRoleMappingQO;
import com.msh.artascope.sys.client.vo.UserRoleMappingVO;
import com.msh.artascope.sys.service.service.UserRoleMappingService;
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
public class UserRoleMappingServiceImpl extends BaseServiceImpl<UserRoleMappingPO,UserRoleMappingQO> implements UserRoleMappingService {
    @Autowired
    private UserRoleMappingDao userRoleMappingDao;
    @Autowired
    private UserRoleMappingService userRoleMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(UserRoleMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<UserRoleMappingPO>> list(UserRoleMappingQO param) {
        return super.list(param);
    }

    @Override
    public CommonResult insert(UserRoleMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<UserRoleMappingPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(UserRoleMappingQO param) {
        long result = userRoleMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<UserRoleMappingVO>> listUserRoleMappingVO(UserRoleMappingQO param) {
        List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(param).getResult();
        if(null == userRoleMappingPOList || userRoleMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<UserRoleMappingVO> userRoleMappingVOList = new ArrayList<>(userRoleMappingPOList.size());
        for(UserRoleMappingPO userRoleMappingPO: userRoleMappingPOList){
            UserRoleMappingVO userRoleMappingVO = new UserRoleMappingVO(userRoleMappingPO);
            userRoleMappingVOList.add(userRoleMappingVO);
        }

        return CommonResult.successReturn(userRoleMappingVOList);
    }


    @Override
    public CommonResult deleteByRoleIds(UserRoleMappingQO param) {
        long result = userRoleMappingDao.deleteByRoleIds(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }
}
