package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.AuthorityPO;
import com.msh.artascope.sys.client.qo.AuthorityQO;
import com.msh.artascope.sys.service.service.AuthorityService;
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
@Api(description = "权限列表-controller相关接口")
@RestController
@RequestMapping("/authority")
@Slf4j
public class AuthorityController extends BaseController<AuthorityPO, AuthorityQO> {

    @Autowired
    private AuthorityService authorityService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody AuthorityPO t) {
        return authorityService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(AuthorityQO q) {
        return authorityService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(AuthorityQO q) {
        return authorityService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody AuthorityPO t) {
        return authorityService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<AuthorityPO> get(AuthorityQO q) {
        return authorityService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<AuthorityPO>> list(AuthorityQO q) {
        CommonResult<List<AuthorityPO>> query = authorityService.list(q);
        return query;
    }

}
