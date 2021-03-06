package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.TenantPO;
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
@ApiModel("租户信息")
public class TenantVO extends TenantPO {

	public TenantVO(){}
	public TenantVO(TenantPO tenantPO){
		this.setId(tenantPO.getId());
		this.setName(tenantPO.getName());
		this.setPrimaryUserId(tenantPO.getPrimaryUserId());
		this.setStatus(tenantPO.getStatus());
		this.setTenantStartTime(tenantPO.getTenantStartTime());
		this.setTenantEndTime(tenantPO.getTenantEndTime());
		this.setOperatorId(tenantPO.getOperatorId());
		this.setUpdateVersion(tenantPO.getUpdateVersion());
		this.setCreateTime(tenantPO.getCreateTime());
		this.setUpdateTime(tenantPO.getUpdateTime());
	}
}


