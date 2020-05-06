package com.msh.artascope.sys.client.qo;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("角色权限映射QO")
public class RoleAuthorityMappingQO extends BaseQO {
	@ApiModelProperty("角色id")
	private Long roleId;

	@ApiModelProperty("权限id")
	private Long authorityId;

    @NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

	@ApiModelProperty("in角色id")
	private Collection<Long> inRoleIds;

	@ApiModelProperty("in角色id")
	private Collection<Long> inAuthorityIds;

}