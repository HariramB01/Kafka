package com.kafka;


import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String topic = "producer1";

        EventHandler eventHandler = new ProducerHandler(kafkaTemplate, topic);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();

        eventSource.start();
        TimeUnit.MINUTES.sleep(10);
    }
}


/*

Explanation:

We have injected the KafkaTemplate, which is used to

We have established /created one handler method named as sendMessage().
And given the topic name as producer1

ANd we have instantiated EventHandler
This handler will be triggered whenever there is an event comes to the site.
url(wikimedia);

And we have declared EventSource
The eventsource will connect with the source which is wikimedia.  And it will collect
all the data from the source suite.  and it will trigger the respective handler in the event handler

and in the handler method we have written our logic to send the data to the topic


 */
