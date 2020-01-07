package com.msh.artascope.sys.client.qo;

import java.util.Date;
import com.msh.frame.client.base.BaseQO;
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
@ApiModel("用户信息")
public class UserQO extends BaseQO {
	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("手机号码")
	private String tel;

	@ApiModelProperty("昵称")
	private String nickname;

	@ApiModelProperty("租户id")
	private Long tenantId;

	@ApiModelProperty("操作人")
	private Long operatorId;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

	@ApiModelProperty("使用系统id")
    private Long SystemId;

	@ApiModelProperty("不等于id")
	private Long neqId;
}