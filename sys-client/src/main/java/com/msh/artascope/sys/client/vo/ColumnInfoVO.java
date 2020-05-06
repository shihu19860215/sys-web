package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.ColumnDictPO;
import com.msh.artascope.sys.client.po.ColumnInfoPO;
import java.util.Date;
import java.util.List;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("字段详情")
public class ColumnInfoVO extends ColumnInfoPO {
	@ApiModelProperty("字段字典列表")
	private List<ColumnDictPO> columnDictPOList;

	public ColumnInfoVO(){}
	public ColumnInfoVO(ColumnInfoPO columnInfoPO){
		this.setId(columnInfoPO.getId());
		this.setTableName(columnInfoPO.getTableName());
		this.setColumnName(columnInfoPO.getColumnName());
		this.setTitle(columnInfoPO.getTitle());
		this.setStatus(columnInfoPO.getStatus());
	}
}


