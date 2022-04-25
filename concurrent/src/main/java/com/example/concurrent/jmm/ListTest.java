package com.example.concurrent.jmm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: by
 * @Date: 2022/1/25 08:59
 * @Description:1
 */
public class ListTest {
    public static void main(String[] args) {
        int[] i = {1, 2, 6};
        List list = new ArrayList(2);

        list.add(0,"test2");
        list.add("test2");
        list.add("test3");


        System.out.println(3 * 1.5);
        System.out.println(3 + (3 >> 1));
    }

    /**
     * 源码分析：
     * 数组结构
     *存/取元素效率非常的高(get/set)
     *
     * 基本属性：
     * private static final long serialVersionUID = 8683452581122892189L;//序列化版本号（类文件签名），如果不写会默认生成，类内容的改变会影响签名变化，导致反序列化失败
     * private static final int DEFAULT_CAPACITY = 10;//如果实例化时未指定容量，则在初次添加元素时会进行扩容使用此容量作为数组长度
     * //static修饰，所有的未指定容量的实例(也未添加元素)共享此数组，两个空的数组有什么区别呢？ 就是第一次添加元素时知道该 elementData 从空的构造函数还是有参构造函数被初始化的。以便确认如何扩容。空的构造器则初始化为10，有参构造器则按照扩容因子扩容
     * private static final Object[] EMPTY_ELEMENTDATA = {};
     * private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     * transient Object[] elementData; // arrayList真正存放元素的地方，长度大于等于size
     *
     *
     *
     *
     * 构造器分析：
     *
     * //无参构造器，构造一个容量大小为 10 的空的 list 集合，但构造函数只是给 elementData 赋值了一个空的数组，其实是在第一次添加元素时容量扩大至 10 的。
     * public ArrayList() {
     *     this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     * }
     * //当使用无参构造函数时是把 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 赋值给 elementData。 当 initialCapacity 为零时则是把 EMPTY_ELEMENTDATA 赋值给 elementData。 当 initialCapacity 大于零时初始化一个大小为 initialCapacity 的 object 数组并赋值给 elementData。
     * public ArrayList(int initialCapacity) {
     *     if (initialCapacity > 0) {
     *         this.elementData = new Object[initialCapacity];
     *     } else if (initialCapacity == 0) {
     *         this.elementData = EMPTY_ELEMENTDATA;
     *     } else {
     *         throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
     *     }
     * }
     * //将 Collection 转化为数组，数组长度赋值给 size。 如果 size 不为零，则判断 elementData 的 class 类型是否为 ArrayList，不是的话则做一次转换。 如果 size 为零，则把 EMPTY_ELEMENTDATA 赋值给 elementData，相当于new ArrayList(0)。
     * public ArrayList(Collection<? extends E> c) {
     *     Object[] a = c.toArray();
     *     if ((size = a.length) != 0) {
     *         if (c.getClass() == ArrayList.class) {
     *             elementData = a;
     *         } else {
     *             elementData = Arrays.copyOf(a, size, Object[].class);
     *         }
     *     } else {
     *         // 指向空数组
     *         elementData = EMPTY_ELEMENTDATA;
     *     }
     *
     *
     * 新增元素的方法尾部添加法
     * 效率比较高
     *查询复杂度时间复杂度为O(1) ，删除插入为O(n)
     *
     *
     *扩容：
     *
     * private void grow(int minCapacity) {
     *     int oldCapacity = elementData.length;//获取当前数组长度
     *     int newCapacity = oldCapacity + (oldCapacity >> 1);//默认将扩容至原来容量的 1.5 倍
     *     if (newCapacity - minCapacity < 0)//如果1.5倍太小的话，则将我们所需的容量大小赋值给newCapacity
     *         newCapacity = minCapacity;
     *     if (newCapacity - MAX_ARRAY_SIZE > 0)//如果1.5倍太大或者我们需要的容量太大，那就直接拿 newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE 来扩容
     *         newCapacity = hugeCapacity(minCapacity);
     *     elementData = Arrays.copyOf(elementData, newCapacity);//然后将原数组中的数据复制到大小为 newCapacity 的新数组中，并将新数组赋值给 elementData。
     *
     *
     */
}
