package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.UserPO;
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
@ApiModel("用户信息")
public class UserVO extends UserPO {
	@ApiModelProperty("权限id")
	private Set<Long> roleIds;

	@ApiModelProperty("使用系统id")
	private Long SystemId;

	public UserVO(){}
	public UserVO(UserPO userPO){
		this.setId(userPO.getId());
		this.setUsername(userPO.getUsername());
		this.setPassword(userPO.getPassword());
		this.setTel(userPO.getTel());
		this.setNickname(userPO.getNickname());
		this.setStatus(userPO.getStatus());
		this.setTenantId(userPO.getTenantId());
		this.setOperatorId(userPO.getOperatorId());
		this.setUpdateVersion(userPO.getUpdateVersion());
		this.setCreateTime(userPO.getCreateTime());
		this.setUpdateTime(userPO.getUpdateTime());
	}
}


