package dataStructures;

public class MaxHeap {
    private int[] heap;
    private int size = 0;
    private int maxSize;

    private MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.heap[size] = Integer.MAX_VALUE;
        size++;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return 2 * pos;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    private void add(int element) {
        if (size >= maxSize) {
            return;
        }
        heap[size] = element;
        int current = size;
        size++;

        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private boolean isCorrect(int parentIndex, int childIndex) {
        if (parentIndex >= size || childIndex >= size) {
            return true;
        }
        return heap[parentIndex] > heap[childIndex];
    }

    private boolean isCorrectParent(int parentIndex) {
        return isCorrect(parentIndex, leftChild(parentIndex)) && isCorrect(parentIndex, rightChild(parentIndex));
    }

    private int getLargerChildIndex(int parentIndex) {
        int leftChildIndex = leftChild(parentIndex);
        int rightChildIndex = rightChild(parentIndex);

        if (rightChildIndex >= size) {
            return leftChildIndex;
        }
        return heap[leftChild(parentIndex)] > heap[rightChild(parentIndex)] ? leftChild(parentIndex) : rightChild(parentIndex);
    }

    private int remove() {
        size--;
        int element = heap[1];
        heap[1] = heap[size];
        heap[size] = 0;

        int current = 1;
        while (!isLeaf(current) && !isCorrectParent(current)) {
            int maxChildIndex = getLargerChildIndex(current);
            swap(current, maxChildIndex);
            current = maxChildIndex;
        }
        return element;
    }

    private void print() {
        for (int i = 1; i <= size / 2; i++) {

            // Printing the parent and both childrens
            System.out.print(
                    " PARENT : " + ((i) <= size ? heap[i] : null)
                            + " LEFT CHILD : " + ((2 * i < size) ? heap[2 * i] : null)
                            + " RIGHT CHILD :" + ((2 * i) + 1 < size ?  heap[(2 * i) + 1] : null));

            // By here new line is required
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(20);
        maxHeap.add(50);
        maxHeap.add(30);
        maxHeap.add(20);
        maxHeap.add(15);
        maxHeap.add(10);
        maxHeap.add(8);
        maxHeap.add(16);

        //maxHeap.print();

        System.out.println(maxHeap.remove());

        //maxHeap.print();

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
    }
}