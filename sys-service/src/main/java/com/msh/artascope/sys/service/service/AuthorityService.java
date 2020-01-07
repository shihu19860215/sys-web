package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.AuthorityPO;
import com.msh.artascope.sys.client.qo.AuthorityQO;
import com.msh.artascope.sys.client.vo.AuthorityVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AuthorityService extends BaseService<AuthorityPO,AuthorityQO> {
        CommonResult logicDelete(AuthorityQO param);
        CommonResult<List<AuthorityVO>> listAuthorityVO(AuthorityQO param);
}
