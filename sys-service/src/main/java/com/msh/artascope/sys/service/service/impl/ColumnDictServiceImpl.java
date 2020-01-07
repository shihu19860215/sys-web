package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.ColumnDictDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.ColumnDictPO;
import com.msh.artascope.sys.client.qo.ColumnDictQO;
import com.msh.artascope.sys.client.vo.ColumnDictVO;
import com.msh.artascope.sys.service.service.ColumnDictService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class ColumnDictServiceImpl extends BaseServiceImpl<ColumnDictPO,ColumnDictQO> implements ColumnDictService {
    @Autowired
    private ColumnDictDao columnDictDao;
    @Autowired
    private ColumnDictService columnDictService;

    @Override
    public CommonResult update(ColumnDictPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<ColumnDictPO>> list(ColumnDictQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(ColumnDictPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<ColumnDictPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(ColumnDictQO param) {
        long result = columnDictDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<ColumnDictVO>> listColumnDictVO(ColumnDictQO param) {
        List<ColumnDictPO> columnDictPOList = columnDictService.list(param).getResult();
        if(null == columnDictPOList || columnDictPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<ColumnDictVO> columnDictVOList = columnDictPOList.stream().map(p->new ColumnDictVO(p)).collect(Collectors.toList());
        return CommonResult.successReturn(columnDictVOList);
    }
}
