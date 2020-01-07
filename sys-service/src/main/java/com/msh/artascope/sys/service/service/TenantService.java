package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.TenantPO;
import com.msh.artascope.sys.client.qo.TenantQO;
import com.msh.artascope.sys.client.vo.TenantVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface TenantService extends BaseService<TenantPO,TenantQO> {
        CommonResult logicDelete(TenantQO param);
        CommonResult<List<TenantVO>> listTenantVO(TenantQO param);
}
