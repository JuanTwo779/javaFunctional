package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;

public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("juan", MALE),
            new Person("katie", FEMALE),
            new Person("Amigo", MALE),
            new Person("Amiga", FEMALE)
        );


        people.stream()
                .filter(person -> person.gender == MALE)
                .collect(Collectors.toList())
                .forEach(l -> System.out.println(l));

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(r -> System.out.println(r));

        people.stream()
                .map(person -> person.name)
                .mapToInt(name -> name.length())
                .forEach(name -> System.out.println(name));

        boolean onlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));

        boolean anyFemales = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));

        boolean noFemales = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));

        System.out.println(onlyFemales + " " + anyFemales + " " + noFemales);
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

    enum Gender {
        MALE, FEMALE
    }
}
