package com.msh.artascope.sys.client.po;


import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.IInsert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("系统权限映射PO")
public class SystemAuthorityMappingPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "systemId不能为空")
	@ApiModelProperty("")
	private Long systemId;

	@NotNull(groups = IInsert.class,message = "authorityId不能为空")
	@ApiModelProperty("权限id")
	private Long authorityId;


}



