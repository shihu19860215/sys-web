package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.AuditConfigureDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.AuditConfigurePO;
import com.msh.artascope.sys.client.qo.AuditConfigureQO;
import com.msh.artascope.sys.client.vo.AuditConfigureVO;
import com.msh.artascope.sys.service.service.AuditConfigureService;
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
public class AuditConfigureServiceImpl extends BaseServiceImpl<AuditConfigurePO,AuditConfigureQO> implements AuditConfigureService {
    @Autowired
    private AuditConfigureDao auditConfigureDao;
    @Autowired
    private AuditConfigureService auditConfigureService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(AuditConfigurePO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<AuditConfigurePO>> list(AuditConfigureQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(AuditConfigurePO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<AuditConfigurePO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(AuditConfigureQO param) {
        long result = auditConfigureDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuditConfigureVO>> listAuditConfigureVO(AuditConfigureQO param) {
        List<AuditConfigurePO> auditConfigurePOList = auditConfigureService.list(param).getResult();
        if(null == auditConfigurePOList || auditConfigurePOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AuditConfigureVO> auditConfigureVOList = new ArrayList<>(auditConfigurePOList.size());
        for(AuditConfigurePO auditConfigurePO: auditConfigurePOList){
            AuditConfigureVO auditConfigureVO = new AuditConfigureVO(auditConfigurePO);
            auditConfigureVOList.add(auditConfigureVO);
        }

        return CommonResult.successReturn(auditConfigureVOList);
    }
}
