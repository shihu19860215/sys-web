package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.UserRoleMappingPO;
import com.msh.artascope.sys.client.qo.UserRoleMappingQO;
import com.msh.artascope.sys.client.vo.UserRoleMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface UserRoleMappingService extends BaseService<UserRoleMappingPO,UserRoleMappingQO> {
        CommonResult logicDelete(UserRoleMappingQO param);
        CommonResult<List<UserRoleMappingVO>> listUserRoleMappingVO(UserRoleMappingQO param);
        CommonResult deleteByRoleIds(UserRoleMappingQO param);
}
