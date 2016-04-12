/*
 * Copyright (c) 2016 hackerAll.
 *
 * Verbatim copying and distribution of this program is permitted, provided this notice is preserved.
 */

package ICollection;

/**
 * Created by HuShunxin on 16/4/8.
 */

/**
 * Doubly-linked list.
 *
 * @param <E> the type of elements held in this collection
 * @author S.Hu
 */
public class MyList<E> implements ICollection<E> {

    private Node<E> First;
    private Node<E> Last;
    private int size = 0;

    /**
     * Links element e as the first element.
     */
    private void linkFirst(E e) {
        Node<E> oldFirst = First;
        Node<E> newNode = new Node<E>(null, oldFirst, e);
        First = newNode;
        if (oldFirst == null)
            Last = newNode;
        else
            oldFirst.Previous = newNode;
        size++;
    }

    /**
     * Links element e as the last element.
     */
    private void linkLast(E e) {
        Node<E> oldLast = Last;
        Node<E> newNode = new Node<E>(oldLast, null, e);
        Last = newNode;
        if (oldLast == null)
            First = newNode;
        else
            oldLast.Next = newNode;
        size++;
    }

    /**
     * Inserts element e before non-null Node x.
     */
    private void linkBefore(E e, Node<E> x) {
        Node<E> oldPrevious = x.Previous;
        Node<E> newNode = new Node<E>(x.Previous, x, e);
        x.Previous = newNode;

        //x is the first Node
        if (oldPrevious == null) {
            First = newNode;
        } else {
            oldPrevious.Next = newNode;
        }

        size++;
    }

    /**
     * Unlinks the specified Node from this list.
     *
     * @param x ByRef the Node to Unlink
     * @return the Value of the unlinked Node
     */
    private E unlink(Node<E> x) {
        //x is the first node
        if (x.Previous == null) {
            First = x.Next;
        } else {
            x.Previous.Next = x.Next;
        }

        //x is the last node
        if (x.Next == null) {
            Last = x.Previous;
        } else {
            x.Next.Previous = x.Previous;
        }

        size--;
        return x.Value;
    }

    /**
     * Finds the index of the first appearance of the specified element o.
     *
     * @param o the element to find
     * @return the index of the first appearance of o
     */
    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> nodeLoop = First; nodeLoop != null; nodeLoop = nodeLoop.Next) {
                if (nodeLoop.Value == null) return index;
                index++;
            }
        } else {
            for (Node<E> nodeLoop = First; nodeLoop != null; nodeLoop = nodeLoop.Next) {
                if (o.equals(nodeLoop.Value)) return index;
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns the index-th Node.
     */
    private Node<E> node(int index) {
        Node<E> it;
        if (index < size / 2) {
            it = First;
            for (int i = 0; i < index; i++)
                it = it.Next;
        } else {
            it = Last;
            for (int i = size - 1; i > index; i--) {
                it = it.Previous;
            }
        }
        return it;
    }

    /**
     * Appends the specified element to the proper position of this list.
     *
     * @param e the element to append
     * @return true
     */
    @Override
    public boolean add(E e) {
        if (e instanceof Comparable) {
            for (Node<E> x = First; x != null; x = x.Next) {
                if (((Comparable) e).compareTo(x.Value) <= 0) {
                    linkBefore(e, x);
                    return true;
                }
            }
        }

        linkLast(e);
        return true;
    }

    /**
     * Removes the first appearance of the specified element o.
     *
     * @param o the element to be removed
     * @return whether o is found in the list
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> nodeLoop = First; nodeLoop != null; nodeLoop = nodeLoop.Next) {
                if (nodeLoop.Value == null) {
                    unlink(nodeLoop);
                    return true;
                }
            }
        } else {
            for (Node<E> nodeLoop = First; nodeLoop != null; nodeLoop = nodeLoop.Next) {
                if (o.equals(nodeLoop.Value)) {
                    unlink(nodeLoop);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Clears this list.
     */
    @Override
    public void clear() {
        First = null;
        Last = null;
        size = 0;
    }

    /**
     * Returns whether this list contains the specified element o.
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns the size of this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the index-th element.
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return node(index).Value;
    }

    /**
     * Returns an array containing all of the elements in this list.
     */
    @Override
    public Object[] toArray() {
        Object[] myArray = new Object[size];
        int index = 0;
        for (Node<E> i = First; i != null; i = i.Next) {
            myArray[index++] = i.Value;
        }
        return myArray;
    }

    /**
     * Returns whether this list is Empty.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Node class.
     */
    private static class Node<E> {
        Node<E> Previous;
        Node<E> Next;
        E Value;

        Node(Node<E> previous, Node<E> next, E value) {
            Previous = previous;
            Next = next;
            Value = value;
        }
    }

}
