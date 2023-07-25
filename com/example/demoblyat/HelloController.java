package com.example.demoblyat;

import com.example.demoblyat.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    private final PersonsService personsService;

    public HelloController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/person/by-passport")
    public String getPersonInfoByPassport(@RequestParam("passport") String passport) {
        return personsService.getPersonByPassport(passport);
    }

    @GetMapping("/person/add")
    public String addPerson(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("passport") String passport,
                            @RequestParam("profession") Integer professions) {
        Person person = new Person(name, surname, passport, professions);
        personsService.addPerson(person);
        return "Person added successfully";
    }

    @GetMapping("/person/profession/add")
    public String addPersonProfession(@RequestParam("passport") String passport,
                                      @RequestParam("profession") Integer profession) {
        personsService.addProfession(passport,profession);
        return "Profession added successfully";
    }

    @GetMapping(path = "/persons/by-profession")
    public String getByProfession(@RequestParam("profession") int profession) {
         final List<Person> personsByProfession = personsService.getPersonsByProfession(profession);
//        String forPassport = null;
//        for (final Person person : personsByProfession) {
//
//            String passport = person.getPassport();
//            if (passport.startsWith("4")) {
//                forPassport = "~" + person.getPassport() + "~";
//            }
//        }
//        if (forPassport == null) {
//            throw new RuntimeException("Person not found");
//        }

        final Optional <String> passport = personsByProfession.stream()
                .map(e -> e.getPassport())
                .filter(p -> p.startsWith("5"))
                .map(p -> "~" + p + "~")
                .findAny()
                ;
        return passport.orElseThrow(() -> new RuntimeException("Person not found"));
    }
}

