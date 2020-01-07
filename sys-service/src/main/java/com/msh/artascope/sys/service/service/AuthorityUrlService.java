package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.po.AuthorityUrlPO;
import com.msh.artascope.sys.client.qo.AuthorityUrlQO;
import com.msh.artascope.sys.client.vo.AuthorityUrlVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AuthorityUrlService extends BaseService<AuthorityUrlPO,AuthorityUrlQO> {
        CommonResult logicDelete(AuthorityUrlQO param);
        CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(AuthorityUrlQO param);
}
