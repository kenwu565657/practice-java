package com.practice.java.lang;

public interface Collection<E, L> extends Iterable<E> {
    boolean add(E e);
    boolean remove(E e);
    boolean addLink(String key, L link);
    boolean removeLink(String key);
    Iterator<E> iterator();
}
