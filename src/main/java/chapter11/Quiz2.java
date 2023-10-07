package chapter11;

import chapter11.source.Car;
import chapter11.source.Insurance;
import chapter11.source.Person;

import java.util.Optional;

public class Quiz2 {
    public static final String UNKNOWN = "Unknown";
    /*
    * ex 11-5의 getCarInsuranceName 메서드를 고쳐라
    * */

    public String getCarInsuranceName(Optional<Person> person, int minAge){
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse(UNKNOWN);
    }
}
