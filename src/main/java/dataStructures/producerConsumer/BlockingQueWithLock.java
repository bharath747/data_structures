package dataStructures.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueWithLock {
    private Queue queue;
    private int max = 16;
    ReentrantLock lock = new ReentrantLock();
    Condition stackEmpty = lock.newCondition();
    Condition stackFull = lock.newCondition();

    public BlockingQueWithLock() {
        queue = new LinkedList();
    }

    public BlockingQueWithLock(int size) {
        queue = new LinkedList();
        this.max = size;
    }

    public void put(Product product) {
        lock.lock();
        try {
            while (queue.size() == max) {
                stackFull.await();
            }
            queue.add(product);
            stackEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                stackEmpty.await();
            }
            queue.remove();
            stackFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return queue.size();
    }
}