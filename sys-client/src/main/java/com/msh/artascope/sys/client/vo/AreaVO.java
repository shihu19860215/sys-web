package com.msh.artascope.sys.client.vo;

import com.msh.artascope.sys.client.po.AreaPO;
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
 * @date 2020-01-09 17:21:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@ApiModel("行政区域规划码")
public class AreaVO extends AreaPO {

	public AreaVO(){}
	public AreaVO(AreaPO areaPO){
		this.setId(areaPO.getId());
		this.setSimpleCode(areaPO.getSimpleCode());
		this.setSimpleAddr(areaPO.getSimpleAddr());
		this.setFullAddr(areaPO.getFullAddr());
		this.setLayer(areaPO.getLayer());
		this.setParentCode(areaPO.getParentCode());
		this.setProvince(areaPO.getProvince());
		this.setCity(areaPO.getCity());
		this.setArea(areaPO.getArea());
		this.setStatus(areaPO.getStatus());
		this.setCreateTime(areaPO.getCreateTime());
		this.setUpdateTime(areaPO.getUpdateTime());
	}
}


