package demo.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * 消息消费者
 * 
 */

public class ConsumerDemo {

	private static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class);
	
	private final ConsumerConnector consumer;
	private final String topic;
	  public ConsumerDemo(String zookeeper, String groupId, String topic) {
	        Properties props = new Properties();
	        props.put("zookeeper.connect", zookeeper);
	        props.put("group.id", groupId);
	        props.put("zookeeper.session.timeout.ms", "500");
	        props.put("zookeeper.sync.time.ms", "250");
	        props.put("auto.commit.interval.ms", "1000");

	        consumer = Consumer.createJavaConsumerConnector(new ConsumerConfig(props));
	        this.topic = topic;
	    }

	    public void consume() {
	        Map<String, Integer> topicCount = new HashMap<>();
	        topicCount.put(topic, 1);

	        Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreams = consumer.createMessageStreams(topicCount);
	        List<KafkaStream<byte[], byte[]>> streams = consumerStreams.get(topic);
	        for (final KafkaStream stream : streams) {
	            ConsumerIterator<byte[], byte[]> it = stream.iterator();
	            while (it.hasNext()) {
	                String msg = new String(it.next().message());
	                log.info("**** Received Message from Topic: {} ****", msg);
	            }
	        }
	        if (consumer != null) {
	            consumer.shutdown();
	        }
	    }

}
