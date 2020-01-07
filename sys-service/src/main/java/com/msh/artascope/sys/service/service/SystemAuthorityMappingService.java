package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.SystemAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.SystemAuthorityMappingQO;
import com.msh.artascope.sys.client.vo.SystemAuthorityMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface SystemAuthorityMappingService extends BaseService<SystemAuthorityMappingPO,SystemAuthorityMappingQO> {
        CommonResult logicDelete(SystemAuthorityMappingQO param);
        CommonResult<List<SystemAuthorityMappingVO>> listSystemAuthorityMappingVO(SystemAuthorityMappingQO param);
}
