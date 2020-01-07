package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.SystemAuthorityMappingPO;
import com.msh.artascope.sys.client.qo.SystemAuthorityMappingQO;
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
@Api(description = "系统权限映射-controller相关接口")
@RestController
@RequestMapping("/systemauthoritymapping")
@Slf4j
public class SystemAuthorityMappingController extends BaseController<SystemAuthorityMappingPO, SystemAuthorityMappingQO> {

    @Autowired
    private SystemAuthorityMappingService systemAuthorityMappingService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody SystemAuthorityMappingPO t) {
        return systemAuthorityMappingService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(SystemAuthorityMappingQO q) {
        return systemAuthorityMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(SystemAuthorityMappingQO q) {
        return systemAuthorityMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody SystemAuthorityMappingPO t) {
        return systemAuthorityMappingService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<SystemAuthorityMappingPO> get(SystemAuthorityMappingQO q) {
        return systemAuthorityMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<SystemAuthorityMappingPO>> list(SystemAuthorityMappingQO q) {
        CommonResult<List<SystemAuthorityMappingPO>> query = systemAuthorityMappingService.list(q);
        return query;
    }

}
