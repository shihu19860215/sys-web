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
@ApiModel("权限列表PO")
public class AuthorityPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "name不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "name长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "name长度范围1到20")
	})
	@ApiModelProperty("权限名")
	private String name;

	@NotNull(groups = IInsert.class,message = "code不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 50, message = "code长度范围1到50"),
		@Size(groups = IUpdate.class,min = 1,max = 50, message = "code长度范围1到50")
	})
	@ApiModelProperty("编号")
	private String code;

	@NotNull(groups = IInsert.class,message = "parentId不能为空")
	@ApiModelProperty("父权限")
	private Long parentId;

	@NotNull(groups = IInsert.class,message = "layer不能为空")
	@ApiModelProperty("层级")
	private Integer layer;

	@NotNull(groups = IInsert.class,message = "type不能为空")
	@ApiModelProperty("类型")
	private Integer type;

	@NotNull(groups = IInsert.class,message = "sort不能为空")
	@ApiModelProperty("排序值")
	private Integer sort;

	@NotNull(groups = IInsert.class,message = "icon不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 30, message = "icon长度范围1到30"),
		@Size(groups = IUpdate.class,min = 1,max = 30, message = "icon长度范围1到30")
	})
	@ApiModelProperty("图标")
	private String icon;


}



