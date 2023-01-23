package com.example.demoprojectreactor.operators.filter;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FilterOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void filter(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .filter(person -> person.getAge() > 27)
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void distinct(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .distinct()
                .subscribe(person -> LOG.info(person.toString()));

        Flux.fromIterable(List.of(1,1,2,2))
                .distinct()
                .subscribe(number -> LOG.info(number.toString()));
    }

    public void take(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .take(2)
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void takeLast(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .takeLast(2)
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void skip(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .skip(2)
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void skipLast(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(person -> LOG.info(person.toString()));
    }
}
