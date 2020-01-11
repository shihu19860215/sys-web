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
@ApiModel("系统信息PO")
public class SystemPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "name不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "name长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "name长度范围1到20")
	})
	@ApiModelProperty("系统名")
	private String name;

	@NotNull.List({
		@NotNull(groups = IInsert.class,message = "operatorId不能为空"),
		@NotNull(groups = IUpdate.class, message = "operatorId不能为空")
	})
	@ApiModelProperty("操作人")
	private Long operatorId;


}



