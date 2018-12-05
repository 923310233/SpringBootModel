package com.example.demo.kafka;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 1:14 PM
 * @Version 1.0
 */

//@RequestParam(value = "partition",defaultValue = "0") int partition

@RestController
@RequestMapping("/kafka")
public class KafkaController  {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/product")
    public String productTest(){

        User user = new User("001","Tom");
        String json = JSON.toJSONString(user);
        producerService.sendJson("topic",0,json);
        return json;
    }




}
