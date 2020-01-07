package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.SystemPO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("系统信息")
public class SystemVO extends SystemPO {

	public SystemVO(){}
	public SystemVO(SystemPO systemPO){
		this.setId(systemPO.getId());
		this.setName(systemPO.getName());
		this.setStatus(systemPO.getStatus());
		this.setOperatorId(systemPO.getOperatorId());
		this.setUpdateVersion(systemPO.getUpdateVersion());
		this.setCreateTime(systemPO.getCreateTime());
		this.setUpdateTime(systemPO.getUpdateTime());
	}
}


