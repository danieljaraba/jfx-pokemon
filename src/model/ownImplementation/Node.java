package model.ownImplementation;

import java.io.Serializable;

/**
 * The type Node.
 *
 * @param <E> the type parameter
 */
public class Node<E> implements Serializable {

    private static final long serialVersionUID = 5L;
    private E item;
    private Node<E> next;
    private Node<E> previous;
    private Node<E> root;

    /**
     * Instantiates a new Node.
     *
     * @param element the element
     */
    public Node(E element) {
        this.item = element;
        this.next = null;
        this.previous = null;

    }

    /**
     * Gets root.
     *
     * @return the root
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * Sets root.
     *
     * @param root the root
     */
    public void setRoot(Node<E> root) {
        this.root = root;
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    public void setItem(E item) {
        this.item = item;
    }

    /**
     * Gets item.
     *
     * @return the item
     */
    public E getItem() {
        return item;
    }

    /**
     * Gets next.
     *
     * @return the next
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets next.
     *
     * @param next the next
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Gets previous.
     *
     * @return the previous
     */
    public Node<E> getPrevious() {
        return previous;
    }

    /**
     * Sets previous.
     *
     * @param previous the previous
     */
    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}

