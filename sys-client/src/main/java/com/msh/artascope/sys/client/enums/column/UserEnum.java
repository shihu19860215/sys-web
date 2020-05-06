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
public enum  UserEnum {
    ID(18949385607270L, "sys_user", "id", "主键id"),
    STATUS(18949385607271L, "sys_user", "status", "状态"),
    TENANT_ID(18949385607272L, "sys_user", "tenant_id", "租户id"),
    OPERATOR_ID(18949385607273L, "sys_user", "operator_id", "操作人"),
    CREATE_TIME(18949385607274L, "sys_user", "create_time", "创建时间"),
    UPDATE_TIME(18949385607275L, "sys_user", "update_time", "更新时间"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
