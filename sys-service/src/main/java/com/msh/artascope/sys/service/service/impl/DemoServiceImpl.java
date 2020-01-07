package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.DemoDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.DemoPO;
import com.msh.artascope.sys.client.qo.DemoQO;
import com.msh.artascope.sys.client.vo.DemoVO;
import com.msh.artascope.sys.service.service.DemoService;
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
public class DemoServiceImpl extends BaseServiceImpl<DemoPO,DemoQO> implements DemoService {
    @Autowired
    private DemoDao demoDao;
    @Autowired
    private DemoService demoService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(DemoPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<DemoPO>> list(DemoQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(DemoPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<DemoPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(DemoQO param) {
        long result = demoDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<DemoVO>> listDemoVO(DemoQO param) {
        List<DemoPO> demoPOList = demoService.list(param).getResult();
        if(null == demoPOList || demoPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<DemoVO> demoVOList = new ArrayList<>(demoPOList.size());
        for(DemoPO demoPO: demoPOList){
            DemoVO demoVO = new DemoVO(demoPO);
            demoVOList.add(demoVO);
        }

        return CommonResult.successReturn(demoVOList);
    }
}
