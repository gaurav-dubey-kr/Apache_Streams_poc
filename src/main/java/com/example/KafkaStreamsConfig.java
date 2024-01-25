package com.example;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;

import java.util.Properties;

public class KafkaStreamsConfig {

    public static Properties getConfig() {
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-pipeline");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        // Add more configuration properties as needed

//        Properties producerProps = new Properties();
//        producerProps.put("bootstrap.servers", "localhost:9092");
//        producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        Producer<String, String> producer = new KafkaProducer<>(producerProps);
////
//        Properties consumerProps = new Properties();
//        consumerProps.put("bootstrap.servers", "localhost:9092");
////        consumerProps.put("group.id", "0");
//        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        consumerProps.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
////
//        Consumer<String, String> consumer = new KafkaConsumer<>(consumerProps);

        return config;
    }
}
