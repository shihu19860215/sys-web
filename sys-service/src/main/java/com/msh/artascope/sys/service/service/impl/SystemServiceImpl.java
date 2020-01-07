package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.SystemDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.SystemPO;
import com.msh.artascope.sys.client.qo.SystemQO;
import com.msh.artascope.sys.client.vo.SystemVO;
import com.msh.artascope.sys.service.service.SystemService;
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
public class SystemServiceImpl extends BaseServiceImpl<SystemPO,SystemQO> implements SystemService {
    @Autowired
    private SystemDao systemDao;
    @Autowired
    private SystemService systemService;

    @Override
    public CommonResult update(SystemPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<SystemPO>> list(SystemQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(SystemPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<SystemPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(SystemQO param) {
        long result = systemDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<SystemVO>> listSystemVO(SystemQO param) {
        List<SystemPO> systemPOList = systemService.list(param).getResult();
        if(null == systemPOList || systemPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<SystemVO> systemVOList = new ArrayList<>(systemPOList.size());
        for(SystemPO systemPO: systemPOList){
            SystemVO systemVO = new SystemVO(systemPO);
            systemVOList.add(systemVO);
        }

        return CommonResult.successReturn(systemVOList);
    }
}
