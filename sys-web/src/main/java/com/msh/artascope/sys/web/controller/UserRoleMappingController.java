package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.UserRoleMappingPO;
import com.msh.artascope.sys.client.qo.UserRoleMappingQO;
import com.msh.artascope.sys.service.service.UserRoleMappingService;
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
@Api(description = "用户角色映射-controller相关接口")
@RestController
@RequestMapping("/userrolemapping")
@Slf4j
public class UserRoleMappingController extends BaseController<UserRoleMappingPO, UserRoleMappingQO> {

    @Autowired
    private UserRoleMappingService userRoleMappingService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody UserRoleMappingPO t) {
        return userRoleMappingService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "POST", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(@Validated({IDelete.class,Default.class}) @RequestBody UserRoleMappingQO q) {
        return userRoleMappingService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "POST", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(@Validated({IDelete.class,Default.class}) @RequestBody UserRoleMappingQO q) {
        return userRoleMappingService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody UserRoleMappingPO t) {
        return userRoleMappingService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "POST", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<UserRoleMappingPO> get(@Validated({IGet.class,Default.class}) @RequestBody UserRoleMappingQO q) {
        return userRoleMappingService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "POST", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<UserRoleMappingPO>> list(@Validated({IList.class,Default.class}) @RequestBody UserRoleMappingQO q) {
        CommonResult<List<UserRoleMappingPO>> query = userRoleMappingService.list(q);
        return query;
    }

}
