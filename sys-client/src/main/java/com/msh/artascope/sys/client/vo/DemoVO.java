package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.DemoPO;
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
@ApiModel("demo")
public class DemoVO extends DemoPO {

	public DemoVO(){}
	public DemoVO(DemoPO demoPO){
		this.setId(demoPO.getId());
		this.setStatus(demoPO.getStatus());
		this.setTenantId(demoPO.getTenantId());
		this.setOperatorId(demoPO.getOperatorId());
		this.setUpdateVersion(demoPO.getUpdateVersion());
		this.setCreateTime(demoPO.getCreateTime());
		this.setUpdateTime(demoPO.getUpdateTime());
	}
}


