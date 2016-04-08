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
 * My Collection interface
 *
 * @param <E> the type of elements held in this collection
 * @author S.Hu
 */
public interface ICollection<E> {
    boolean add(E e);

    boolean remove(Object o);

    void clear();

    boolean contains(Object o);

    int size();

    boolean isEmpty();

    E get(int index);

    int indexOf(Object o);

    Object[] toArray();
}
