package com.msh.artascope.sys.client.po;


import java.util.Date;
import com.msh.frame.client.base.BasePO;
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
@ApiModel("权限列表")
public class AuthorityPO extends BasePO{
	@ApiModelProperty("权限名")
	private String name;

	@ApiModelProperty("编号")
	private String code;

	@ApiModelProperty("父权限")
	private Long parentId;

	@ApiModelProperty("层级")
	private Integer layer;

	@ApiModelProperty("类型")
	private Integer type;

	@ApiModelProperty("排序值")
	private Integer sort;

	@ApiModelProperty("图标")
	private String icon;


}



