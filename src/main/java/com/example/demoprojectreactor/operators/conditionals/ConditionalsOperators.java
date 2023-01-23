package com.example.demoprojectreactor.operators.conditionals;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ConditionalsOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void defaultIfEmpty(){
        //Mono.empty()
        Flux.empty()
                .defaultIfEmpty(new Person(0, "Default", 99))
                .subscribe(x -> LOG.info(x.toString()));
    }

    public void takeUntil(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",17));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .takeUntil(p -> p.getAge() > 17)
                .subscribe(x -> LOG.info(x.toString()));
    }

    public void timeOut() throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",17));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .delayElements(Duration.ofSeconds(3))
                .timeout(Duration.ofSeconds(4))
                .subscribe(x -> LOG.info(x.toString()));

        Thread.sleep(10000);
    }
}
