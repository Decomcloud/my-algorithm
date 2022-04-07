package cloud.seemygo.list;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @author Yunfeng Sun
 * @date 2021/3/25 13:06
 */
public class DemoList<E> extends AbstractList<E> {

    public static void main(String[] args) {
        DemoList<Object> list  = new DemoList<>();
        list.add(10);
        list.add(new Person(10, "Jack"));
        list.add(22);

        list.indexOf(new Person(10, "Jack"));


        DemoList<Object> persons  = new DemoList<>();
		persons.add(new Person(10, "Jack"));
		persons.add(null);
		persons.add(new Person(15, "Rose"));
		persons.add(null);
		persons.add(new Person(12, "James"));
		persons.add(null);

		System.out.println(persons.indexOf(null));
    }

    @Data
    @AllArgsConstructor
    public static class Person {
        private int age;
        private String name;
    }

    static void test() {
        // int -> Integer

        // 所有的类，最终都继承java.lang.Object

        // new是向堆空间申请内存
        DemoList<Person> persons  = new DemoList<>();
        persons.add(new Person(10, "Jack"));
        persons.add(new Person(12, "James"));
        persons.add(new Person(15, "Rose"));
        persons.clear();
        persons.add(new Person(22, "abc"));

        System.out.println(persons);
        DemoList<Integer> ints  = new DemoList<>();
        ints.add(10);
        ints.add(10);
        ints.add(22);
        ints.add(33);
        System.out.println(ints);
    }

    private int size;

    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public DemoList(int capaticy) {
        capaticy = Math.max(capaticy, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capaticy];
    }

    public DemoList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void add(E element) {
        add(size, element);
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        rangeCheck(index);

        E old = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }

    public int indexOf(E element) {
        //if (element == null) {  // 1
        //    for (int i = 0; i < size; i++) {
        //        if (elements[i] == null) return i;
        //    }
        //} else {
        //    for (int i = 0; i < size; i++) {
        //        if (element.equals(elements[i])) return i; // n
        //    }
        //}
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, elements[i])) return i; // n
        }
        return ELEMENT_NOT_FOUND;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        // size=3, [99, 88, 77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
