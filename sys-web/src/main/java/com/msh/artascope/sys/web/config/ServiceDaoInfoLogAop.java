package com.msh.artascope.sys.web.config;

import com.msh.frame.web.util.HttpServletRequestUtil;
import com.msh.artascope.sys.service.config.AbstractServiceDaoInfoLogAspect;
import org.springframework.stereotype.Component;

/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Component
public class ServiceDaoInfoLogAop extends AbstractServiceDaoInfoLogAspect {

    @Override
    protected Long getTraceId() {
        return HttpServletRequestUtil.getTraceId();
    }
}
