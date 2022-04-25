package com.example.concurrent.jmm;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: by
 * @Date: 2022/2/12 22:50
 * @Description:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List list =new LinkedList();
        list.add("ee");

    }

    /**n
     * 源码刨析：
     * 链表结构
     * 删除，插入快，时间复杂度是时间复杂度是O(1),查询复杂度时间复杂度为O()
     *
     *
     *
     * 结构双向列表：
     *
     *     private static class Node<E> {
     *         E item;
     *         Node<E> next;
     *         Node<E> prev;
     *
     *         Node(Node<E> prev, E element, Node<E> next) {
     *             this.item = element;
     *             this.next = next;
     *             this.prev = prev;
     *         }
     *     }
     *
     *
     */

}
