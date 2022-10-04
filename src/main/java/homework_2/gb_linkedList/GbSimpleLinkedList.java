package homework_2.gb_linkedList;

public class GbSimpleLinkedList<E> implements GbLinkedList<E> {

    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        size--;
        removedNode.next = null;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        return false;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;
        while (current != null){
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            stringBuilder.append(current.item);
            if (current.next != null) {
                stringBuilder.append(", ");
            }
            current = current.next;
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public E getFirst() {
        return null;
    }
}
