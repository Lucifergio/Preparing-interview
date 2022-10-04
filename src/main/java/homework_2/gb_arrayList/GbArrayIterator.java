package homework_2.gb_arrayList;

import java.util.Iterator;

public class GbArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    private E[] values;

    public GbArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
