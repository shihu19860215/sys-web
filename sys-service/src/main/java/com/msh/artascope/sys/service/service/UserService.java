package com.msh.artascope.sys.service.service;;

import com.msh.frame.client.base.BaseService;
import com.msh.artascope.sys.client.model.UserInfo;
import com.msh.artascope.sys.client.po.UserPO;
import com.msh.artascope.sys.client.qo.UserQO;
import com.msh.artascope.sys.client.vo.UserVO;
import com.msh.frame.client.common.CommonResult;
import java.util.List;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface UserService extends BaseService<UserPO,UserQO> {
        CommonResult logicDelete(UserQO param);
        CommonResult<List<UserVO>> listUserVO(UserQO param);

        /**
         * 查询用户列表 排除主账号
         * @param param
         * @return
         */
        CommonResult<List<UserVO>> listUserVONoPrimary(UserQO param);
        CommonResult updateSysUserVO(UserVO userVO);
        CommonResult insertSysUserVO(UserVO userVO);
        CommonResult<UserInfo> getUserInfo(String username, String password);
}
