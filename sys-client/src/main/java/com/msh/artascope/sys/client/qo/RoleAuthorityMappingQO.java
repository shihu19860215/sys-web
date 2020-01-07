package com.msh.artascope.sys.client.qo;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("角色权限映射")
public class RoleAuthorityMappingQO extends BaseQO {
	@ApiModelProperty("角色id")
	private Long roleId;

	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in角色id")
	private Collection<Long> inRoleIds;

	@ApiModelProperty("in角色id")
	private Collection<Long> inAuthorityIds;
}