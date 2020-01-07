package com.msh.artascope.sys.web.controller;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.AuditConfigurePO;
import com.msh.artascope.sys.client.qo.AuditConfigureQO;
import com.msh.artascope.sys.service.service.AuditConfigureService;
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
@Api(description = "审计配置-controller相关接口")
@RestController
@RequestMapping("/auditconfigure")
@Slf4j
public class AuditConfigureController extends BaseController<AuditConfigurePO, AuditConfigureQO> {

    @Autowired
    private AuditConfigureService auditConfigureService;



    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody AuditConfigurePO t) {
        return auditConfigureService.insert(t);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @PostMapping("delete")
    public CommonResult delete(AuditConfigureQO q) {
        return auditConfigureService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @PostMapping("logicdelete")
    public CommonResult logicDelete(AuditConfigureQO q) {
        return auditConfigureService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody AuditConfigurePO t) {
        return auditConfigureService.update(t);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @PostMapping("get")
    public CommonResult<AuditConfigurePO> get(AuditConfigureQO q) {
        return auditConfigureService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @PostMapping("list")
    public CommonResult<List<AuditConfigurePO>> list(AuditConfigureQO q) {
        CommonResult<List<AuditConfigurePO>> query = auditConfigureService.list(q);
        return query;
    }

}
