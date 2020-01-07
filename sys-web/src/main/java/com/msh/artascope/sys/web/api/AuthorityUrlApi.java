package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.AuthorityUrlPO;
import com.msh.artascope.sys.client.qo.AuthorityUrlQO;
import com.msh.artascope.sys.client.vo.AuthorityUrlVO;
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
@Api(description = "权限url-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/authorityurl")
public class AuthorityUrlApi extends BaseController<AuthorityUrlPO, AuthorityUrlQO> {

    @Autowired
    private AuthorityUrlService authorityUrlService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody AuthorityUrlPO p) {
        return authorityUrlService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        AuthorityUrlQO q = new AuthorityUrlQO();
        q.setId(id);
        return authorityUrlService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        AuthorityUrlQO q = new AuthorityUrlQO();
        q.setId(id);
        return authorityUrlService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody AuthorityUrlPO p) {
        return authorityUrlService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<AuthorityUrlPO> get(@RequestParam("id") Long id) {
        AuthorityUrlQO q = new AuthorityUrlQO();
        q.setId(id);
        return authorityUrlService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<AuthorityUrlPO>> list(AuthorityUrlQO q) {
        CommonResult<List<AuthorityUrlPO>> query = authorityUrlService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(@ModelAttribute("pojo")AuthorityUrlQO q) {
        return authorityUrlService.listAuthorityUrlVO(q);
    }
}
