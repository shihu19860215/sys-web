package com.msh.artascope.sys.client.qo;

import java.util.Date;
import java.util.Set;

import com.msh.frame.client.base.BaseQO;
import com.msh.frame.client.validation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("权限urlQO")
public class AuthorityUrlQO extends BaseQO {
	@ApiModelProperty("权限id")
	private Long authorityId;

	@ApiModelProperty("请求url")
	private String url;

	@ApiModelProperty("连接权限 1拥有权限可访问 2用户登录可访问 3无需登录可访问")
	private Integer linkAuth;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("in查询")
	private Set<Long> inAuthIds;
}