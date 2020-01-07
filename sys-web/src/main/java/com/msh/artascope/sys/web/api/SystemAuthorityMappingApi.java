package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.SystemAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.SystemAuthorityMappingQO;
import com.msh.artascope.sys.client.vo.SystemAuthorityMappingVO;
import com.msh.artascope.sys.service.service.SystemAuthorityMappingService;
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
@Api(description = "系统权限映射-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/systemauthoritymapping")
public class SystemAuthorityMappingApi extends BaseController<SystemAuthorityMappingPO, SystemAuthorityMappingQO> {

    @Autowired
    private SystemAuthorityMappingService systemAuthorityMappingService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody SystemAuthorityMappingPO p) {
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return systemAuthorityMappingService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        SystemAuthorityMappingQO q = new SystemAuthorityMappingQO();
        q.setId(id);
        return systemAuthorityMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        SystemAuthorityMappingQO q = new SystemAuthorityMappingQO();
        q.setId(id);
        Long userId = HttpServletRequestUtil.getUserId();
        q.setOperatorId(userId);
        return systemAuthorityMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody SystemAuthorityMappingPO p) {
        Long userId = HttpServletRequestUtil.getUserId();
        p.setOperatorId(userId);
        return systemAuthorityMappingService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<SystemAuthorityMappingPO> get(@RequestParam("id") Long id) {
        SystemAuthorityMappingQO q = new SystemAuthorityMappingQO();
        q.setId(id);
        return systemAuthorityMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<SystemAuthorityMappingPO>> list(SystemAuthorityMappingQO q) {
        CommonResult<List<SystemAuthorityMappingPO>> query = systemAuthorityMappingService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<SystemAuthorityMappingVO>> listSystemAuthorityMappingVO(@ModelAttribute("pojo")SystemAuthorityMappingQO q) {
        return systemAuthorityMappingService.listSystemAuthorityMappingVO(q);
    }
}
