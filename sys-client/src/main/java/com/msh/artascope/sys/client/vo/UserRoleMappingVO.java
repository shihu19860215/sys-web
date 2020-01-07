package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.UserRoleMappingPO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("用户角色映射")
public class UserRoleMappingVO extends UserRoleMappingPO {

	public UserRoleMappingVO(){}
	public UserRoleMappingVO(UserRoleMappingPO userRoleMappingPO){
		this.setId(userRoleMappingPO.getId());
		this.setUserId(userRoleMappingPO.getUserId());
		this.setRoleId(userRoleMappingPO.getRoleId());
		this.setSystemId(userRoleMappingPO.getSystemId());
		this.setStatus(userRoleMappingPO.getStatus());
		this.setTenantId(userRoleMappingPO.getTenantId());
		this.setOperatorId(userRoleMappingPO.getOperatorId());
		this.setUpdateVersion(userRoleMappingPO.getUpdateVersion());
		this.setCreateTime(userRoleMappingPO.getCreateTime());
		this.setUpdateTime(userRoleMappingPO.getUpdateTime());
	}
}


