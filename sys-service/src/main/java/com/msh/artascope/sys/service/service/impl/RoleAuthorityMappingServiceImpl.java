package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.RoleAuthorityMappingDao;
import com.msh.artascope.sys.service.service.RoleAuthorityMappingService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.RoleAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.artascope.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.artascope.sys.client.vo.RoleVO;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class RoleAuthorityMappingServiceImpl extends BaseServiceImpl<RoleAuthorityMappingPO,RoleAuthorityMappingQO> implements RoleAuthorityMappingService {
    @Autowired
    private RoleAuthorityMappingDao roleAuthorityMappingDao;
    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(RoleAuthorityMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<RoleAuthorityMappingPO>> list(RoleAuthorityMappingQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(RoleAuthorityMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<RoleAuthorityMappingPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(RoleAuthorityMappingQO param) {
        long result = roleAuthorityMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<RoleAuthorityMappingVO>> listRoleAuthorityMappingVO(RoleAuthorityMappingQO param) {
        List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(param).getResult();
        if(null == roleAuthorityMappingPOList || roleAuthorityMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<RoleAuthorityMappingVO> roleAuthorityMappingVOList = new ArrayList<>(roleAuthorityMappingPOList.size());
        for(RoleAuthorityMappingPO roleAuthorityMappingPO: roleAuthorityMappingPOList){
            RoleAuthorityMappingVO roleAuthorityMappingVO = new RoleAuthorityMappingVO(roleAuthorityMappingPO);
            roleAuthorityMappingVOList.add(roleAuthorityMappingVO);
        }

        return CommonResult.successReturn(roleAuthorityMappingVOList);
    }


    @Override
    public CommonResult deleteByAuthorityIds(RoleAuthorityMappingQO param) {
        long result = roleAuthorityMappingDao.deleteByAuthorityIds(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    @Transactional
    public CommonResult updateRoleAuth(RoleVO roleVO) {
        if(null == roleVO.getId()){
            return CommonResult.errorReturn(CommonCode.PARAM_ERROR.getCode(),"参数错误,没有角色id");
        }
        Set<Long> dbAuthorityIds = this.getAuthorityIds(roleVO);
        Set<Long> newAuthorityIds = roleVO.getAuthIds();
        if(null == newAuthorityIds){
            newAuthorityIds = Collections.emptySet();
        }

        if(!dbAuthorityIds.isEmpty() && !dbAuthorityIds.isEmpty()){
            dbAuthorityIds.removeAll(newAuthorityIds);
            newAuthorityIds.removeAll(dbAuthorityIds);
        }
        if(!dbAuthorityIds.isEmpty()){
            RoleAuthorityMappingQO roleAuthorityMappingQO = new RoleAuthorityMappingQO();
            roleAuthorityMappingQO.setInAuthorityIds(dbAuthorityIds);
            roleAuthorityMappingQO.setTenantId(roleVO.getTenantId());
            roleAuthorityMappingService.deleteByAuthorityIds(roleAuthorityMappingQO);
        }
        if(!newAuthorityIds.isEmpty()){
            roleAuthorityMappingService.insertCollection(
                newAuthorityIds.stream().map(l->{
                    RoleAuthorityMappingPO sysRoleAuthorityMappingPO = new RoleAuthorityMappingPO();
                    sysRoleAuthorityMappingPO.setRoleId(roleVO.getId());
                    sysRoleAuthorityMappingPO.setAuthorityId(l);
                    return sysRoleAuthorityMappingPO;
                }).collect(Collectors.toSet())
            );
        }

        return CommonResult.successReturn();
    }

    /**
     * 获取权限id set
     * @param roleVO
     * @return
     */
    private Set<Long> getAuthorityIds(RoleVO roleVO){
        RoleAuthorityMappingQO sysRoleAuthorityMappingQO = new RoleAuthorityMappingQO();
        sysRoleAuthorityMappingQO.setRoleId(roleVO.getId());
        sysRoleAuthorityMappingQO.setTenantId(roleVO.getTenantId());
        List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(sysRoleAuthorityMappingQO).getResult();
        if(!CollectionUtils.isEmpty(roleAuthorityMappingPOList)){
            return roleAuthorityMappingPOList.stream().map(p->p.getAuthorityId()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
