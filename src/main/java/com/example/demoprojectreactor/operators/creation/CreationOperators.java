package com.example.demoprojectreactor.operators.creation;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class CreationOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void justFrom(){
        Mono.just(new Person(1, "Cristhian",29));
        //Flux.fromIterable(collect);
        //Observable.just(item);
    }

    public void empty(){
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range(){
        Flux.range(0,3)
                .doOnNext(i -> LOG.info("i: " + i))
                .subscribe();
    }

    public void repeat(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .repeat(3)
                .subscribe(person -> LOG.info(person.toString()));

        Mono.just(new Person(10, "Carlos", 23))
                .repeat(3)
                .subscribe(person -> LOG.info(person.toString()));
    }
}
