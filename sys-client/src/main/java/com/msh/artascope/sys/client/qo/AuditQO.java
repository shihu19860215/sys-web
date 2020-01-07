package com.msh.artascope.sys.client.qo;

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
 * @date 2020-01-06 11:11:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("审计列表")
public class AuditQO extends BaseQO {
	@ApiModelProperty("类名")
	private String className;

	@ApiModelProperty("字段名")
	private String fieldName;

	@ApiModelProperty("主键id")
	private Long primaryKeyId;

	@ApiModelProperty("修改前值")
	private String beforeValue;

	@ApiModelProperty("修改后值")
	private String afterValue;

	@ApiModelProperty("备注")
	private String comment;

	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}