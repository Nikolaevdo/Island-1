package ru.javarush.island.belyanchik.entity;

import java.lang.reflect.InvocationTargetException;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueOrganism<T> {
    //** очередь из организмов одного вида
    private int capacity; // максимальная ёмкость очереди
    private LinkedBlockingDeque<T> deque;

    public QueueOrganism(int capacity) {
        this.capacity = capacity;
        this.deque = new LinkedBlockingDeque<>(capacity);
    }

    public Deque<T> getDeque() {
        return deque;
    }

    public void setDeque(LinkedBlockingDeque<T> deque) {
        this.deque = deque;
    }

    public int getSize() {
        return deque.size();
    }

    public int getCapacity() {
        return capacity;
    }

    /*    public QueueOrganism(int capacity) {
        this.deque = (Deque<T>) new LinkedBlockingQueue<T>(capacity);
    }*/

    // очередь надо синхронизировать, потому, что её могут использовать несколько потоков.
    // добавить организм в конец очереди
    //public void add (Organism organism) {deque.addLast(organism);}
    // public organism pool(){ return deque.pollFirst(); }

    public void add(T organism) {
        deque.addLast(organism);
        //System.out.println(organism.hashCode());
    }

    public T pool() {
        return deque.pollFirst();
    }

    public boolean pool(T organism) {
        return deque.remove(organism);
    }

    // добавить новый организм сласса clazz  в очередь ячейки
    public void addNewOrganismInQueue(Class clazz, int col, int row, boolean newBorn) {
        try {
            Class[] params = {int.class, int.class, boolean.class};
            this.deque.add((T) clazz.getConstructor(params).newInstance(col, row, newBorn));
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
