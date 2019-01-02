package com.jason.mall.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "goodsDecrease")
    public void processMessage(ConsumerRecord<?, ?> record) {
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
    }
}
