package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.TenantDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.TenantPO;
import com.msh.artascope.sys.client.qo.TenantQO;
import com.msh.artascope.sys.client.vo.TenantVO;
import com.msh.artascope.sys.service.service.TenantService;
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
public class TenantServiceImpl extends BaseServiceImpl<TenantPO,TenantQO> implements TenantService {
    @Autowired
    private TenantDao tenantDao;
    @Autowired
    private TenantService tenantService;

    @Override
    public CommonResult update(TenantPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<TenantPO>> list(TenantQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(TenantPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<TenantPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(TenantQO param) {
        long result = tenantDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<TenantVO>> listTenantVO(TenantQO param) {
        List<TenantPO> tenantPOList = tenantService.list(param).getResult();
        if(null == tenantPOList || tenantPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<TenantVO> tenantVOList = new ArrayList<>(tenantPOList.size());
        for(TenantPO tenantPO: tenantPOList){
            TenantVO tenantVO = new TenantVO(tenantPO);
            tenantVOList.add(tenantVO);
        }

        return CommonResult.successReturn(tenantVOList);
    }
}
