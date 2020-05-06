package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.SystemAuthorityMappingPO;
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
@ApiModel("系统权限映射")
public class SystemAuthorityMappingVO extends SystemAuthorityMappingPO {

	public SystemAuthorityMappingVO(){}
	public SystemAuthorityMappingVO(SystemAuthorityMappingPO systemAuthorityMappingPO){
		this.setId(systemAuthorityMappingPO.getId());
		this.setSystemId(systemAuthorityMappingPO.getSystemId());
		this.setAuthorityId(systemAuthorityMappingPO.getAuthorityId());
	}
}


