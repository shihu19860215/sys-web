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
@ApiModel("用户信息PO")
public class UserPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "username不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "username长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "username长度范围1到20")
	})
	@ApiModelProperty("用户名")
	private String username;

	@NotNull(groups = IInsert.class,message = "password不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "password长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "password长度范围1到20")
	})
	@ApiModelProperty("密码")
	private String password;

	@NotNull(groups = IInsert.class,message = "tel不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "tel长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "tel长度范围1到20")
	})
	@ApiModelProperty("")
	private String tel;

	@NotNull(groups = IInsert.class,message = "nickname不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 20, message = "nickname长度范围1到20"),
		@Size(groups = IUpdate.class,min = 1,max = 20, message = "nickname长度范围1到20")
	})
	@ApiModelProperty("昵称")
	private String nickname;

	@NotNull(message = "tenantId不能为空")
	@ApiModelProperty("租户id")
	private Long tenantId;

	@NotNull.List({
		@NotNull(groups = IInsert.class,message = "operatorId不能为空"),
		@NotNull(groups = IUpdate.class, message = "operatorId不能为空")
	})
	@ApiModelProperty("操作人")
	private Long operatorId;


}



