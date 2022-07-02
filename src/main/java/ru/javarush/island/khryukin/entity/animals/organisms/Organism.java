package ru.javarush.island.khryukin.entity.animals.organisms;

import ru.javarush.island.khryukin.actions.Reproducible;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Organism implements Cloneable, Reproducible {

    private final static AtomicLong idCounter = new AtomicLong(System.currentTimeMillis());

    private final long id = idCounter.incrementAndGet();
    private String name;
    private String icon;
    private double weight;
    private Limit limit;

    public Organism(String name, String icon, double weight, Limit limit) {
        this.name = name;
        this.icon = icon;
        this.weight = weight;
        this.limit = limit;
    }


    public long getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Limit getLimit() {
        return limit;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    @Override
    public Organism clone() {
        try {
            //TODO ---  id==id?
            return (Organism) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("cannot clone " + this);
        }
    }
}
