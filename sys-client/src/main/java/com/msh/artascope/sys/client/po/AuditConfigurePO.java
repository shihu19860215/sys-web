package com.msh.artascope.sys.client.po;


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
import java.util.Date;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("审计配置PO")
public class AuditConfigurePO extends BasePO{
	@NotNull(groups = IInsert.class,message = "className不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "className长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "className长度范围1到32")
	})
	@ApiModelProperty("类名")
	private String className;

	@NotNull(groups = IInsert.class,message = "fieldName不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "fieldName长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "fieldName长度范围1到32")
	})
	@ApiModelProperty("字段名")
	private String fieldName;

	@NotNull(groups = IInsert.class,message = "meaning不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "meaning长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "meaning长度范围1到32")
	})
	@ApiModelProperty("字段意思")
	private String meaning;

	@NotNull(groups = IInsert.class,message = "status不能为空")
	@ApiModelProperty("状态")
	private Integer status;

	@NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@NotNull.List({
		@NotNull(groups = IInsert.class,message = "operatorId不能为空"),
		@NotNull(groups = IUpdate.class, message = "operatorId不能为空")
	})
	@ApiModelProperty("操作人")
	private Long operatorId;

	@NotNull(groups = IUpdate.class, message = "更新版本不能为空")
	@ApiModelProperty("更新版本")
	private Integer updateVersion;

	private Date createTime;

	private Date updateTime;


}



