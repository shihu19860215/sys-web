package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.DemoPO;
import com.msh.artascope.sys.client.qo.DemoQO;
import com.msh.artascope.sys.client.vo.DemoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface DemoService extends BaseService<DemoPO,DemoQO> {
        CommonResult logicDelete(DemoQO param);
        CommonResult<List<DemoVO>> listDemoVO(DemoQO param);
}
