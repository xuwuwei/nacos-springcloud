package com.xumingxun.springcloud.nacos.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider-app")
public interface HelloFeign{
    @RequestMapping(value = "/say/{name}")
    String say(@PathVariable("name") String name);
}
