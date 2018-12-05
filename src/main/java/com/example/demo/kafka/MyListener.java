package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 11:50 AM
 * @Version 1.0
 */

//开发自己的Listener监听具体的topic
//监听以topic开头的主题，不做其他业务，只是打印出来

@Component
@Slf4j
public class MyListener {

    @KafkaListener(topicPattern = "topic.*")
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("------------------ 监听器message =topic：" + topic + ", " + message);
        }
    }


    //id是消费者监听容器
    //配置topic和分区：监听两个topic，分别为topic1、topic2，topic1只接收分区0，3的消息，
    //topic2接收分区0和分区1的消息，但是分区1的消费者初始位置为5
//    @KafkaListener(id = "myContainer3",
//            topicPartitions = {
//                    @TopicPartition(topic = "topic1", partitions = {"0", "3"}),
//                    @TopicPartition(topic = "topic2", partitions = "0",
//                            partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "4"))
//            })


}
