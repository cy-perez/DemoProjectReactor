package com.example.demoprojectreactor;

import com.example.demoprojectreactor.model.Person;
import com.example.demoprojectreactor.operators.combination.CombinationOperators;
import com.example.demoprojectreactor.operators.conditionals.ConditionalsOperators;
import com.example.demoprojectreactor.operators.creation.CreationOperators;
import com.example.demoprojectreactor.operators.exceptions.ExceptionOperators;
import com.example.demoprojectreactor.operators.filter.FilterOperators;
import com.example.demoprojectreactor.operators.math.MathOperators;
import com.example.demoprojectreactor.operators.transformation.TransformationOperators;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoProjectReactorApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    public void reactor(){
        Mono.just(new Person(1, "Cristhian", 29))
                .doOnNext(person -> LOG.info("[Reactor] Person: " + person))
                .subscribe(person -> LOG.info("[Reactor] Person: " + person));;
    }

    public void rxJava2(){
        Observable.just(new Person(2, "Paola", 32))
                .doOnNext(person -> LOG.info("[Reactor] Person: " + person))
                .subscribe(person -> LOG.info("[rxJava2] Person: " + person));
    }

    public void mono(){
        Mono.just(new Person(3, "Camilo", 23)).subscribe(person -> LOG.info(person.toString()));
    }

    public void flux(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(4,"Alejandro",26));
        persons.add(new Person(5,"Sandra", 22));
        persons.add(new Person(6,"Franc", 30));

        Flux.fromIterable(persons).subscribe(person -> LOG.info(person.toString()));
    }

    public void fluxToMono(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux<Person> flux = Flux.fromIterable(persons);
        flux.collectList().subscribe(personlist -> LOG.info(personlist.toString()));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectReactorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        reactor();
//        rxJava2();
//        mono();
//        flux();
//        fluxToMono();

        // Creation Operators
        CreationOperators creationOperators = new  CreationOperators();
//        creationOperators.range();
//        creationOperators.repeat();

        // Transformation Operators
        TransformationOperators transformationOperators = new TransformationOperators();
//        transformationOperators.map();
//        transformationOperators.flatMap();
//        transformationOperators.groupBy();

        // Filter Operators
        FilterOperators filterOperators = new FilterOperators();
//        filterOperators.filter();
//        filterOperators.distinct();
//        filterOperators.take();
//        filterOperators.takeLast();
//        filterOperators.skip();
//        filterOperators.skipLast();

        // Combination Operators
        CombinationOperators combinationOperators = new CombinationOperators();
//        combinationOperators.merge();
//        combinationOperators.zip();
//        combinationOperators.zipWith();

        // Exception Operators
        ExceptionOperators exceptionOperators = new ExceptionOperators();
//        exceptionOperators.retry();
//        exceptionOperators.errorReturn();
//        exceptionOperators.errorResume();
//        exceptionOperators.errorMap();

        // Conditionals Operators
        ConditionalsOperators conditionalsOperators = new ConditionalsOperators();
//        conditionalsOperators.defaultIfEmpty();
//        conditionalsOperators.takeUntil();
//        conditionalsOperators.timeOut();

        MathOperators mathOperators = new MathOperators();
//        mathOperators.average();
//        mathOperators.count();
//        mathOperators.min();
//        mathOperators.sum();
        mathOperators.summarizing();
    }
}
