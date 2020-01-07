package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.UserSystemMappingPO;
import com.msh.artascope.sys.client.qo.UserSystemMappingQO;
import com.msh.artascope.sys.client.vo.UserSystemMappingVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface UserSystemMappingService extends BaseService<UserSystemMappingPO,UserSystemMappingQO> {
        CommonResult logicDelete(UserSystemMappingQO param);
        CommonResult<List<UserSystemMappingVO>> listUserSystemMappingVO(UserSystemMappingQO param);
}
