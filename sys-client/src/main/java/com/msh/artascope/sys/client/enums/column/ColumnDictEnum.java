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
public enum  ColumnDictEnum {
    ID(18949384827160L, "sys_column_dict", "id", "主键id"),
    COLUMN_ID(18949384827161L, "sys_column_dict", "column_id", "字段id"),
    VALUE(18949384827162L, "sys_column_dict", "value", "数据库值"),
    STATUS(18949384827163L, "sys_column_dict", "status", "状态"),
;

    private Long id;
    private String table;
    private String column;
    private String desc;
}
