package com.msh.artascope.sys.client.qo;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Collection;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限列表QO")
public class AuthorityQO extends BaseQO {
	@ApiModelProperty("权限名")
	private String name;

	@ApiModelProperty("编号")
	private String code;

	@ApiModelProperty("父权限")
	private Long parentId;

	@ApiModelProperty("层级")
	private Integer layer;

	@ApiModelProperty("权限类型")
	private Integer type;

	@ApiModelProperty("排序值")
	private Integer sort;

	@ApiModelProperty("图标")
	private String icon;

	@ApiModelProperty("状态")
	private Integer status;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in查询")
	private Collection<Long> inIds;

}