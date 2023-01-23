package com.example.demoprojectreactor.operators.combination;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import com.example.demoprojectreactor.model.Sales;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CombinationOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void merge(){
        List<Person> personsListOne = new ArrayList<>();
        personsListOne.add(new Person(7,"Andrea",32));
        personsListOne.add(new Person(8,"Diego", 24));
        personsListOne.add(new Person(9,"Paula", 28));

        List<Person> personsListTwo = new ArrayList<>();
        personsListOne.add(new Person(10,"Camilo",22));
        personsListOne.add(new Person(11,"Luisa", 19));
        personsListOne.add(new Person(12,"Fernando", 27));

        List<Sales> sales = new ArrayList<>();
        sales.add(new Sales(1, LocalDateTime.now()));
        sales.add(new Sales(2, LocalDateTime.now()));
        sales.add(new Sales(3, LocalDateTime.now()));

        Flux<Person> fluxOne = Flux.fromIterable(personsListOne);
        Flux<Person> fluxTwo = Flux.fromIterable(personsListTwo);
        Flux<Sales> fluxThree = Flux.fromIterable(sales);

        Flux.merge(fluxOne, fluxTwo, fluxThree)
                .subscribe(person -> LOG.info(person.toString()));


    }

    public void zip(){
        List<Person> personsListOne = new ArrayList<>();
        personsListOne.add(new Person(7,"Andrea",32));
        personsListOne.add(new Person(8,"Diego", 24));
        personsListOne.add(new Person(9,"Paula", 28));

        List<Person> personsListTwo = new ArrayList<>();
        personsListOne.add(new Person(10,"Camilo",22));
        personsListOne.add(new Person(11,"Luisa", 19));
        personsListOne.add(new Person(12,"Fernando", 27));

        List<Sales> sales = new ArrayList<>();
        sales.add(new Sales(1, LocalDateTime.now()));
        sales.add(new Sales(2, LocalDateTime.now()));
        sales.add(new Sales(3, LocalDateTime.now()));

        Flux<Person> fluxOne = Flux.fromIterable(personsListOne);
        Flux<Person> fluxTwo = Flux.fromIterable(personsListTwo);
        Flux<Sales> fluxThree = Flux.fromIterable(sales);

//        Flux.zip(fluxOne, fluxTwo, (p1, p2) -> String.format("FluxOne: %s, FluxTwo: %s", p1, p2))
//                .subscribe(x -> LOG.info(x));

        Flux.zip(fluxOne, fluxTwo, fluxThree)
                .subscribe(x -> LOG.info(x.toString()));
    }

    public void zipWith(){
        List<Person> personsListOne = new ArrayList<>();
        personsListOne.add(new Person(7,"Andrea",32));
        personsListOne.add(new Person(8,"Diego", 24));
        personsListOne.add(new Person(9,"Paula", 28));

        List<Person> personsListTwo = new ArrayList<>();
        personsListOne.add(new Person(10,"Camilo",22));
        personsListOne.add(new Person(11,"Luisa", 19));
        personsListOne.add(new Person(12,"Fernando", 27));

        List<Sales> sales = new ArrayList<>();
        sales.add(new Sales(1, LocalDateTime.now()));
        sales.add(new Sales(2, LocalDateTime.now()));
        sales.add(new Sales(3, LocalDateTime.now()));

        Flux<Person> fluxOne = Flux.fromIterable(personsListOne);
        Flux<Person> fluxTwo = Flux.fromIterable(personsListTwo);
        Flux<Sales> fluxThree = Flux.fromIterable(sales);

        fluxOne.zipWith(fluxTwo, (p1, p2) -> String.format("FluxOne: %s, FluxTwo: %s", p1, p2))
                .subscribe(x -> LOG.info(x.toString()));
    }
}
