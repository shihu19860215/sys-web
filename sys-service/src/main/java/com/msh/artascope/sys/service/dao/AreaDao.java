package com.msh.artascope.sys.service.dao;

import com.msh.frame.client.base.BaseDao;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
public interface AreaDao<AreaPO,AreaQO> extends BaseDao {
    long logicDelete(AreaQO param);
}
