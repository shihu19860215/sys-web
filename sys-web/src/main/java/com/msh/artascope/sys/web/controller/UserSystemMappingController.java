package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.UserSystemMappingPO;
import com.msh.artascope.sys.client.qo.UserSystemMappingQO;
import com.msh.artascope.sys.service.service.UserSystemMappingService;
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
@Api(description = "用户系统映射-controller相关接口")
@RestController
@RequestMapping("/usersystemmapping")
@Slf4j
public class UserSystemMappingController extends BaseController<UserSystemMappingPO, UserSystemMappingQO> {

    @Autowired
    private UserSystemMappingService userSystemMappingService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody UserSystemMappingPO t) {
        return userSystemMappingService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(UserSystemMappingQO q) {
        return userSystemMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(UserSystemMappingQO q) {
        return userSystemMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody UserSystemMappingPO t) {
        return userSystemMappingService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<UserSystemMappingPO> get(UserSystemMappingQO q) {
        return userSystemMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<UserSystemMappingPO>> list(UserSystemMappingQO q) {
        CommonResult<List<UserSystemMappingPO>> query = userSystemMappingService.list(q);
        return query;
    }

}
