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
@ApiModel("字段详情PO")
public class ColumnInfoPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "tableName不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 50, message = "tableName长度范围1到50"),
		@Size(groups = IUpdate.class,min = 1,max = 50, message = "tableName长度范围1到50")
	})
	@ApiModelProperty("表名")
	private String tableName;

	@NotNull(groups = IInsert.class,message = "columnName不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "columnName长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "columnName长度范围1到20")
	})
	@ApiModelProperty("字段名")
	private String columnName;

	@NotNull(groups = IInsert.class,message = "title不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "title长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "title长度范围1到20")
	})
	@ApiModelProperty("标题")
	private String title;


}



