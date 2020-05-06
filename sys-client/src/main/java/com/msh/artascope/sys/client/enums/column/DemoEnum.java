package com.msh.artascope.sys.client.enums.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-05-06 17:23:52
 */
@AllArgsConstructor
@Getter
public enum  DemoEnum {
    ID(18949385853580L, "t_demo", "id", "主键id"),
    STATUS(18949385853581L, "t_demo", "status", "状态"),
    TENANT_ID(18949385853582L, "t_demo", "tenant_id", "租户id"),
    OPERATOR_ID(18949385853583L, "t_demo", "operator_id", "操作人"),
    CREATE_TIME(18949385853584L, "t_demo", "create_time", "创建时间"),
    UPDATE_TIME(18949385853585L, "t_demo", "update_time", "更新时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
