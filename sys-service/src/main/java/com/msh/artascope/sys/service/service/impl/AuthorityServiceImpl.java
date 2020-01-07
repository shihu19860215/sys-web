package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.service.dao.AuthorityDao;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.artascope.sys.client.po.AuthorityPO;
import com.msh.artascope.sys.client.qo.AuthorityQO;
import com.msh.artascope.sys.client.vo.AuthorityVO;
import com.msh.artascope.sys.client.vo.ColumnInfoVO;
import com.msh.artascope.sys.service.service.AuthorityService;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import com.msh.artascope.sys.service.service.ColumnInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class AuthorityServiceImpl extends BaseServiceImpl<AuthorityPO,AuthorityQO> implements AuthorityService {
    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private ColumnInfoService columnInfoService;

    @Override
    public CommonResult update(AuthorityPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<AuthorityPO>> list(AuthorityQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(AuthorityPO param) {
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<AuthorityPO> param) {
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(AuthorityQO param) {
        long result = authorityDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<AuthorityVO>> listAuthorityVO(AuthorityQO param) {
        List<AuthorityPO> authorityPOList = authorityService.list(param).getResult();
        if(null == authorityPOList || authorityPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<AuthorityVO> authorityVOList = authorityPOList.stream().map(p->new AuthorityVO(p)).collect(Collectors.toList());
        this.setTypeDesc(authorityVOList);
        //只获取顶级列表
        authorityVOList = this.getLayer1ListAndSetChildren(authorityVOList);

        return CommonResult.successReturn(authorityVOList);
    }

    /**
     * 设置类型的意思
     * @param authorityVOList
     */
    private void setTypeDesc(List<AuthorityVO> authorityVOList){
        ColumnInfoVO columnInfoVO = columnInfoService.getColumnInfoVO("sys_authority","type").getResult();
        Map<Integer, String> map = new HashMap<>();
        columnInfoVO.getColumnDictPOList().stream().forEach(v->map.put(v.getValue(), v.getMeaning()));
        authorityVOList.stream().forEach(v->v.setTypeDesc(map.get(v.getType())));
    }

    /**
     * 获取一级列表并设置Children
     * @param authorityVOList
     * @return
     */
    private List<AuthorityVO> getLayer1ListAndSetChildren(List<AuthorityVO> authorityVOList){
        if(CollectionUtils.isEmpty(authorityVOList)){
            return Collections.emptyList();
        }
        Map<Long,List<AuthorityVO>> map = new HashMap<>();
        Map<Long, AuthorityVO> idMap = new HashMap<>();
        authorityVOList.stream().forEach(v->{
            idMap.put(v.getId(), v);
            List<AuthorityVO> list = map.get(v.getParentId());
            if(null == list){
                list = new LinkedList<>();
                map.put(v.getParentId(), list);
            }
            list.add(v);
        });
        List<AuthorityVO> list = map.get(0L);
        list.stream().forEach(v->childrenRecursion(v, map, idMap));
        return list;
    }

    private void childrenRecursion(AuthorityVO authorityVO, Map<Long,List<AuthorityVO>> map, Map<Long, AuthorityVO> idMap){
        AuthorityVO parentAuthorityVO = idMap.get(authorityVO.getParentId());
        if(null != parentAuthorityVO){
            authorityVO.setParentName(parentAuthorityVO.getName());
        }
        List<AuthorityVO> authorityVOList = map.get(authorityVO.getId());
        if(CollectionUtils.isEmpty(authorityVOList)){
            authorityVO.setChildren(Collections.emptyList());
            return;
        }
        authorityVO.setChildren(authorityVOList);
        authorityVOList.stream().forEach(v->childrenRecursion(v, map, idMap));
    }
}
