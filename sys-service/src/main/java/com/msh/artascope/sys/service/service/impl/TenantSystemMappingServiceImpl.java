package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.TenantSystemMappingDao;
import com.msh.artascope.sys.service.service.TenantSystemMappingService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.TenantSystemMappingPO;
import com.msh.artascope.sys.client.qo.TenantSystemMappingQO;
import com.msh.artascope.sys.client.vo.TenantSystemMappingVO;
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
public class TenantSystemMappingServiceImpl extends BaseServiceImpl<TenantSystemMappingPO,TenantSystemMappingQO> implements TenantSystemMappingService {
    @Autowired
    private TenantSystemMappingDao tenantSystemMappingDao;
    @Autowired
    private TenantSystemMappingService tenantSystemMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(TenantSystemMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<TenantSystemMappingPO>> list(TenantSystemMappingQO param) {
        return super.list(param);
    }

    @Override
    public CommonResult insert(TenantSystemMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<TenantSystemMappingPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(TenantSystemMappingQO param) {
        long result = tenantSystemMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<TenantSystemMappingVO>> listTenantSystemMappingVO(TenantSystemMappingQO param) {
        List<TenantSystemMappingPO> tenantSystemMappingPOList = tenantSystemMappingService.list(param).getResult();
        if(null == tenantSystemMappingPOList || tenantSystemMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<TenantSystemMappingVO> tenantSystemMappingVOList = new ArrayList<>(tenantSystemMappingPOList.size());
        for(TenantSystemMappingPO tenantSystemMappingPO: tenantSystemMappingPOList){
            TenantSystemMappingVO tenantSystemMappingVO = new TenantSystemMappingVO(tenantSystemMappingPO);
            tenantSystemMappingVOList.add(tenantSystemMappingVO);
        }

        return CommonResult.successReturn(tenantSystemMappingVOList);
    }
}
