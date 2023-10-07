package chapter11;

import chapter11.source.Car;
import chapter11.source.Insurance;
import chapter11.source.Person;

import java.util.Optional;

public class Quiz1 {

//
//    public Optional<Insurance> nullSageFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
//        if (person.isPresent() && car.isPresent()) {
//            return Optional.of(findCheapestInsurance(person.get(), car.get()));
//        }else{
//            return Optional.empty();
//        }
//    }

    public Optional<Insurance> nullSageFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        // 다른 보험사에서 제공한 질의 서비스
        // 모든 데이터 비교
        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }
}
