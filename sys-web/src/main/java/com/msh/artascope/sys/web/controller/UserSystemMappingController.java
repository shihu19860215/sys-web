package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.UserSystemMappingPO;
import com.msh.artascope.sys.client.qo.UserSystemMappingQO;
import com.msh.artascope.sys.service.service.UserSystemMappingService;
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
@Api(description = "用户系统映射-controller相关接口")
@RestController
@RequestMapping("/usersystemmapping")
@Slf4j
public class UserSystemMappingController extends BaseController<UserSystemMappingPO, UserSystemMappingQO> {

    @Autowired
    private UserSystemMappingService userSystemMappingService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody UserSystemMappingPO t) {
        return userSystemMappingService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "POST", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(@Validated({IDelete.class,Default.class}) @RequestBody UserSystemMappingQO q) {
        return userSystemMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "POST", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(@Validated({IDelete.class,Default.class}) @RequestBody UserSystemMappingQO q) {
        return userSystemMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody UserSystemMappingPO t) {
        return userSystemMappingService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "POST", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<UserSystemMappingPO> get(@Validated({IGet.class,Default.class}) @RequestBody UserSystemMappingQO q) {
        return userSystemMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "POST", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<UserSystemMappingPO>> list(@Validated({IList.class,Default.class}) @RequestBody UserSystemMappingQO q) {
        CommonResult<List<UserSystemMappingPO>> query = userSystemMappingService.list(q);
        return query;
    }

}
