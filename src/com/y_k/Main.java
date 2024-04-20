package com.y_k;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("Vitya", 18, new Dog("Bobik"));
        Person person1 = (Person) person.clone();

        person1.getDog().setName("Verena");
        person1.setName("Ivan");

        System.out.println(person);
        System.out.println(person1);
    }
}
