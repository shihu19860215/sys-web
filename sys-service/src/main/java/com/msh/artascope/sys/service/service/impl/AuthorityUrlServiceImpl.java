package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.AuthorityUrlDao;
import com.msh.artascope.sys.service.service.AuthorityUrlService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.AuthorityUrlPO;
import com.msh.artascope.sys.client.qo.AuthorityUrlQO;
import com.msh.artascope.sys.client.vo.AuthorityUrlVO;
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
public class AuthorityUrlServiceImpl extends BaseServiceImpl<AuthorityUrlPO,AuthorityUrlQO> implements AuthorityUrlService {
    @Autowired
    private AuthorityUrlDao authorityUrlDao;
    @Autowired
    private AuthorityUrlService authorityUrlService;

    @Override
    public CommonResult update(AuthorityUrlPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<AuthorityUrlPO>> list(AuthorityUrlQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(AuthorityUrlPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<AuthorityUrlPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(AuthorityUrlQO param) {
        long result = authorityUrlDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuthorityUrlVO>> listAuthorityUrlVO(AuthorityUrlQO param) {
        List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(param).getResult();
        if(null == authorityUrlPOList || authorityUrlPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AuthorityUrlVO> authorityUrlVOList = new ArrayList<>(authorityUrlPOList.size());
        for(AuthorityUrlPO authorityUrlPO: authorityUrlPOList){
            AuthorityUrlVO authorityUrlVO = new AuthorityUrlVO(authorityUrlPO);
            authorityUrlVOList.add(authorityUrlVO);
        }

        return CommonResult.successReturn(authorityUrlVOList);
    }
}
