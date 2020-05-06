package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.like.client.po.CharIndexPO;
import com.msh.artascope.sys.client.po.UserPO;
import com.msh.artascope.sys.client.qo.UserQO;
import com.msh.artascope.sys.service.client.LikeClient;
import com.msh.artascope.sys.service.dao.UserSystemMappingDao;
import com.msh.artascope.sys.service.service.UserService;
import com.msh.artascope.sys.service.service.UserSystemMappingService;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.po.UserSystemMappingPO;
import com.msh.artascope.sys.client.qo.UserSystemMappingQO;
import com.msh.artascope.sys.client.vo.UserSystemMappingVO;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Service
@Slf4j
public class UserSystemMappingServiceImpl extends BaseServiceImpl<UserSystemMappingPO,UserSystemMappingQO> implements UserSystemMappingService {
    @Autowired
    private UserSystemMappingDao userSystemMappingDao;
    @Autowired
    private UserSystemMappingService userSystemMappingService;
    @Autowired
    private IdGenerateable idGenerateable;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeClient likeClient;

    @Override
    public CommonResult update(UserSystemMappingPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<UserSystemMappingPO>> list(UserSystemMappingQO param) {
        return super.list(param);
    }

    @Override
    public CommonResult insert(UserSystemMappingPO param) {
        param.setId(idGenerateable.getUniqueID());
        UserQO userQO = new UserQO();
        userQO.setId(param.getUserId());
        userQO.setTenantId(param.getTenantId());
        UserPO userPO = userService.get(userQO).getResult();
        if(null != userPO){
            CharIndexPO charIndexPO = new CharIndexPO();
            charIndexPO.setSystemId(param.getSystemId());
            charIndexPO.setTenantId(param.getTenantId());
            charIndexPO.setPrimaryKeyId(param.getUserId());
            charIndexPO.setColumnId(3L);
            charIndexPO.setFullChar(userPO.getUsername());
            likeClient.insert(charIndexPO);
        }
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<UserSystemMappingPO> param) {
        List<CharIndexPO> charIndexPOList = new LinkedList<>();
        param.stream().forEach(p->{
            p.setId(idGenerateable.getUniqueID());
            UserQO userQO = new UserQO();
            userQO.setId(p.getId());
            userQO.setTenantId(p.getTenantId());
            UserPO userPO = userService.get(userQO).getResult();
            if(null != userPO){
                CharIndexPO charIndexPO = new CharIndexPO();
                charIndexPO.setSystemId(p.getSystemId());
                charIndexPO.setTenantId(p.getTenantId());
                charIndexPO.setPrimaryKeyId(p.getUserId());
                charIndexPO.setColumnId(3L);
                charIndexPO.setFullChar(userPO.getUsername());
                charIndexPOList.add(charIndexPO);
            }
        });
        if(!CollectionUtils.isEmpty(charIndexPOList)){
            likeClient.insertCollection(charIndexPOList);
        }
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(UserSystemMappingQO param) {
        long result = userSystemMappingDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }

    @Override
    public CommonResult<List<UserSystemMappingVO>> listUserSystemMappingVO(UserSystemMappingQO param) {
        List<UserSystemMappingPO> userSystemMappingPOList = userSystemMappingService.list(param).getResult();
        if(null == userSystemMappingPOList || userSystemMappingPOList.size() == 0) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<UserSystemMappingVO> userSystemMappingVOList = new ArrayList<>(userSystemMappingPOList.size());
        for(UserSystemMappingPO userSystemMappingPO: userSystemMappingPOList){
            UserSystemMappingVO userSystemMappingVO = new UserSystemMappingVO(userSystemMappingPO);
            userSystemMappingVOList.add(userSystemMappingVO);
        }

        return CommonResult.successReturn(userSystemMappingVOList);
    }
}
