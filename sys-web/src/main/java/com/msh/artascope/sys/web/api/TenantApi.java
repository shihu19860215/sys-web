package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.TenantPO;
import com.msh.artascope.sys.client.qo.TenantQO;
import com.msh.artascope.sys.client.vo.TenantVO;
import com.msh.artascope.sys.service.service.TenantService;
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
@Api(description = "租户信息-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/tenant")
public class TenantApi extends BaseController<TenantPO, TenantQO> {

    @Autowired
    private TenantService tenantService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody TenantPO p) {
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return tenantService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        TenantQO q = new TenantQO();
        q.setId(id);
        return tenantService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        TenantQO q = new TenantQO();
        q.setId(id);
        Long userId = HttpServletRequestUtil.getUserId();
        q.setOperatorId(userId);
        return tenantService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody TenantPO p) {
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return tenantService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<TenantPO> get(@RequestParam("id") Long id) {
        TenantQO q = new TenantQO();
        q.setId(id);
        return tenantService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<TenantPO>> list(TenantQO q) {
        CommonResult<List<TenantPO>> query = tenantService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<TenantVO>> listTenantVO(@ModelAttribute("pojo")TenantQO q) {
        return tenantService.listTenantVO(q);
    }
}