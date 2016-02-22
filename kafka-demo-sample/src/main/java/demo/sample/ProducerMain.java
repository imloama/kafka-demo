package demo.sample;

public class ProducerMain {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			ProducerDemo producer = new ProducerDemo("localhost:9092");
			producer.send("test", "hello" + i);
			Thread.sleep(10000);
		}
	}

}
