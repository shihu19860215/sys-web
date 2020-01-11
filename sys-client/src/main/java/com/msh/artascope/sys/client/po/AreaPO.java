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
@ApiModel("行政区域规划码PO")
public class AreaPO extends BasePO{
	@NotNull(groups = IInsert.class,message = "simpleCode不能为空")
	@ApiModelProperty("行政简码")
	private Integer simpleCode;

	@NotNull(groups = IInsert.class,message = "simpleAddr不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "simpleAddr长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "simpleAddr长度范围1到32")
	})
	@ApiModelProperty("简地址")
	private String simpleAddr;

	@NotNull(groups = IInsert.class,message = "fullAddr不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 64, message = "fullAddr长度范围1到64"),
		@Size(groups = IUpdate.class,min = 1,max = 64, message = "fullAddr长度范围1到64")
	})
	@ApiModelProperty("全路径地址")
	private String fullAddr;

	@NotNull(groups = IInsert.class,message = "layer不能为空")
	@ApiModelProperty("等级")
	private Integer layer;

	@NotNull(groups = IInsert.class,message = "parentCode不能为空")
	@ApiModelProperty("父编码")
	private Long parentCode;

	@NotNull(groups = IInsert.class,message = "province不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "province长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "province长度范围1到32")
	})
	@ApiModelProperty("省")
	private String province;

	@NotNull(groups = IInsert.class,message = "city不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "city长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "city长度范围1到32")
	})
	@ApiModelProperty("城市")
	private String city;

	@NotNull(groups = IInsert.class,message = "area不能为空")
	@Size.List({
		@Size(groups = IInsert.class,min = 1,max = 32, message = "area长度范围1到32"),
		@Size(groups = IUpdate.class,min = 1,max = 32, message = "area长度范围1到32")
	})
	@ApiModelProperty("区域")
	private String area;


}



