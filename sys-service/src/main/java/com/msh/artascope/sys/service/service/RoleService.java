package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.RolePO;
import com.msh.artascope.sys.client.qo.RoleQO;
import com.msh.artascope.sys.client.vo.RoleVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface RoleService extends BaseService<RolePO,RoleQO> {
        CommonResult logicDelete(RoleQO param);
        CommonResult<List<RoleVO>> listRoleVO(RoleQO param);
}
