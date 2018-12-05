package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 2:55 PM
 * @Version 1.0
 */

//需要加上@Component

@Component
@Slf4j
public class Listener2 {
    @KafkaListener(id = "myContainer2",topics = {"topic","bar"})
    public void listen2(ConsumerRecord<?, ?> record){
        System.out.println("myContainer2");
        System.out.println("topic：" + record.topic());
        System.out.println("key:" + record.key());
        System.out.println("value:"+record.value());
    }
}
