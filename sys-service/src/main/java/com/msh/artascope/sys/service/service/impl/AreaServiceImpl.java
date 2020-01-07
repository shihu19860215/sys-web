package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.AreaDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.AreaPO;
import com.msh.artascope.sys.client.qo.AreaQO;
import com.msh.artascope.sys.client.vo.AreaVO;
import com.msh.artascope.sys.service.service.AreaService;
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
public class AreaServiceImpl extends BaseServiceImpl<AreaPO,AreaQO> implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private AreaService areaService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Override
    public CommonResult update(AreaPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<AreaPO>> list(AreaQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(AreaPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<AreaPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(AreaQO param) {
        long result = areaDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AreaVO>> listAreaVO(AreaQO param) {
        List<AreaPO> areaPOList = areaService.list(param).getResult();
        if(null == areaPOList || areaPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AreaVO> areaVOList = new ArrayList<>(areaPOList.size());
        for(AreaPO areaPO: areaPOList){
            AreaVO areaVO = new AreaVO(areaPO);
            areaVOList.add(areaVO);
        }

        return CommonResult.successReturn(areaVOList);
    }
}
