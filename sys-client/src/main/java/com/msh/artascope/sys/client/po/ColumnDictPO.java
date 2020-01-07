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
@ApiModel("字段字典")
public class ColumnDictPO extends BasePO{
	@ApiModelProperty("字段id")
	private Long columnId;

	@ApiModelProperty("数据库值")
	private Integer value;

	@ApiModelProperty("实际意思")
	private String meaning;


}



