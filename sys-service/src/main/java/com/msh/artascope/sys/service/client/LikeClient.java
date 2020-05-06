package com.msh.artascope.sys.service.client;

import com.msh.artascope.like.client.po.CharIndexPO;
import com.msh.frame.client.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient(value = "artascope-like-api")
public interface LikeClient {

    @RequestMapping(value = "/charindex/insert",method = RequestMethod.POST)
    CommonResult insert(@RequestBody CharIndexPO p);

    @RequestMapping(value = "/charindex/insertcollection",method = RequestMethod.POST)
    CommonResult insertCollection(@RequestBody Collection<CharIndexPO> p);
}
