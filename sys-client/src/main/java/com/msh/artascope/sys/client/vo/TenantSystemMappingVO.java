package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.TenantSystemMappingPO;
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
@ApiModel("租户系统映射")
public class TenantSystemMappingVO extends TenantSystemMappingPO {

	public TenantSystemMappingVO(){}
	public TenantSystemMappingVO(TenantSystemMappingPO tenantSystemMappingPO){
		this.setId(tenantSystemMappingPO.getId());
		this.setTenantId(tenantSystemMappingPO.getTenantId());
		this.setSystemId(tenantSystemMappingPO.getSystemId());
		this.setOperatorId(tenantSystemMappingPO.getOperatorId());
		this.setCreateTime(tenantSystemMappingPO.getCreateTime());
	}
}


