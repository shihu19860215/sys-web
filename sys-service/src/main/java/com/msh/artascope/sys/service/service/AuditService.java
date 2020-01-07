package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.AuditPO;
import com.msh.artascope.sys.client.qo.AuditQO;
import com.msh.artascope.sys.client.vo.AuditVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AuditService extends BaseService<AuditPO,AuditQO> {
        CommonResult logicDelete(AuditQO param);
        CommonResult<List<AuditVO>> listAuditVO(AuditQO param);
}
