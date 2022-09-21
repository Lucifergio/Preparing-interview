package homework_2;

import homework_2.gb_arrayList.GbArrayList;
import homework_2.gb_arrayList.GbSimpleArrayList;
import homework_2.gb_linkedList.GbLinkedList;
import homework_2.gb_linkedList.GbSimpleLinkedList;

import java.util.ArrayList;

public class StartApp {
    public static void main(String[] args) {
        testMyLinkedList();
        testMyArrayList();

    }

    public static void testMyLinkedList() {
        System.out.println();
        System.out.println("Linked List");
        System.out.println("Test started...");

        GbLinkedList<Integer> testLinkedList = new GbSimpleLinkedList<>();

        testLinkedList.insertFirst(1);
        testLinkedList.insertFirst(2);
        testLinkedList.insertFirst(3);
        testLinkedList.insertFirst(4);
        testLinkedList.insertFirst(5);
        testLinkedList.insertFirst(6);

        System.out.println(testLinkedList.size());
        System.out.println(testLinkedList.contains(3));
        System.out.println(testLinkedList.isEmpty());
        testLinkedList.display();

        testLinkedList.removeFirst();
        testLinkedList.display();

        System.out.println("Test end...");
    }

    public static void testMyArrayList() {
        System.out.println();
        System.out.println("Array List");
        System.out.println("Test started...");

        GbArrayList<String> testArrayList = new GbSimpleArrayList<>();
        testArrayList.add("One");
        testArrayList.add("Two");
        testArrayList.add("Three");

        System.out.println(testArrayList.get(0));
        System.out.println(testArrayList.get(1));
        System.out.println(testArrayList.get(2));
        System.out.println(testArrayList.size());

        testArrayList.update(0, "Один");
        testArrayList.delete(2);

        System.out.println(testArrayList.get(0));
        System.out.println(testArrayList.size());

        System.out.println("Test end...");

    }
}
