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
@ApiModel("审计列表QO")
public class AuditQO extends BaseQO {
	@ApiModelProperty("类名")
	private String tableName;

	@ApiModelProperty("主键id")
	private Long primaryKeyId;

	@ApiModelProperty("修改前值")
	private String beforeValue;

	@ApiModelProperty("修改后值")
	private String afterValue;

	@ApiModelProperty("备注")
	private String comment;

	@ApiModelProperty("状态")
	private Integer status;

    @NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}