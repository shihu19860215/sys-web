package com.msh.artascope.sys.client.back.vo;

import com.msh.artascope.sys.client.back.po.ColumnDictPO;
import com.msh.artascope.sys.client.back.po.ColumnInfoPO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

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
		this.setUpdateVersion(columnInfoPO.getUpdateVersion());
		this.setCreateTime(columnInfoPO.getCreateTime());
		this.setUpdateTime(columnInfoPO.getUpdateTime());
	}
}


