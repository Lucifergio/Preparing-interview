package homework1;

import homework1.number1.Person;
import homework1.number3.*;

public class StartApp {
    public static void main(String[] args) {
        // №1
        Person person = new Person.PersonBuilder("Salnikov", "Aleksey")
                .setMiddleName("-")
                .setAge(24)
                .setAddress("Perm")
                .setPhone("79999999999")
                .setGender("Male")
                .setCountry("Russia")
                .build();

        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getMiddleName());
        System.out.println(person.getGender());
        System.out.println(person.getAddress());
        System.out.println(person.getCountry());
        System.out.println(person.getPhone());

        //№2

        WithCorners square = new Square();
        Square triangle = new Triangle();
        GeometricFigure circle = new Сircle();

        System.out.println(square.howManyCorners());
        System.out.println(triangle.howManyCorners() + triangle.whoAreYou());
        System.out.println(circle.whoAreYou());
    }
}
