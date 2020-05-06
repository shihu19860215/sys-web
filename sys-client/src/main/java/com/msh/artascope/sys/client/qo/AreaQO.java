package com.msh.artascope.sys.client.qo;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-16 16:54:59
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("行政区域规划码QO")
public class AreaQO extends BaseQO {
	@ApiModelProperty("行政简码")
	private Integer simpleCode;

	@ApiModelProperty("简地址")
	private String simpleAddr;

	@ApiModelProperty("全路径地址")
	private String fullAddr;

	@ApiModelProperty("等级")
	private Integer layer;

	@ApiModelProperty("父编码")
	private Long parentCode;

	@ApiModelProperty("省")
	private String province;

	@ApiModelProperty("城市")
	private String city;

	@ApiModelProperty("区域")
	private String area;

	@ApiModelProperty("状态")
	private Integer status;

    @ApiModelProperty("大于等于status")
    private Integer egtStatus;

}