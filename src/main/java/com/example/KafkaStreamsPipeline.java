package com.example;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class KafkaStreamsPipeline {

    public static void main(String[] args) {
        Properties config = KafkaStreamsConfig.getConfig();

        Topology topology = buildTopology();

        KafkaStreams streams = new KafkaStreams(topology, config);

        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }

    private static Topology buildTopology() {
        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, ?> inputStream = builder.stream("ingress-topic");
        KStream<String, ?> processedStream = inputStream.mapValues(value -> value);

        processedStream.foreach((key, value) -> System.out.println("Value: " + value));

        return builder.build();
    }
}
