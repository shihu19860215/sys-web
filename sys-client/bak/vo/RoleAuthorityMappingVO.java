package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.RoleAuthorityMappingPO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("角色权限映射")
public class RoleAuthorityMappingVO extends RoleAuthorityMappingPO {

	public RoleAuthorityMappingVO(){}
	public RoleAuthorityMappingVO(RoleAuthorityMappingPO roleAuthorityMappingPO){
		this.setId(roleAuthorityMappingPO.getId());
		this.setRoleId(roleAuthorityMappingPO.getRoleId());
		this.setAuthorityId(roleAuthorityMappingPO.getAuthorityId());
		this.setStatus(roleAuthorityMappingPO.getStatus());
		this.setTenantId(roleAuthorityMappingPO.getTenantId());
		this.setOperatorId(roleAuthorityMappingPO.getOperatorId());
		this.setUpdateVersion(roleAuthorityMappingPO.getUpdateVersion());
		this.setCreateTime(roleAuthorityMappingPO.getCreateTime());
		this.setUpdateTime(roleAuthorityMappingPO.getUpdateTime());
	}
}


