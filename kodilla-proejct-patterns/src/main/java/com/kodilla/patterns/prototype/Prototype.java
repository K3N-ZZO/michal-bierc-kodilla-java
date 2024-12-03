package com.kodilla.patterns.prototype;

public abstract class Prototype<T> implements Cloneable {

    @Override
    public T clone() throws CloneNotSupportedException{
        return (T)super.clone();
    }

    public abstract Board shallowCopy() throws CloneNotSupportedException;
}
