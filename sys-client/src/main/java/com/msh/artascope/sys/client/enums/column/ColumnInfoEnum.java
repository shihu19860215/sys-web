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
public enum  ColumnInfoEnum {
    ID(18949384927262L, "sys_column_info", "id", "主键id"),
    STATUS(18949384927263L, "sys_column_info", "status", "状态"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
