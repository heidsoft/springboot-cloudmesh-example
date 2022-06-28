package top.cloudmesh.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cloudmesh.utils.RedisLockUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heidsoft
 */
@RestController
@RequestMapping(path = "/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisLockUtil redisLockUtil;

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

    @GetMapping("/lock")
    public void redisLock(){
        //获取锁
        Boolean lock = redisLockUtil.tryLock("lock-redis", "12000", 10);
        if (null != lock && lock) {
            try {
                //TODO 业务处理
                System.out.println("获取lock 处理");
            } finally {
                //释放锁
                Boolean release = redisLockUtil.releaseLock("lock-redis", "12000");
            }
        } else {
            System.out.println("获取锁失败");
        }
    }


    /**
     * 测试类
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "test redis";
    }

    /**
     * 带响应实体的方式
     * @return
     */
    @GetMapping(path = "/hello", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello() throws JSONException {
        //Get data from service layer into entityList.
        List<JSONObject> entities = new ArrayList<JSONObject>();
        JSONObject entity = new JSONObject();
        entity.put("test",1);
        entities.add(entity);
        return new ResponseEntity<Object>(entities, HttpStatus.OK);
    }

    /**
     * https://stackoverflow.com/questions/44839753/returning-json-object-as-response-in-spring-boot
     * @return
     * @throws JsonProcessingException
     */
    @GetMapping
    @RequestMapping(value = "/jsondemo")
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("{\"id\": \"132\", \"name\": \"Alice\"}");
        return ResponseEntity.ok(json);
    }
}
