package com.msh.artascope.sys.client.enums.sort;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-09 17:21:47
 */
public enum  TenantSortEnum {
    ID("id","主键id"),
    PRIMARY_USER_ID("primary_user_id","主账号id"),
    STATUS("status","状态"),
    TENANT_START_TIME("tenant_start_time","租户开始时间"),
    TENANT_END_TIME("tenant_end_time","租户结束时间"),
    OPERATOR_ID("operator_id","操作人"),
    CREATE_TIME("create_time","创建时间"),
    UPDATE_TIME("update_time","更新时间"),
;

    private String desc;
    private String sortColumn;

    private TenantSortEnum(String sortColumn,String desc) {
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
