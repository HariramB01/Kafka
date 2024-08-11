package com.kafka;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerHandler implements EventHandler {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerHandler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public ProducerHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        // for printing in the console
        LOGGER.info(String.format("Message : %s", messageEvent.getData()));
        //sending the message to the topic
        kafkaTemplate.send(topic,messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
