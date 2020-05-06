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
@ApiModel("审计列表PO")
public class AuditPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "tableName不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "tableName长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "tableName长度范围1到32")
	})
	@ApiModelProperty("类名")
	private String tableName;

	@NotNull(groups = IInsert.class,message = "primaryKeyId不能为空")
	@ApiModelProperty("主键id")
	private Long primaryKeyId;

	@NotNull(groups = IInsert.class,message = "beforeValue不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 64, message = "beforeValue长度范围1到64"),
		@Size(groups = IUpdate.class,min = 1,max = 64, message = "beforeValue长度范围1到64")
	})
	@ApiModelProperty("修改前值")
	private String beforeValue;

	@NotNull(groups = IInsert.class,message = "afterValue不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 64, message = "afterValue长度范围1到64"),
		@Size(groups = IUpdate.class,min = 1,max = 64, message = "afterValue长度范围1到64")
	})
	@ApiModelProperty("修改后值")
	private String afterValue;

	@NotNull(groups = IInsert.class,message = "comment不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 512, message = "comment长度范围1到512"),
		@Size(groups = IUpdate.class,min = 1,max = 512, message = "comment长度范围1到512")
	})
	@ApiModelProperty("备注")
	private String comment;

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

	@ApiModelProperty("创建时间")
	private Date createTime;


}



