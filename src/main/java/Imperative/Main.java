package Imperative;

import java.util.ArrayList;
import java.util.List;

import static Imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("juan", MALE),
            new Person("katie", FEMALE),
            new Person("Amigo", MALE),
            new Person("Amiga", FEMALE)
        );

        //Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person: people) {
            if (FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person person : females ) {
            System.out.println(person);
        }
    }



    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }


    //special class that enables for a variable to be a set of predefined constants
    enum Gender {
        MALE, FEMALE
    }
}
