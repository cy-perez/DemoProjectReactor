package com.example.demoprojectreactor.operators.transformation;

import com.example.demoprojectreactor.DemoProjectReactorApplication;
import com.example.demoprojectreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class TransformationOperators {

    private static final Logger LOG = LoggerFactory.getLogger(DemoProjectReactorApplication.class);

    // map transforma el-los dato(s) de entrada en uno(s) nuevo(s) -> Retorna un nuevo flujo de datos
    public void map(){

        /*List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .map(person -> {
                    person.setAge(person.getAge() + 10);
                    return person;
                })
                .subscribe(person -> LOG.info(person.toString()));*/

        Flux<Integer> flux = Flux.range(0, 10);
        Flux<Integer> flux2 = flux.map(x -> x + 10);
        flux2.subscribe(x -> LOG.info("Valor de x: " + x));
    }

    // flatMap pide como retorno otro flujo de datos (no retorna el objeto en sí)
    public void flatMap(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(8,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                .flatMap(person -> {
                    person.setAge(person.getAge() + 10);
                    return Mono.just(person);
                })
                .subscribe(person -> LOG.info(person.toString()));
    }

    public void groupBy(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(7,"Andrea",32));
        persons.add(new Person(7,"Diego", 24));
        persons.add(new Person(9,"Paula", 28));

        Flux.fromIterable(persons)
                //.groupBy(person -> person.getId())
                .groupBy(Person::getId) // Método de referencia > Java 8
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> LOG.info(x.toString()));
    }
}
