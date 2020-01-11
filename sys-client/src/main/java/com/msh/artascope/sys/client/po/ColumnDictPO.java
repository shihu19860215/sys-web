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
@ApiModel("字段字典PO")
public class ColumnDictPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "columnId不能为空")
	@ApiModelProperty("字段id")
	private Long columnId;

	@NotNull(groups = IInsert.class,message = "value不能为空")
	@ApiModelProperty("数据库值")
	private Integer value;

	@NotNull(groups = IInsert.class,message = "meaning不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "meaning长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "meaning长度范围1到20")
	})
	@ApiModelProperty("实际意思")
	private String meaning;


}



