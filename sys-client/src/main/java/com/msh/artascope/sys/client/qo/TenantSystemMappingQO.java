package com.msh.artascope.sys.client.qo;

import com.msh.frame.client.base.BaseQO;
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
@ApiModel("租户系统映射QO")
public class TenantSystemMappingQO extends BaseQO {
    @NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("系统id")
	private Long systemId;

	@ApiModelProperty("操作人")
	private Long operatorId;

}