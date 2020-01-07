package com.msh.artascope.sys.service.config;

import com.msh.frame.interfaces.ICache;
import com.msh.frame.interfaces.ICacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfigure {
    @Bean("userSystemCache")
    public ICache<Long,Long> cacheUserSystem(ICacheManager cacheManager){
        return cacheManager.getCache("com.msh.artascope.userSystemId:");
    }
}
