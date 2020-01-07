package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.AreaPO;
import com.msh.artascope.sys.client.qo.AreaQO;
import com.msh.artascope.sys.client.vo.AreaVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AreaService extends BaseService<AreaPO,AreaQO> {
        CommonResult logicDelete(AreaQO param);
        CommonResult<List<AreaVO>> listAreaVO(AreaQO param);
}
