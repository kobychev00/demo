package com.example.demoblyat;

import com.example.demoblyat.domain.Person;
import exeptions.BadPersonNumberException;

import java.util.List;

public interface PersonsService {

    List<Person> getPersonsByProfession(Integer professionNumber);

    List<Person> getPersonsByProfessions(List<Integer> professionNumbers);

    void addPerson(Person person);

    String getPersonByPassport(String passport);

    void addProfession(String passport, Integer professions);
}
