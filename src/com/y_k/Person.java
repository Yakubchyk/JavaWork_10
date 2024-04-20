package com.y_k;

import java.util.Objects;

public class Person implements Cloneable {
    private String name;
    private int age;
    private Dog dog;

    public Person(String name, int age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = dog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name '" + name + '\'' +
                ", age " + age +
                ", dog " + dog +
                '}';
    }

    // Ререписанный метод клона для глубокого клонирования.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person personCloned = (Person) super.clone();
        Dog dogCloned = (Dog) personCloned.getDog().clone();
        personCloned.setDog(dogCloned);
        return personCloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog);
    }
}


/*
Задача 1:
1.1 Создать класс Person с 3-мя полями (имя, возраст, зарплата).
1.2 Переопределить для этого класса hashCode(придумать свою формулу), toString(чтобы
выдавал всю информацию по человеку).
1.3 Создать класс Cat и добавить в Person поле этого типа (Cat). Соответственно
изменить toString().
1.4 В main создать объект Person, клонировать его, и поменять для копии имя. Проверить
в консоли с помощью toString что имена оригинала и копии действительно разные.
Сравнить объекты между собой используя equals
 */