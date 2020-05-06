package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.UserSystemMappingPO;
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
@ApiModel("用户系统映射")
public class UserSystemMappingVO extends UserSystemMappingPO {

	public UserSystemMappingVO(){}
	public UserSystemMappingVO(UserSystemMappingPO userSystemMappingPO){
		this.setId(userSystemMappingPO.getId());
		this.setUserId(userSystemMappingPO.getUserId());
		this.setSystemId(userSystemMappingPO.getSystemId());
		this.setTenantId(userSystemMappingPO.getTenantId());
		this.setOperatorId(userSystemMappingPO.getOperatorId());
		this.setCreateTime(userSystemMappingPO.getCreateTime());
	}
}


