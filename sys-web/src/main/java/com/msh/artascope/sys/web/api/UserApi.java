package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.UserPO;
import com.msh.artascope.sys.client.qo.UserQO;
import com.msh.artascope.sys.client.vo.UserVO;
import com.msh.artascope.sys.service.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.groups.Default;
import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Api(description = "用户信息-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApi extends BaseController<UserPO, UserQO> {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody UserPO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return userService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        UserQO q = new UserQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        UserQO q = new UserQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        q.setOperatorId(userId);
        return userService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody UserPO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return userService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<UserPO> get(@RequestParam("id") Long id) {
        UserQO q = new UserQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<UserPO>> list(@Validated({IList.class}) UserQO q) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        CommonResult<List<UserPO>> query = userService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<UserVO>> listUserVO(@Validated({IList.class}) UserQO q) {
        Long systemId = HttpServletRequestUtil.getSystemId();
        q.setSystemId(systemId);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userService.listUserVONoPrimary(q);
    }


    @ApiOperation(value = "更新用户信息", httpMethod = "POST", notes = "更新用户信息")
    @PostMapping("updateuservo")
    public CommonResult updateSysUserVO(@RequestBody UserVO v) {
        Long systemId = HttpServletRequestUtil.getSystemId();
        v.setSystemId(systemId);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        v.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        v.setOperatorId(userId);
        return userService.updateSysUserVO(v);
    }

    @ApiOperation(value = "新增用户信息", httpMethod = "POST", notes = "新增用户信息")
    @PostMapping("insertuservo")
    public CommonResult insertSysUserVO(@RequestBody UserVO v) {
        Long systemId = HttpServletRequestUtil.getSystemId();
        v.setSystemId(systemId);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        v.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        v.setOperatorId(userId);
        return userService.insertSysUserVO(v);
    }
}
