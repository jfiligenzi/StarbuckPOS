package com.example.starbuckspos;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {
    //All defaults for binary search tree class
    public boolean search(E e);

    public boolean insert(E e);

    public boolean delete(E e);

    public int getSize();

    public default void inorder() throws NoSuchFieldException, IllegalAccessException {

    }

    public default void preorder() {

    }

    public default void postorder() {

    }
    @Override
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public default boolean contains(Object e) {
        return search((E)e);
    }

    @Override
    public default boolean add(E e) {
        return insert(e);
    }

    @Override
    public default boolean remove(Object e) {
        return delete((E) e);
    }

    @Override
    public default int size() {
        return getSize();
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        return false;
    }


}
