package com.xumingxun.springcloud.nacos.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xumingxun.springcloud.nacos.consumer")
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }

    //http://localhost:8877/call/man/123456
    @RestController
    @RefreshScope
    class CallController{

        @Autowired
        HelloFeign helloFeign;

//        build data id `myconfig` in nacos admin, write `money=$1000000`
//POST http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=myconfig&group=DEFAULT_GROUP&content=money=$1000000

        @Value("${money:$0}")
        private String money;

        @RequestMapping("/call/{name}/{num}")
        public String call(@PathVariable("name") String name,@PathVariable("num") String num){
            return "I have "+money+"<br/>"+"call "+num+"<br>"+helloFeign.say(name);
        }
    }


}
