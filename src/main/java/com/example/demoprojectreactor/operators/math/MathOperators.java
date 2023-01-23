package com.example.demoprojectreactor.operators.math;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MathOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);
    public void average(){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void count(){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .count()
                .subscribe(x -> LOG.info("Cantidad de elementos: " + x));
    }

    public void min(){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(person -> LOG.info(person.get().toString()));
    }

    public void sum(){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(x -> LOG.info("Suma de las edades: " + x));
    }

    public void summarizing(){

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(x -> LOG.info("Descripción de las edades: " + x));
    }
}
