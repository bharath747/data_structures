package dataStructures.producerConsumer;

import java.util.Random;

public class Producer implements Runnable {
    @Override
    public void run() {
       ProduceSource produceSource = TestProducerConsumer.getSource();
       while (true) {
           produceSource.produce(new Product(new Random().doubles().toString(), new Random().ints().toString()));
       }

    }
}