package com.msh.artascope.sys.web.controller;

import com.msh.artascope.sys.client.model.UserInfo;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.UserPO;
import com.msh.artascope.sys.client.qo.UserQO;
import com.msh.artascope.sys.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.util.List;


/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Api(description = "用户信息-controller相关接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController<UserPO, UserQO> {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody UserPO t) {
        return userService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "POST", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(@Validated({IDelete.class,Default.class}) @RequestBody UserQO q) {
        return userService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "POST", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(@Validated({IDelete.class,Default.class}) @RequestBody UserQO q) {
        return userService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody UserPO t) {
        return userService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "POST", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<UserPO> get(@Validated({IGet.class,Default.class}) @RequestBody UserQO q) {
        return userService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "POST", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<UserPO>> list(@Validated({IList.class,Default.class}) @RequestBody UserQO q) {
        CommonResult<List<UserPO>> query = userService.list(q);
        return query;
    }



    @ApiOperation(value = "获取用户登录信息", httpMethod = "GET", notes = "获取用户登录信息")
    @RequestMapping("listuserinfo")
    public CommonResult<UserInfo> getUserInfo(
            @NotNull(message = "username不能为空")
            @Size(min = 1,max = 20, message = "username长度范围1到20")
                    String username,
            @NotNull(message = "password不能为空")
            @Size(min = 1,max = 20, message = "password长度范围1到20")
                    String password){
        return userService.getUserInfo(username, password);
    }
}
