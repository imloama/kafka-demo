package demo.sample;

public class ConsumerMain {

	public static void main(String[] args) throws InterruptedException {
		String zookeeper = "127.0.0.1:2181";
		String groupId = "mazhaoyong";
		String topic = "test";
		for(int i=0;i<100;i++){
			ConsumerDemo consumer = new ConsumerDemo(zookeeper,groupId,topic);
			consumer.consume();
			Thread.sleep(10000);
		}
	}
	
}
