package com.jason.mall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/decrease.do")
    public String decrease(){
        template.opsForValue().decrement("GOODS_NUMBER");

        try {
            kafkaTemplate.send("goodsDecrease", "goods", "hihi");
        }catch (Exception e) {
            logger.error("发送kafka失败", e);
        }
        System.out.println("hihihi");
        return "decrease:Hello World!";
    }
}
