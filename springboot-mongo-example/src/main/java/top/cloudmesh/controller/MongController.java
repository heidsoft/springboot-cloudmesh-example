package top.cloudmesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cloudmesh.service.CreateCollectionService;
import top.cloudmesh.service.QueryService;
import top.cloudmesh.service.SaveService;

@RestController
@RequestMapping(path = "/mongo")
public class MongController {

    @Autowired
    private CreateCollectionService createCollectionService;

    @Autowired
    private SaveService saveService;

    @Autowired
    private QueryService queryService;

    @GetMapping(value = "/hello")
    public Object mongo(){
        System.out.println("mongo hello");
        return "mongo hello";
    }

    @GetMapping(value = "/createCollection")
    public Object createCollection(){
        System.out.println("mongo hello");
        return  createCollectionService.createCollection();
    }

    @GetMapping(value = "/saveService")
    public Object saveService(){
        System.out.println("存储用户文档");
        return  saveService.save();
    }

    @GetMapping(value = "/queryService")
    public Object queryService(){
        System.out.println("查询用户文档信息");
        return queryService.findAll();
    }


}
