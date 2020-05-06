package com.msh.artascope.sys.client.back.po;


import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.IInsert;
import com.msh.frame.client.validation.IUpdate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("角色信息PO")
public class RolePO extends BasePO{
	@NotNull(groups = IInsert.class,message = "name不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 10, message = "name长度范围1到10"),
		@Size(groups = IUpdate.class,min = 1,max = 10, message = "name长度范围1到10")
	})
	@ApiModelProperty("角色名")
	private String name;

	@NotNull(groups = IInsert.class,message = "systemId不能为空")
	@ApiModelProperty("系统id")
	private Long systemId;

	@NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@NotNull.List({
		@NotNull(groups = IInsert.class,message = "operatorId不能为空"),
		@NotNull(groups = IUpdate.class, message = "operatorId不能为空")
	})
	@ApiModelProperty("操作人")
	private Long operatorId;


}



