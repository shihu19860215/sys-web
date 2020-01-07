package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.RoleAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.RoleAuthorityMappingQO;
import com.msh.artascope.sys.client.vo.RoleAuthorityMappingVO;
import com.msh.frame.client.common.CommonResult;
import com.msh.artascope.sys.client.vo.RoleVO;

import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface RoleAuthorityMappingService extends BaseService<RoleAuthorityMappingPO,RoleAuthorityMappingQO> {
        CommonResult logicDelete(RoleAuthorityMappingQO param);
        CommonResult<List<RoleAuthorityMappingVO>> listRoleAuthorityMappingVO(RoleAuthorityMappingQO param);
        CommonResult updateRoleAuth(RoleVO roleVO);
        CommonResult deleteByAuthorityIds(RoleAuthorityMappingQO param);
}
