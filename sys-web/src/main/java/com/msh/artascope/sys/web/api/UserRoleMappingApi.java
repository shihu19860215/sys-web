package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.UserRoleMappingPO;
import com.msh.artascope.sys.client.qo.UserRoleMappingQO;
import com.msh.artascope.sys.client.vo.UserRoleMappingVO;
import com.msh.artascope.sys.service.service.UserRoleMappingService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Api(description = "用户角色映射-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/userrolemapping")
public class UserRoleMappingApi extends BaseController<UserRoleMappingPO, UserRoleMappingQO> {

    @Autowired
    private UserRoleMappingService userRoleMappingService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody UserRoleMappingPO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return userRoleMappingService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        UserRoleMappingQO q = new UserRoleMappingQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userRoleMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        UserRoleMappingQO q = new UserRoleMappingQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        q.setOperatorId(userId);
        return userRoleMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody UserRoleMappingPO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return userRoleMappingService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<UserRoleMappingPO> get(@RequestParam("id") Long id) {
        UserRoleMappingQO q = new UserRoleMappingQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userRoleMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<UserRoleMappingPO>> list(UserRoleMappingQO q) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        CommonResult<List<UserRoleMappingPO>> query = userRoleMappingService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<UserRoleMappingVO>> listUserRoleMappingVO(@ModelAttribute("pojo")UserRoleMappingQO q) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return userRoleMappingService.listUserRoleMappingVO(q);
    }
}
