package top.cloudmesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heidsoft
 */
@RestController
@RequestMapping(path = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 测试redis ops set 操作
     */
    @GetMapping("/opsset")
    public Object redisOps(){
        Long opsId =  this.redisTemplate.opsForSet().add("set_sample","java","c++","rust");
        System.out.println(opsId);
        return  opsId;
    }

    @GetMapping("/opsgetset")
    public Object redisOpsGet(){
        Long opsId =  this.redisTemplate.opsForSet().add("set_sample","java","c++","rust");
        System.out.println(opsId);
        return  opsId;
    }


    /**
     * 测试类
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "test redis";
    }
}
