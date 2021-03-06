package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.SystemAuthorityMappingPO;
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
@ApiModel("系统权限映射")
public class SystemAuthorityMappingVO extends SystemAuthorityMappingPO {

	public SystemAuthorityMappingVO(){}
	public SystemAuthorityMappingVO(SystemAuthorityMappingPO systemAuthorityMappingPO){
		this.setId(systemAuthorityMappingPO.getId());
		this.setSystemId(systemAuthorityMappingPO.getSystemId());
		this.setAuthorityId(systemAuthorityMappingPO.getAuthorityId());
		this.setStatus(systemAuthorityMappingPO.getStatus());
		this.setOperatorId(systemAuthorityMappingPO.getOperatorId());
		this.setUpdateVersion(systemAuthorityMappingPO.getUpdateVersion());
		this.setCreateTime(systemAuthorityMappingPO.getCreateTime());
		this.setUpdateTime(systemAuthorityMappingPO.getUpdateTime());
	}
}


