package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.TenantSystemMappingPO;
import com.msh.artascope.sys.client.qo.TenantSystemMappingQO;
import com.msh.artascope.sys.client.vo.TenantSystemMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface TenantSystemMappingService extends BaseService<TenantSystemMappingPO,TenantSystemMappingQO> {
        CommonResult logicDelete(TenantSystemMappingQO param);
        CommonResult<List<TenantSystemMappingVO>> listTenantSystemMappingVO(TenantSystemMappingQO param);
}
