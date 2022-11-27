package dataStructures.producerConsumer;

public class TestProducerConsumer {
    private static ProduceSource produceSource = new ProduceSource();

    public static ProduceSource getSource() {
        return produceSource;
    }

    public static void main(String[] args) {
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
    }
}