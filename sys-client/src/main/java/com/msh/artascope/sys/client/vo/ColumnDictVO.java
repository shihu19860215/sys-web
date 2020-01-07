package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.ColumnDictPO;
import io.swagger.annotations.ApiModel;
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
public class ColumnDictVO extends ColumnDictPO {

	public ColumnDictVO(){}
	public ColumnDictVO(ColumnDictPO columnDictPO){
		this.setId(columnDictPO.getId());
		this.setColumnId(columnDictPO.getColumnId());
		this.setValue(columnDictPO.getValue());
		this.setMeaning(columnDictPO.getMeaning());
		this.setStatus(columnDictPO.getStatus());
		this.setUpdateVersion(columnDictPO.getUpdateVersion());
		this.setCreateTime(columnDictPO.getCreateTime());
		this.setUpdateTime(columnDictPO.getUpdateTime());
	}
}


