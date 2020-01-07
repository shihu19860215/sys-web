package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.SystemPO;
import com.msh.artascope.sys.client.qo.SystemQO;
import com.msh.artascope.sys.client.vo.SystemVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface SystemService extends BaseService<SystemPO,SystemQO> {
        CommonResult logicDelete(SystemQO param);
        CommonResult<List<SystemVO>> listSystemVO(SystemQO param);
}
