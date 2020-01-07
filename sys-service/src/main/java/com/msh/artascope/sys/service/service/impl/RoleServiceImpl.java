package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.RoleDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.RolePO;
import com.msh.artascope.sys.client.qo.RoleQO;
import com.msh.artascope.sys.client.vo.RoleVO;
import com.msh.artascope.sys.service.service.RoleService;
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
public class RoleServiceImpl extends BaseServiceImpl<RolePO,RoleQO> implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private RoleService roleService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(RolePO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<RolePO>> list(RoleQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(RolePO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<RolePO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(RoleQO param) {
        long result = roleDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<RoleVO>> listRoleVO(RoleQO param) {
        List<RolePO> rolePOList = roleService.list(param).getResult();
        if(null == rolePOList || rolePOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<RoleVO> roleVOList = new ArrayList<>(rolePOList.size());
        for(RolePO rolePO: rolePOList){
            RoleVO roleVO = new RoleVO(rolePO);
            roleVOList.add(roleVO);
        }

        return CommonResult.successReturn(roleVOList);
    }
}
