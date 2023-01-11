package streams;

import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Mike", MALE),
                new Person("Bob", NON_BINARY),
                new Person("Shawn", PREFER_NOT_SAY),
                new Person("Pete", NON_BINARY),
                new Person("Mia", PREFER_NOT_SAY),
                new Person("Nicki", PREFER_NOT_SAY),
                new Person("Mike", NON_BINARY),
                new Person("Alice", PREFER_NOT_SAY)

        );

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
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

    enum Gender{
        MALE, FEMALE, NON_BINARY, PREFER_NOT_SAY
    }

}
