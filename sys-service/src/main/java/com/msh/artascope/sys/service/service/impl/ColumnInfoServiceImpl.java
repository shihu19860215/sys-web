package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.ColumnInfoDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.ColumnDictPO;
import com.msh.artascope.sys.client.po.ColumnInfoPO;
import com.msh.artascope.sys.client.qo.ColumnDictQO;
import com.msh.artascope.sys.client.qo.ColumnInfoQO;
import com.msh.artascope.sys.client.vo.ColumnInfoVO;
import com.msh.artascope.sys.service.service.ColumnDictService;
import com.msh.artascope.sys.service.service.ColumnInfoService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class ColumnInfoServiceImpl extends BaseServiceImpl<ColumnInfoPO,ColumnInfoQO> implements ColumnInfoService {
    @Autowired
    private ColumnInfoDao columnInfoDao;
    @Autowired
    private ColumnInfoService columnInfoService;
    @Autowired
    private ColumnDictService columnDictService;

    @Override
    public CommonResult update(ColumnInfoPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<ColumnInfoPO>> list(ColumnInfoQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(ColumnInfoPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<ColumnInfoPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(ColumnInfoQO param) {
        long result = columnInfoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<ColumnInfoVO>> listColumnInfoVO(ColumnInfoQO param) {
        List<ColumnInfoPO> columnInfoPOList = columnInfoService.list(param).getResult();
        if(null == columnInfoPOList || columnInfoPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<ColumnInfoVO> columnInfoVOList = new ArrayList<>(columnInfoPOList.size());
        for(ColumnInfoPO columnInfoPO: columnInfoPOList){
            ColumnInfoVO columnInfoVO = new ColumnInfoVO(columnInfoPO);
            columnInfoVOList.add(columnInfoVO);
        }

        return CommonResult.successReturn(columnInfoVOList);
    }


    @Override
    public CommonResult<ColumnInfoVO> getColumnInfoVO(String tableName, String columnName) {
        ColumnInfoQO columnInfoQO = new ColumnInfoQO();
        columnInfoQO.setTableName(tableName);
        columnInfoQO.setColumnName(columnName);
        columnInfoQO.setPageSize(Integer.MAX_VALUE);
        CommonResult<ColumnInfoPO> columnInfoPOCommonResult = columnInfoService.listOne(columnInfoQO);
        ColumnInfoPO columnInfoPO = columnInfoPOCommonResult.getResult();
        if(null == columnInfoPO){
            return null;
        }
        ColumnInfoVO columnInfoVO = new ColumnInfoVO(columnInfoPO);
        this.setColumnInfoVOColumnDictPOList(columnInfoVO);
        return CommonResult.successReturn(columnInfoVO);
    }
    private void setColumnInfoVOColumnDictPOList(ColumnInfoVO columnInfoVO){
        Long columnInfoId = columnInfoVO.getId();
        ColumnDictQO columnDictQO = new ColumnDictQO();
        columnDictQO.setColumnId(columnInfoId);
        columnDictQO.setStatus(1);
        columnDictQO.setPageSize(Integer.MAX_VALUE);
        CommonResult<List<ColumnDictPO>> listCommonResult = columnDictService.list(columnDictQO);
        columnInfoVO.setColumnDictPOList(listCommonResult.getResult());
    }
}
