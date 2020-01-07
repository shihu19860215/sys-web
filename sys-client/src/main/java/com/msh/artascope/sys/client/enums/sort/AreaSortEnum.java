package com.msh.artascope.sys.client.enums.sort;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 18:01:23
 */
public enum  AreaSortEnum {
    ID("id","行政编码"),
    SIMPLE_CODE("simple_code","行政简码"),
    LAYER("layer","等级"),
    PARENT_CODE("parent_code","父编码"),
    STATUS("status","状态"),
    CREATE_TIME("create_time","创建时间"),
    UPDATE_TIME("update_time","更新时间"),
;

    private String desc;
    private String sortColumn;

    private AreaSortEnum(String sortColumn,String desc) {
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
