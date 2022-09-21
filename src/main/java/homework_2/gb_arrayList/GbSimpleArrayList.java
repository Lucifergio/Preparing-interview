package homework_2.gb_arrayList;

import java.util.Iterator;

public class GbSimpleArrayList<E> implements GbArrayList<E> {

    private E[] values;

    public GbSimpleArrayList() {
        values = (E[]) new Object[0];
    }
    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        }catch (ClassCastException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {

        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int elementAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, elementAfterIndex);
        }catch (ClassCastException exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new GbArrayIterator<>(values);
    }
}
