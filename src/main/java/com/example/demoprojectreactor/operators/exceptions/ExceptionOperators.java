package com.example.demoprojectreactor.operators.exceptions;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ExceptionOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void retry(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Simulación de error")))
                .retry(1)
                .doOnNext(x -> LOG.info(x.toString()))
                .subscribe();
    }

    public void errorReturn(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Simulación de error")))
                .onErrorReturn(new Person(0, "XYX", 99))
                .subscribe(x -> LOG.info(x.toString()));
    }

    public void errorResume(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Simulación de error")))
                .onErrorResume(e -> Mono.just(new Person(0, "XYZ", 99)))
                .subscribe(x -> LOG.info(x.toString()));
    }

    public void errorMap(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Simulación de error")))
                .onErrorMap(e -> new InterruptedException(e.getMessage()))
                .subscribe(x -> LOG.info(x.toString()));
    }
}
