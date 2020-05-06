package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.UserRoleMappingPO;
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
@ApiModel("用户角色映射")
public class UserRoleMappingVO extends UserRoleMappingPO {

	public UserRoleMappingVO(){}
	public UserRoleMappingVO(UserRoleMappingPO userRoleMappingPO){
		this.setId(userRoleMappingPO.getId());
		this.setUserId(userRoleMappingPO.getUserId());
		this.setRoleId(userRoleMappingPO.getRoleId());
		this.setTenantId(userRoleMappingPO.getTenantId());
		this.setOperatorId(userRoleMappingPO.getOperatorId());
		this.setCreateTime(userRoleMappingPO.getCreateTime());
	}
}


