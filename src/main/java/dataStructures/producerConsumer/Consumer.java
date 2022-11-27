package dataStructures.producerConsumer;

public class Consumer implements Runnable {
    @Override
    public void run() {
        ProduceSource produceSource = TestProducerConsumer.getSource();
        while (true) {
            produceSource.consume();
        }
    }
}