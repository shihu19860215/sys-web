package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.AuditConfigurePO;
import com.msh.artascope.sys.client.qo.AuditConfigureQO;
import com.msh.artascope.sys.client.vo.AuditConfigureVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AuditConfigureService extends BaseService<AuditConfigurePO,AuditConfigureQO> {
        CommonResult logicDelete(AuditConfigureQO param);
        CommonResult<List<AuditConfigureVO>> listAuditConfigureVO(AuditConfigureQO param);
}
