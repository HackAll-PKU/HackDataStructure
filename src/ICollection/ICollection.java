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

    /**
     * 增加一个元素
     * @param e 要增加的元素
     * @return 是否增加成功
     */
    boolean add(E e);

    /**
     * 移除一个元素
     * @param o 要移除的元素
     * @return 是否移除成功
     */
    boolean remove(Object o);

    /**
     * 清空Collection
     */
    void clear();

    /**
     * 是否包含某个元素
     * @param o 要检测的元素
     * @return 是否包含
     */
    boolean contains(Object o);

    /**
     * 求Collection大小
     * @return Collection的大小
     */
    int size();

    /**
     * Collection是否为空
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 获取某个下标的值
     * @param index 下标
     * @return 下标对应的值
     */
    E get(int index);

    /**
     * 获取某个元素对应的下标
     * @param o 某个元素
     * @return 元素对应的下标
     */
    int indexOf(Object o);

    /**
     * 将Collection转换为Array
     * @return 转换出来的Array
     */
    Object[] toArray();
}
