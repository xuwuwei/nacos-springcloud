package com.xumingxun.springcloud.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class,args);
    }

    //http://localhost:8866/say/man
    @RestController
    class HelloController{
        @RequestMapping(path = "/say/{name}")
        public String say(@PathVariable("name")String name){
            return "hello "+name;
        }
    }
}
