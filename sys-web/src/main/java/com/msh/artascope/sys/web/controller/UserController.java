package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.model.UserInfo;
import com.msh.artascope.sys.client.po.UserPO;
import com.msh.artascope.sys.client.qo.UserQO;
import com.msh.artascope.sys.service.service.UserService;
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
@Api(description = "用户信息-controller相关接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController<UserPO, UserQO> {

    @Autowired
    private UserService userService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody UserPO t) {
        return userService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(UserQO q) {
        return userService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(UserQO q) {
        return userService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody UserPO t) {
        return userService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<UserPO> get(UserQO q) {
        return userService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<UserPO>> list(UserQO q) {
        CommonResult<List<UserPO>> query = userService.list(q);
        return query;
    }


    @ApiOperation(value = "获取用户登录信息", httpMethod = "GET", notes = "获取用户登录信息")
    @RequestMapping("listuserinfo")
    public CommonResult<UserInfo> getUserInfo(@RequestParam("username")String username, @RequestParam("password")String password){
        return userService.getUserInfo(username, password);
    }
}
