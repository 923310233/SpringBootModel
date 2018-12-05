package com.example.demo.kafka;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 11:52 AM
 * @Version 1.0
 */
public interface ProducerService {
    void sendJson(String topic, int partition, String json);
}
