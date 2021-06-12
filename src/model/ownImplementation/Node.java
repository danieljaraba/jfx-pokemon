package model.ownImplementation;

import java.io.Serializable;

public class Node<E> implements Serializable {

    private static final long serialVersionUID = 5L;
    private E item;
    private Node<E> next;
    private Node<E> previous;
    private Node<E> root;

    public Node(E element) {
        this.item = element;
        this.next = null;
        this.previous = null;

    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}

