package com.msh.artascope.sys.service.service.impl;;

import com.msh.artascope.sys.client.po.*;
import com.msh.artascope.sys.client.qo.*;
import com.msh.artascope.sys.client.vo.SystemAuthorityMappingVO;
import com.msh.artascope.sys.client.vo.TenantSystemMappingVO;
import com.msh.artascope.sys.service.dao.UserDao;
import com.msh.artascope.sys.service.define.CommonCodeDef;
import com.msh.artascope.sys.service.service.*;
import com.msh.frame.client.base.BaseServiceImpl;
import com.msh.frame.client.exception.ServiceRuntimeException;
import com.msh.frame.interfaces.ICache;
import com.msh.frame.interfaces.IdGenerateable;
import com.msh.artascope.sys.client.enums.UserInfoTypeEnum;
import com.msh.artascope.sys.client.model.UserInfo;
import com.msh.artascope.sys.client.vo.UserVO;
import com.msh.artascope.sys.service.service.*;
import com.msh.frame.client.common.CommonResult;
import com.msh.frame.client.common.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@SuppressWarnings({"ALL", "AlibabaTransactionMustHaveRollback"})
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserPO,UserQO> implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleMappingService userRoleMappingService;
    @Autowired
    private AuthorityUrlService authorityUrlService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private RoleAuthorityMappingService roleAuthorityMappingService;
    @Autowired
    private TenantService tenantService;
    @Autowired
    private TenantSystemMappingService tenantSystemMappingService;
    @Autowired
    private UserSystemMappingService userSystemMappingService;
    @Autowired
    private SystemAuthorityMappingService systemAuthorityMappingService;
    @Autowired
    private IdGenerateable idGenerateable;
    @Autowired
    @Qualifier("userSystemCache")
    private ICache<Long,Long> userSystemCache;

    @Override
    public CommonResult update(UserPO param) {
        return super.update(param);
    }

    @Override
    public CommonResult<List<UserPO>> list(UserQO param) {
        if(null == param.getStatus()){
            param.setEgtStatus(0);
        }
        return super.list(param);
    }

    @Override
    public CommonResult insert(UserPO param) {
        param.setId(idGenerateable.getUniqueID());
        return super.insert(param);
    }

    @Override
    public CommonResult insertCollection(Collection<UserPO> param) {
        param.stream().forEach(p->p.setId(idGenerateable.getUniqueID()));
        return super.insertCollection(param);
    }

    @Override
    public CommonResult logicDelete(UserQO param) {
        long result = userDao.logicDelete(param);
        if (result == 0L) {
            return CommonResult.errorReturn(CommonCode.PARAM_NOT_MATCHING);
        } else {
            return CommonResult.successReturn(true);
        }
    }


    @Override
    public CommonResult<List<UserVO>> listUserVONoPrimary(UserQO param) {
        Long tenantId = param.getTenantId();
        if(null != tenantId){
            TenantQO tenantQO = new TenantQO();
            tenantQO.setId(tenantId);
            TenantPO tenantPO = tenantService.get(tenantQO).getResult();
            if(null != tenantPO){
                param.setNeqId(tenantPO.getPrimaryUserId());
            }
        }
        return this.listUserVO(param);
    }

    @Override
    public CommonResult<List<UserVO>> listUserVO(UserQO param) {
        List<UserPO> userPOList = userService.list(param).getResult();
        if(CollectionUtils.isEmpty(userPOList)) {
            return CommonResult.successReturn(Collections.emptyList());
        }
        List<UserVO> userVOList = userPOList.stream()
                .map((UserPO p)->new UserVO(p))
                .collect(Collectors.toList());
        this.setRoles(userVOList, param);
        return CommonResult.successReturn(userVOList);
    }



    private void setRoles(List<UserVO> userVOList, UserQO param){
        Map<Long,Set<Long>> map = new HashMap<>();
        if(!CollectionUtils.isEmpty(userVOList)){
            Set<Long> userIdSet = userVOList.stream().map(v->v.getId()).collect(Collectors.toSet());
            UserRoleMappingQO userRoleMappingQO = new UserRoleMappingQO();
            userRoleMappingQO.setTenantId(param.getTenantId());
            userRoleMappingQO.setInUserIds(userIdSet);
            userRoleMappingQO.setSystemId(param.getSystemId());
            List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(userRoleMappingQO).getResult();
            if(!CollectionUtils.isEmpty(userRoleMappingPOList)){
                userRoleMappingPOList.stream().forEach(p->{
                    Set<Long> longs = map.get(p.getUserId());
                    if(CollectionUtils.isEmpty(longs)){
                        longs = new HashSet<>();
                        map.put(p.getUserId(), longs);
                    }
                    longs.add(p.getRoleId());
                });
            }
            userVOList.stream().forEach(v->{
                Set<Long> longs = map.get(v.getId());
                if(CollectionUtils.isEmpty(longs)){
                    v.setRoleIds(Collections.emptySet());
                }else {
                    v.setRoleIds(longs);
                }
            });
        }
    }

    @SuppressWarnings("AlibabaTransactionMustHaveRollback")
    @Override
    @Transactional
    public CommonResult updateSysUserVO(UserVO userVO) {
        UserRoleMappingQO userRoleMappingQO = new UserRoleMappingQO();
        userRoleMappingQO.setTenantId(userVO.getTenantId());
        userRoleMappingQO.setUserId(userVO.getId());
        CommonResult<List<UserRoleMappingPO>> sysUserRoleMappingQOListCommonResult = userRoleMappingService.list(userRoleMappingQO);
        List<UserRoleMappingPO> sysUserRoleMappingPOList = sysUserRoleMappingQOListCommonResult.getResult();

        Set<Long> dbRoleIds;
        if(CollectionUtils.isEmpty(sysUserRoleMappingPOList)){
            dbRoleIds = Collections.emptySet();
        }else {
            dbRoleIds = new HashSet<>();
            sysUserRoleMappingPOList.stream().forEach(p->{
                dbRoleIds.add(p.getRoleId());
            });
        }
        Set<Long> newRoleIds = userVO.getRoleIds();
        if(null == newRoleIds){
            newRoleIds = Collections.emptySet();
        }
        if(!dbRoleIds.isEmpty() && !newRoleIds.isEmpty()){
            dbRoleIds.removeAll(newRoleIds);
            newRoleIds.removeAll(dbRoleIds);
        }

        if(!dbRoleIds.isEmpty()){
            UserRoleMappingQO delUserRoleMappingQO = new UserRoleMappingQO();
            delUserRoleMappingQO.setTenantId(userVO.getTenantId());
            delUserRoleMappingQO.setInRoleIds(dbRoleIds);
            userRoleMappingService.deleteByRoleIds(delUserRoleMappingQO);
        }
        if(!newRoleIds.isEmpty()){
            userRoleMappingService.insertCollection(
                    newRoleIds.stream().map(l->{
                        UserRoleMappingPO sysUserRoleMappingPO = new UserRoleMappingPO();
                        sysUserRoleMappingPO.setUserId(userVO.getId());
                        sysUserRoleMappingPO.setSystemId(userVO.getSystemId());
                        sysUserRoleMappingPO.setRoleId(l);
                        return sysUserRoleMappingPO;
                    }).collect(Collectors.toSet())
            );
            userService.update(userVO);
        }
        return CommonResult.successReturn();
    }

    @Override
    @Transactional
    public CommonResult insertSysUserVO(UserVO userVO) {
        userVO.setPassword("123456");
        CommonResult result = this.insert(userVO);
        Set<Long> newRoleIds = userVO.getRoleIds();
        if(!CollectionUtils.isEmpty(newRoleIds)){
            userRoleMappingService.insertCollection(
                    newRoleIds.stream().map(l->{
                        UserRoleMappingPO sysUserRoleMappingPO = new UserRoleMappingPO();
                        sysUserRoleMappingPO.setUserId(userVO.getId());
                        sysUserRoleMappingPO.setRoleId(l);
                        sysUserRoleMappingPO.setSystemId(userVO.getSystemId());
                        return sysUserRoleMappingPO;
                    }).collect(Collectors.toSet())
            );
        }
        return result;
    }


    @Override
    public CommonResult<UserInfo> getUserInfo(String username, String password) {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return CommonResult.errorReturn(CommonCodeDef.USERNAME_PASSWORD_ERROR);
        }
        UserQO userQO = new UserQO();
        userQO.setUsername(username);
        UserPO userPO = userService.listOne(userQO).getResult();
        if(null == userPO){
            return CommonResult.errorReturn(CommonCodeDef.NO_USER);
        }
        if(!userPO.getPassword().equals(password)){
            return CommonResult.errorReturn(CommonCodeDef.PASSWORD_ERROR);
        }
        if(0 == userPO.getStatus()){
            return CommonResult.errorReturn(CommonCodeDef.USER_DISABLE);
        }

        UserInfo userInfo = new UserInfo(userPO);
        this.setUserInfoType(userInfo);
        this.setUserInfoSystemId(userInfo);
        Set<Long> authIds = this.getAuthIds(userInfo);
        userInfo.setAuthIds(authIds);
        Set<String> authUrls = this.getAuthUrls(authIds);
        userInfo.setAuthUrls(authUrls);
        userInfo.setMenuList(this.getUserInfoAuthorityList(authIds));

        return CommonResult.successReturn(userInfo);
    }

    /**
     * 设置用户当期使用的系统id
     * @param userInfo
     */
    private void setUserInfoSystemId(UserInfo userInfo){
        Long userId = userInfo.getUserId();
        Long systemId= userSystemCache.get(userId);
        if(null != systemId){
            userInfo.setSystemId(systemId);
            return;
        }
        if(UserInfoTypeEnum.PRIMARY.getCode().equals(userInfo.getType())){
            TenantSystemMappingQO tenantSystemMappingQO = new TenantSystemMappingQO();
            tenantSystemMappingQO.setTenantId(userInfo.getTenantId());
            tenantSystemMappingQO.setPageSize(1);
            TenantSystemMappingPO tenantSystemMappingPO = tenantSystemMappingService.listOne(tenantSystemMappingQO).getResult();
            if(null == tenantSystemMappingPO){
                throw new ServiceRuntimeException(CommonResult.errorReturn(CommonCodeDef.NO_SYSTEM));
            }
            systemId = tenantSystemMappingPO.getSystemId();
            userInfo.setSystemId(systemId);
            userSystemCache.put(userId, systemId);
            return;
        }
        if(UserInfoTypeEnum.GENERAL.getCode().equals(userInfo.getType())){
            UserSystemMappingQO userSystemMappingQO = new UserSystemMappingQO();
            userSystemMappingQO.setUserId(userId);
            userSystemMappingQO.setTenantId(userInfo.getTenantId());
            UserSystemMappingPO userSystemMappingPO = userSystemMappingService.listOne(userSystemMappingQO).getResult();
            if(null == userSystemMappingPO){
                throw new ServiceRuntimeException(CommonResult.errorReturn(CommonCodeDef.NO_SYSTEM));
            }
            systemId = userSystemMappingPO.getSystemId();
            userInfo.setSystemId(systemId);
            userSystemCache.put(userId, systemId);
            return;
        }
    }

    /**
     * 设置当前用户账号类型
     * @param userInfo
     */
    private void setUserInfoType(UserInfo userInfo){
        Long userId = userInfo.getUserId();
        if(userId == 1){
            userInfo.setType(UserInfoTypeEnum.SUPER_ADMIN.getCode());
            return;
        }
        Long tenantId = userInfo.getTenantId();
        if(null != tenantId){
            TenantQO tenantQO = new TenantQO();
            tenantQO.setId(tenantId);
            TenantPO tenantPO = tenantService.get(tenantQO).getResult();
            if(null != tenantPO && userInfo.getUserId().equals(tenantPO.getPrimaryUserId())){
                userInfo.setType(UserInfoTypeEnum.PRIMARY.getCode());
                return;
            }
        }
        userInfo.setType(UserInfoTypeEnum.GENERAL.getCode());
        return;
    }

    /**
     * 获取拥有权限id 的 Set
     * @param userInfo
     * @return
     */
    private Set<Long> getAuthIds(UserInfo userInfo){
        if(UserInfoTypeEnum.GENERAL.getCode().equals(userInfo.getType())){
            UserRoleMappingQO userRoleMappingQO = new UserRoleMappingQO();
            userRoleMappingQO.setUserId(userInfo.getUserId());
            userRoleMappingQO.setTenantId(userInfo.getTenantId());
            userRoleMappingQO.setPageSize(Integer.MAX_VALUE);
            List<UserRoleMappingPO> userRoleMappingPOList = userRoleMappingService.list(userRoleMappingQO).getResult();
            if(!CollectionUtils.isEmpty(userRoleMappingPOList)){
                Set<Long> roleIds = userRoleMappingPOList.stream()
                        .map(p->p.getRoleId()).collect(Collectors.toSet());

                RoleQO roleQO = new RoleQO();
                roleQO.setTenantId(userInfo.getTenantId());
                roleQO.setInIds(roleIds);
                roleQO.setStatus(1);
                roleQO.setPageSize(Integer.MAX_VALUE);
                List<RolePO> rolePOList = roleService.list(roleQO).getResult();
                if(!CollectionUtils.isEmpty(rolePOList)){
                    roleIds = rolePOList.stream()
                            .map(p->p.getId()).collect(Collectors.toSet());

                    RoleAuthorityMappingQO roleAuthorityMappingQO = new RoleAuthorityMappingQO();
                    roleAuthorityMappingQO.setTenantId(userInfo.getTenantId());
                    roleAuthorityMappingQO.setInRoleIds(roleIds);
                    roleAuthorityMappingQO.setPageSize(Integer.MAX_VALUE);
                    List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(roleAuthorityMappingQO).getResult();
                    if(!CollectionUtils.isEmpty(roleAuthorityMappingPOList)){
                        return roleAuthorityMappingPOList.stream()
                                .map(p-> p.getAuthorityId()).collect(Collectors.toSet());

                    }
                }
            }
        }
        //租户主账号
        if(UserInfoTypeEnum.PRIMARY.getCode().equals(userInfo.getType())){
            Long systemId = userInfo.getSystemId();
            SystemAuthorityMappingQO systemAuthorityMappingQO = new SystemAuthorityMappingQO();
            systemAuthorityMappingQO.setSystemId(systemId);
            systemAuthorityMappingQO.setPageSize(Integer.MAX_VALUE);
            List<SystemAuthorityMappingPO> systemAuthorityMappingPOList = systemAuthorityMappingService.list(systemAuthorityMappingQO).getResult();
            if(CollectionUtils.isEmpty(systemAuthorityMappingPOList)){
                return Collections.emptySet();
            }
            return systemAuthorityMappingPOList.stream().map(p->p.getAuthorityId()).collect(Collectors.toSet());
        }
        //如果是超级管理员 获取所有权限
        if(UserInfoTypeEnum.SUPER_ADMIN.getCode().equals(userInfo.getType())){
            return getAdminAuthIds(userInfo);
        }
        return Collections.emptySet();
    }

    /**
     * 获取拥有权限URL 的  set
     * @param authIds
     * @return
     */
    private Set<String> getAuthUrls(Set<Long> authIds){
        if(!CollectionUtils.isEmpty(authIds)){
            AuthorityUrlQO authorityUrlQO = new AuthorityUrlQO();
            authorityUrlQO.setInAuthIds(authIds);
            authorityUrlQO.setPageSize(Integer.MAX_VALUE);
            List<AuthorityUrlPO> authorityUrlPOList = authorityUrlService.list(authorityUrlQO).getResult();
            if(!CollectionUtils.isEmpty(authorityUrlPOList)){
                return authorityUrlPOList.stream().map(p->p.getUrl()).collect(Collectors.toSet());
            }
        }
        return Collections.emptySet();
    }

    /**
     * 获取权限VO 列表
     * @param authIds
     * @return
     */
    private List<UserInfo.Authority> getUserInfoAuthorityList(Set<Long> authIds){
        if(CollectionUtils.isEmpty(authIds)){
            return Collections.emptyList();
        }
        AuthorityQO authorityQO = new AuthorityQO();
        authorityQO.setType(1);
        authorityQO.setInIds(authIds);
        authorityQO.setPageSize(Integer.MAX_VALUE);
        List<AuthorityPO> authorityPOList = authorityService.list(authorityQO).getResult();
        return this.getLayer1ListAndSetChildren(authorityPOList);
    }
    /**
     * 获取一级列表树结构信息
     * @param authorityVOList
     * @return
     */
    private List<UserInfo.Authority> getLayer1ListAndSetChildren(List<AuthorityPO> authorityPOList){
        if(CollectionUtils.isEmpty(authorityPOList)){
            return Collections.emptyList();
        }
        Map<Long,List<UserInfo.Authority>> parentIdAuthorityListMap = new HashMap<>();
        Map<Long, AuthorityPO> idMap = new HashMap<>();
        authorityPOList.stream().forEach(p->{
            idMap.put(p.getId(), p);
            List<UserInfo.Authority> list = parentIdAuthorityListMap.get(p.getParentId());
            if(null == list){
                list = new LinkedList<>();
                parentIdAuthorityListMap.put(p.getParentId(), list);
            }
            list.add(new UserInfo.Authority(p));
        });
        List<UserInfo.Authority> list = parentIdAuthorityListMap.get(0L);
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        list.stream().forEach(a->childrenRecursion(a, parentIdAuthorityListMap, idMap));
        return list;
    }

    /**
     * 递归设置children
     * @param authorityVO
     * @param map
     * @param idMap
     */
    private void childrenRecursion(UserInfo.Authority authority, Map<Long,List<UserInfo.Authority>> parentIdAuthorityListMap, Map<Long, AuthorityPO> idMap){
        List<UserInfo.Authority> authorityList = parentIdAuthorityListMap.get(authority.getId());
        if(CollectionUtils.isEmpty(authorityList)){
            authority.setChildren(Collections.emptyList());
            return;
        }
        authority.setChildren(authorityList);
        authorityList.stream().forEach(a->childrenRecursion(a, parentIdAuthorityListMap, idMap));
    }


    /**
     * 获取超级管理员账号所有权限
     * @param userInfo
     * @return
     */
    private Set<Long> getAdminAuthIds(UserInfo userInfo){
        RoleAuthorityMappingQO roleAuthorityMappingQO = new RoleAuthorityMappingQO();
        roleAuthorityMappingQO.setPageSize(Integer.MAX_VALUE);
        List<RoleAuthorityMappingPO> roleAuthorityMappingPOList = roleAuthorityMappingService.list(roleAuthorityMappingQO).getResult();
        if(!CollectionUtils.isEmpty(roleAuthorityMappingPOList)){
            return roleAuthorityMappingPOList.stream().map(p->p.getAuthorityId()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
