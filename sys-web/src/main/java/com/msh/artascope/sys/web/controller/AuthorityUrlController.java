package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.AuthorityUrlPO;
import com.msh.artascope.sys.client.qo.AuthorityUrlQO;
import com.msh.artascope.sys.service.service.AuthorityUrlService;
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
@Api(description = "权限url-controller相关接口")
@RestController
@RequestMapping("/authorityurl")
@Slf4j
public class AuthorityUrlController extends BaseController<AuthorityUrlPO, AuthorityUrlQO> {

    @Autowired
    private AuthorityUrlService authorityUrlService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody AuthorityUrlPO t) {
        return authorityUrlService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(AuthorityUrlQO q) {
        return authorityUrlService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(AuthorityUrlQO q) {
        return authorityUrlService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody AuthorityUrlPO t) {
        return authorityUrlService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<AuthorityUrlPO> get(AuthorityUrlQO q) {
        return authorityUrlService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<AuthorityUrlPO>> list(@RequestBody AuthorityUrlQO q) {
        CommonResult<List<AuthorityUrlPO>> query = authorityUrlService.list(q);
        return query;
    }

}
