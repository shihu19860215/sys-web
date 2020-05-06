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
public enum  SystemEnum {
    ID(18949385230397L, "sys_system", "id", "主键id"),
    STATUS(18949385230398L, "sys_system", "status", "状态"),
    OPERATOR_ID(18949385230399L, "sys_system", "operator_id", "操作人"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
