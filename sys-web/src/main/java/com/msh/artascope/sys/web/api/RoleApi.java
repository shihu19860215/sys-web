package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.RolePO;
import com.msh.artascope.sys.client.qo.RoleQO;
import com.msh.artascope.sys.client.vo.RoleVO;
import com.msh.artascope.sys.service.service.RoleService;
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
@Api(description = "角色信息-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleApi extends BaseController<RolePO, RoleQO> {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody RolePO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return roleService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        RoleQO q = new RoleQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return roleService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        RoleQO q = new RoleQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        q.setOperatorId(userId);
        return roleService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody RolePO p) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        p.setTenantId(tenantId);
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return roleService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<RolePO> get(@RequestParam("id") Long id) {
        RoleQO q = new RoleQO();
        q.setId(id);
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return roleService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<RolePO>> list(@Validated({IList.class}) RoleQO q) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        CommonResult<List<RolePO>> query = roleService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<RoleVO>> listRoleVO(@Validated({IList.class}) @ModelAttribute("pojo")RoleQO q) {
        Long tenantId = HttpServletRequestUtil.getTenantId();
        q.setTenantId(tenantId);
        return roleService.listRoleVO(q);
    }
}
