package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.RoleAuthorityMappingPO;
import java.util.Date;
import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
		this.setTenantId(roleAuthorityMappingPO.getTenantId());
		this.setOperatorId(roleAuthorityMappingPO.getOperatorId());
		this.setCreateTime(roleAuthorityMappingPO.getCreateTime());
	}
}


