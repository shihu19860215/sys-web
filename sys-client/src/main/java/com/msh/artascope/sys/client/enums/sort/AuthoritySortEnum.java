package com.msh.artascope.sys.client.enums.sort;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 18:01:23
 */
public enum  AuthoritySortEnum {
    ID("id","主键id"),
    PARENT_ID("parent_id","父权限"),
    LAYER("layer","层级"),
    TYPE("type","类型"),
    SORT("sort","排序值"),
    STATUS("status","状态"),
    CREATE_TIME("create_time","创建时间"),
    UPDATE_TIME("update_time","更新时间"),
;

    private String desc;
    private String sortColumn;

    private AuthoritySortEnum(String sortColumn,String desc) {
        this.sortColumn = sortColumn;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getSortColumn() {
        return sortColumn;
    }
}
