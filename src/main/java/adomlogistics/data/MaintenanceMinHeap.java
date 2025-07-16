package adomlogistics.data;

import adomlogistics.model.Vehicle;

public class MaintenanceMinHeap {
    private Vehicle[] heap;
    private int size;
    public MaintenanceMinHeap(int capacity) {
        heap = new Vehicle[capacity];
        size = 0;
    }
    public boolean isEmpty() { return size == 0; }
    public void insert(Vehicle v) {
        if (size == heap.length) return;
        heap[size] = v;
        int i = size++;
        while (i > 0 && heap[parent(i)].getMileage() > heap[i].getMileage()) {
            Vehicle tmp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = tmp;
            i = parent(i);
        }
    }
    public Vehicle extractMin() {
        if (isEmpty()) return null;
        Vehicle min = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return min;
    }
    private void heapify(int i) {
        int l = left(i), r = right(i), smallest = i;
        if (l < size && heap[l].getMileage() < heap[smallest].getMileage()) smallest = l;
        if (r < size && heap[r].getMileage() < heap[smallest].getMileage()) smallest = r;
        if (smallest != i) {
            Vehicle tmp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = tmp;
            heapify(smallest);
        }
    }
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }
} 