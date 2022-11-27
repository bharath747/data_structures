package dataStructures.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueWithSynchronize {
    private Queue queue;
    private int max = 16;

    public BlockingQueWithSynchronize() {
        queue = new LinkedList();
    }

    public BlockingQueWithSynchronize(int size) {
        queue = new LinkedList();
        this.max = size;
    }

    public synchronized void put(Product product) {
        try {
            while (queue.size() == max) {
                this.wait();
            }
            queue.add(product);
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void take() {
        try {
            while (queue.size() == 0) {
                this.wait();
            }
            queue.remove();
            this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int size() {
        return queue.size();
    }
}