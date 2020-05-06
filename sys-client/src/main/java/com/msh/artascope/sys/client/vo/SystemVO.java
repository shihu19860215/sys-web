package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.SystemPO;
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
@ApiModel("系统信息")
public class SystemVO extends SystemPO {

	public SystemVO(){}
	public SystemVO(SystemPO systemPO){
		this.setId(systemPO.getId());
		this.setName(systemPO.getName());
		this.setStatus(systemPO.getStatus());
		this.setOperatorId(systemPO.getOperatorId());
		this.setUpdateVersion(systemPO.getUpdateVersion());
	}
}


