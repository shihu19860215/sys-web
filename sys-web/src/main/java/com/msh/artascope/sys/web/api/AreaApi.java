package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.validation.*;
import com.msh.frame.web.base.BaseController;
import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.client.po.AreaPO;
import com.msh.artascope.sys.client.qo.AreaQO;
import com.msh.artascope.sys.client.vo.AreaVO;
import com.msh.artascope.sys.service.service.AreaService;
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
@Api(description = "行政区域规划码-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/area")
public class AreaApi extends BaseController<AreaPO, AreaQO> {

    @Autowired
    private AreaService areaService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@Validated({IInsert.class,Default.class}) @RequestBody AreaPO p) {
        return areaService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        AreaQO q = new AreaQO();
        q.setId(id);
        return areaService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        AreaQO q = new AreaQO();
        q.setId(id);
        return areaService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@Validated({IUpdate.class,Default.class}) @RequestBody AreaPO p) {
        return areaService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<AreaPO> get(@RequestParam("id") Long id) {
        AreaQO q = new AreaQO();
        q.setId(id);
        return areaService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<AreaPO>> list(@Validated({IList.class}) AreaQO q) {
        CommonResult<List<AreaPO>> query = areaService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<AreaVO>> listAreaVO(@Validated({IList.class}) AreaQO q) {
        return areaService.listAreaVO(q);
    }
}
