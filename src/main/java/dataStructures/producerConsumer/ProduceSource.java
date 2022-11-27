package dataStructures.producerConsumer;

public class ProduceSource {
    //private LinkedBlockingQueue<Product> linkedBlockingQueue = new LinkedBlockingQueue<>(10);
    //private BlockingQueWithLock linkedBlockingQueue = new BlockingQueWithLock(10);
    private BlockingQueWithSynchronize linkedBlockingQueue = new BlockingQueWithSynchronize(10);

    public void produce(Product product) {
        try {
            System.out.println("Queue Size Before Produce: " + linkedBlockingQueue.size());
            linkedBlockingQueue.put(product);
            if(Thread.State.WAITING.equals(Thread.currentThread().getState())) {
                System.out.println("------------------------------------------");
            }
            System.out.println("Queue Size After Produce: " + linkedBlockingQueue.size());
        } catch (Exception e) {
           System.out.println("Production Failed!");
        }
    }

    public void consume() {
        try {
            System.out.println("Queue Size Before Consume: " + linkedBlockingQueue.size());
            System.out.println(Thread.currentThread().getState());
            linkedBlockingQueue.take();
            if(Thread.State.WAITING.equals(Thread.currentThread().getState())) {
                System.out.println("------------------------------------------");
            }
            System.out.println("Queue Size After Consume: " + linkedBlockingQueue.size());
        } catch (Exception e) {
            System.out.println("Consumption Failed!");
        }
    }
}