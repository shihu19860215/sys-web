package com.msh.artascope.sys.web.api;

import com.msh.frame.client.common.CommonResult;
import com.msh.frame.web.base.BaseController;
import com.msh.artascope.sys.client.po.ColumnInfoPO;
import com.msh.artascope.sys.client.qo.ColumnInfoQO;
import com.msh.artascope.sys.client.vo.ColumnInfoVO;
import com.msh.artascope.sys.service.service.ColumnInfoService;
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
@Api(description = "字段详情-api相关接口")
@Slf4j
@RestController
@RequestMapping("/api/columninfo")
public class ColumnInfoApi extends BaseController<ColumnInfoPO, ColumnInfoQO> {

    @Autowired
    private ColumnInfoService columnInfoService;


    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @PostMapping("insert")
    public CommonResult insert(@RequestBody ColumnInfoPO p) {
        return columnInfoService.insert(p);
    }

    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @GetMapping("delete")
    public CommonResult delete(@RequestParam("id") Long id) {
        ColumnInfoQO q = new ColumnInfoQO();
        q.setId(id);
        return columnInfoService.delete(q);
    }

    @ApiOperation(value = "逻辑删除", httpMethod = "GET", notes = "逻辑删除")
    @GetMapping("logicdelete")
    public CommonResult logicDelete(@RequestParam("id") Long id) {
        ColumnInfoQO q = new ColumnInfoQO();
        q.setId(id);
        return columnInfoService.logicDelete(q);
    }

    @ApiOperation(value = "通用更新逻辑", httpMethod = "POST", notes = "通用更新逻辑")
    @PostMapping("update")
    public CommonResult update(@RequestBody ColumnInfoPO p) {
        return columnInfoService.update(p);
    }


    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @GetMapping("get")
    public CommonResult<ColumnInfoPO> get(@RequestParam("id") Long id) {
        ColumnInfoQO q = new ColumnInfoQO();
        q.setId(id);
        return columnInfoService.get(q);
    }

    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @GetMapping("list")
    public CommonResult<List<ColumnInfoPO>> list(ColumnInfoQO q) {
        CommonResult<List<ColumnInfoPO>> query = columnInfoService.list(q);
        return query;
    }


    @ApiOperation(value = "vo列表查询", httpMethod = "GET", notes = "vo列表查询")
    @GetMapping("listvo")
    public CommonResult<List<ColumnInfoVO>> listColumnInfoVO(@ModelAttribute("pojo")ColumnInfoQO q) {
        return columnInfoService.listColumnInfoVO(q);
    }

    @ApiOperation(value = "通过表名字段名查询", httpMethod = "GET", notes = "通过表名字段名查询")
    @GetMapping("getbytablecolumnname")
    public CommonResult<ColumnInfoVO> getColumnInfoVOByTableNameColumnName(String tableName, String columnName) {
        CommonResult<ColumnInfoVO> query = columnInfoService.getColumnInfoVO(tableName, columnName);
        return query;
    }
}
