package com.msh.artascope.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
@ApiModel("用户角色映射PO")
public class UserRoleMappingPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "userId不能为空")
	@ApiModelProperty("用户id")
	private Long userId;

	@NotNull(groups = IInsert.class,message = "roleId不能为空")
	@ApiModelProperty("角色id")
	private Long roleId;

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



