package com.pp.dgexample.builder2;

/**
 * @Title
 * @Description
 * @Author ppliang
 * @Date 2020/3/8
 */
public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location location;

    private Person() {
    }

    public static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }


        public PersonBuilder weight(double weight) {
            person.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            person.score = score;
            return this;
        }

        public PersonBuilder location(String street, String roomNo) {
            person.location = new Location(street, roomNo);
            return this;
        }

        public Person builder() {
            return person;
        }

    }
}


class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
