package demo.sample;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 消息生产者
 * 
 * @author mazhaoyong@gmail.com
 *
 */
public class ProducerDemo {

	 private static Producer<String, String> producer;
	    private final Properties properties = new Properties();

	    public ProducerDemo(String kafkaURL) {
	        properties.put("metadata.broker.list", kafkaURL);
	        properties.put("serializer.class", "kafka.serializer.StringEncoder");
	        properties.put("request.required.acks", "1");
	        producer = new Producer<>(new ProducerConfig(properties));
	    }

	    public void send(String topic, String msg) {
	        KeyedMessage<String, String> data = new KeyedMessage<>(topic, msg);
	        producer.send(data);
	        producer.close();
	    }

}
