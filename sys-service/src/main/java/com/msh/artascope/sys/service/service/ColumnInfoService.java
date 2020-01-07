package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.ColumnInfoPO;
import com.msh.artascope.sys.client.qo.ColumnInfoQO;
import com.msh.artascope.sys.client.vo.ColumnInfoVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface ColumnInfoService extends BaseService<ColumnInfoPO,ColumnInfoQO> {
        CommonResult logicDelete(ColumnInfoQO param);
        CommonResult<List<ColumnInfoVO>> listColumnInfoVO(ColumnInfoQO param);
        public CommonResult<ColumnInfoVO> getColumnInfoVO(String tableName, String columnName);
}
