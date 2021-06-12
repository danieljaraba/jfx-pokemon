package model.ownImplementation;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * The type Me linked list.
 *
 * @param <E> the type parameter
 */
public class MeLinkedList<E> implements Serializable {

    private static final long serialVersionUID = 4L;
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Instantiates a new Me linked list.
     */
    public MeLinkedList() {
        head = null;
        size = 0;
        tail = null;
    }

    /**
     * Gets head.
     *
     * @return the head
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * Gets tail.
     *
     * @return the tail
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return (head == null)? true: false;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Add.
     *
     * @param e the e
     */
    public void add(E e) {

        if (head == null) {
            head = new Node<E>(e);
            tail = head;

        }else{
            add(e, tail, 0);

        }

        size += 1;
    }

    private void add(E e, Node<E> temp, int vali) {

        if(vali == 0){
            temp.setNext(new Node<E>(e));
            temp.getNext().setPrevious(temp);
            tail = temp.getNext();
            vali += 1;
        }

        if(temp.getPrevious() != null && vali == 1){
            add(e, temp.getPrevious(), vali);

        }else{
            head = temp;
        }

    }

    /**
     * Index of int.
     *
     * @param e the e
     * @return the int
     */
    public int indexOf(E e){
        return indexOf(e, head, 0);
    }

    private int indexOf(E e, Node<E> temp, int contador){
        if(e.equals(temp.getItem())){
            return contador;

        }else{
            return indexOf(e, temp.getNext(), contador + 1);

        }
    }


    /**
     * Get e.
     *
     * @param index the index
     * @return the e
     */
    public E get(int index){

        return get(index, head);

    }

    private E get(int index, Node<E> temp){

        if(index == 0){
            return temp.getItem();

        }else{
            return get(index - 1, temp.getNext());

        }

    }

    /**
     * Get node node.
     *
     * @param index the index
     * @return the node
     */
    public Node<E> getNode(int index){

        return getNode(index, head);

    }

    private Node<E> getNode(int index, Node<E> temp){

        if(index == 0){
            return temp;

        }else{
            return getNode(index - 1, temp.getNext());

        }

    }

    /**
     * Remove.
     *
     * @param index the index
     */
    public void remove(int index){
        if(index == 0){
            head = head.getNext();

        }else{
            getNode(index).getPrevious().setNext(getNode(index).getNext());
            getNode(index).getNext().setPrevious(getNode(index).getPrevious());
        }

        size -= 1;
    }

    /**
     * Array to me list.
     *
     * @param array the array
     */
    public void arrayToMeList(ArrayList<E> array){

        head = null;
        tail = null;

        for (int i = 0; i < array.size(); i++){
            add(array.get(i));

        }


    }

    /**
     * To array array list.
     *
     * @return the array list
     */
    public ArrayList<E> toArray(){
        ArrayList<E> array = new ArrayList<E>();

        for (int i = 0; i < size; i++){
            array.add(get(i));

        }

        return array;

    }



}

