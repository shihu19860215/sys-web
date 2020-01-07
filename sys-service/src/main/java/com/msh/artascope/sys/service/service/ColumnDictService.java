package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.ColumnDictPO;
import com.msh.artascope.sys.client.qo.ColumnDictQO;
import com.msh.artascope.sys.client.vo.ColumnDictVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface ColumnDictService extends BaseService<ColumnDictPO,ColumnDictQO> {
        CommonResult logicDelete(ColumnDictQO param);
        CommonResult<List<ColumnDictVO>> listColumnDictVO(ColumnDictQO param);
}
