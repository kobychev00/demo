package com.example.demoblyat;

import com.example.demoblyat.domain.Driver;
import com.example.demoblyat.domain.Person;
import com.example.demoblyat.domain.TruckDriver;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonsServiceImpl implements PersonsService { //класс реализует интерфейс PersonService
    Map<String, Person> persons = new HashMap<>(Map.of(
            "12345",
            new Person(
                    "Жан",
                    "Рено",
                    "12345",
                    2),
            "44321",
            new Person(
                    "Люк",
                    "Бессон",
                    "44321",
                    0),
            "41232",
            new Person(
                    "Жерар",
                    "Депардье",
                    "41232",
                    0),
            "928372",
            new Driver(
                    "Джейсон",
                    "Стетхэм",
                    "928372",
                    "3491",
                    1),
            "1000",
            new TruckDriver(
                    "Роберт",
                    "Патрик",
                    "1000",
                    "2345",
                    3)
    ));

    Map<String, Integer> profession = Map.of(
            "безработный", 0,
            "водитель",1,
            "плотник",2,
            "столяр",3,
            "актер", 4
    );

    @Override
    public List<Person> getPersonsByProfession(Integer professionNumber) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().contains(professionNumber)) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public List<Person> getPersonsByProfessions(List<Integer> professionNumbers) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getProfessionNumbers().containsAll(professionNumbers)) {
                result.add(person);
            }
        }

        return persons.values().stream()
                .filter(e -> e.getProfessionNumbers().containsAll(professionNumbers))
                .collect(Collectors.toList());
    }


    @Override
    public void addPerson(Person person) {
        persons.put(person.getPassport(), person);

    }

    @Override
    public String getPersonByPassport(String passport) {
        final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек не найден");
        }
        final String personsDescription = " " // если индексы в рамках допустимых значений переход к методу personDiscription
                        + person.getName() + " "
                        + person.getSurname() + " "
                        + person.getPassport() + " "
                        + getProfessionNames(person.getProfessionNumbers());
                return personsDescription; // возвращаем описание с полями метода
            }

    private String getProfessionNames(Set<Integer> professionNumbers) {
        String result = "";
        for (Integer professionNumber : professionNumbers) {
            result = result + " " + profession.get(professionNumber);
        }
        return result;
    }

    @Override
    public void addProfession(String passport, Integer profession) {
       final Person person = persons.get(passport);
        if (person == null) {
            throw new RuntimeException("Человек с таким номером паспорта не найден");
        }
        person.getProfessionNumbers().add(profession);
    }

    String result = "";
        }

