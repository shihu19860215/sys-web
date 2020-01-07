package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.AuditDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.AuditPO;
import com.msh.artascope.sys.client.qo.AuditQO;
import com.msh.artascope.sys.client.vo.AuditVO;
import com.msh.artascope.sys.service.service.AuditService;
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
public class AuditServiceImpl extends BaseServiceImpl<AuditPO,AuditQO> implements AuditService {
    @Autowired
    private AuditDao auditDao;
    @Autowired
    private AuditService auditService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(AuditPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<AuditPO>> list(AuditQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(AuditPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<AuditPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult<Boolean> logicDelete(AuditQO param) {
        long result = auditDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuditVO>> listAuditVO(AuditQO param) {
        List<AuditPO> auditPOList = auditService.list(param).getResult();
        if(null == auditPOList || auditPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AuditVO> auditVOList = new ArrayList<>(auditPOList.size());
        for(AuditPO auditPO: auditPOList){
            AuditVO auditVO = new AuditVO(auditPO);
            auditVOList.add(auditVO);
        }

        return CommonResult.successReturn(auditVOList);
    }
}
