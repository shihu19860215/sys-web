package com.msh.artascope.sys.service.config;

import com.msh.frame.common.aop.aspect.AbstractInfoLoggerAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;



/**
 * @author shihu
 * @email m-sh@qq.com
 * @date 2020-01-06 11:11:34
 */
@Aspect
@Order(10)
abstract public class AbstractServiceDaoInfoLogAspect extends AbstractInfoLoggerAspect {
    @Override
    @Pointcut("this(com.msh.frame.client.base.BaseService)")
    protected void pointcut() {
    }
}