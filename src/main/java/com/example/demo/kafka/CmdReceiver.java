package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/24 10:12 AM
 * @Version 1.0
 */


//@component （把普通pojo实例化到spring容器中，相当于配置文件中的
//<bean id="" class=""/>）


@Component
@Slf4j
public class CmdReceiver {

//    Spring Kafka提供的 @KafkaListener注解，可以让我们监听某个topic或者topicPattern的消息。
//    监听符合topicPattern = “topic.*”的所有topic的消息

    @KafkaListener(topicPattern = "topic.*")
    public void listen(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =topic："  + topic+ ", " + record);
            log.info("------------------ message =topic：" + topic+ ", " + message);
        }
    }
}
