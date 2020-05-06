package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.RolePO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("角色信息")
public class RoleVO extends RolePO {
	@ApiModelProperty("权限id集合")
	private Set<Long> authIds;

	public RoleVO(){}
	public RoleVO(RolePO rolePO){
		this.setId(rolePO.getId());
		this.setName(rolePO.getName());
		this.setSystemId(rolePO.getSystemId());
		this.setStatus(rolePO.getStatus());
		this.setTenantId(rolePO.getTenantId());
		this.setOperatorId(rolePO.getOperatorId());
		this.setUpdateVersion(rolePO.getUpdateVersion());
		this.setCreateTime(rolePO.getCreateTime());
		this.setUpdateTime(rolePO.getUpdateTime());
	}
}


