package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.TenantSystemMappingPO;
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
@ApiModel("租户系统映射")
public class TenantSystemMappingVO extends TenantSystemMappingPO {

	public TenantSystemMappingVO(){}
	public TenantSystemMappingVO(TenantSystemMappingPO tenantSystemMappingPO){
		this.setId(tenantSystemMappingPO.getId());
		this.setTenantId(tenantSystemMappingPO.getTenantId());
		this.setSystemId(tenantSystemMappingPO.getSystemId());
		this.setStatus(tenantSystemMappingPO.getStatus());
		this.setOperatorId(tenantSystemMappingPO.getOperatorId());
		this.setUpdateVersion(tenantSystemMappingPO.getUpdateVersion());
		this.setCreateTime(tenantSystemMappingPO.getCreateTime());
		this.setUpdateTime(tenantSystemMappingPO.getUpdateTime());
	}
}


