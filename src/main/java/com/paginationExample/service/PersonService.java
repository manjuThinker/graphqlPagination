package com.paginationExample.service;

import com.paginationExample.dto.PersonResponse;
import com.paginationExample.model.Address;
import com.paginationExample.model.Book;
import com.paginationExample.model.Person;
import com.paginationExample.model.PersonCustome;
import com.paginationExample.repository.PersonCustoRepo;
import com.paginationExample.repository.PersonRepository;
import com.paginationExample.request.AddressInput;
import com.paginationExample.request.BookInput;
import com.paginationExample.request.PersonInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonCustoRepo personCustoRepo;

    public PersonResponse getPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        return mapToResponse(person);
    }

    public PersonResponse createPerson(PersonInput personInput) {
        Person person = new Person();
        person.setFlag(personInput.getFlag());
        person.setValue(personInput.getValue());
        person.setCustome(mapToPersonCustome(personInput.getCustome()));
        person.setAddress(mapToAddress(personInput.getAddress()));
        person.setBooks(mapToBooks(personInput.getBooks()));

        for(PersonCustome personCustome:person.getCustome()){
        personCustoRepo.save(personCustome);
        }
        personRepository.save(person);
        return mapToResponse(person);
    }

    public List<PersonResponse> getAllPerson() {
        List<Person> persons = personRepository.findAll();
        if (persons.isEmpty()) {
            throw new RuntimeException("Person not found");
        }
        return mapToResponseList(persons);
    }


    private PersonResponse mapToResponse(Person person) {
        PersonResponse response = new PersonResponse();
        response.setId(person.getId());
        response.setFlag(person.getFlag());
        response.setValue(person.getValue());
        response.setCustome(PersonCustomeToMap(person.getCustome()));
        response.setAddress(person.getAddress());
        response.setBooks(person.getBooks());
        return response;
    }
    private List<PersonResponse> mapToResponseList(List<Person> person) {
        List<PersonResponse> personResponseList= new ArrayList<>();
        for(Person person1:person) {
            PersonResponse response = new PersonResponse();
            response.setId(person1.getId());
            response.setFlag(person1.getFlag());
            response.setValue(person1.getValue());
            response.setCustome(PersonCustomeToMap(person1.getCustome()));
            response.setAddress(person1.getAddress());
            response.setBooks(person1.getBooks());
            personResponseList.add(response);
        }
        return personResponseList;
    }

    private List<PersonCustome> mapToPersonCustome(HashMap<String, List<String>> customer) {
        List<PersonCustome> personCustomeList = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : customer.entrySet()) {
            PersonCustome personCustome = new PersonCustome();
            personCustome.setKey(entry.getKey());
            personCustome.setValue(entry.getValue());
            personCustomeList.add(personCustome);
        }

        return personCustomeList;
    }

    private HashMap<String, List<String>> PersonCustomeToMap(List<PersonCustome> personCustomeList) {
        HashMap<String, List<String>> personCustomeMap = new HashMap<>();

        for (PersonCustome personCustome:personCustomeList) {
            personCustomeMap.put(personCustome.getKey(),personCustome.getValue());
        }

        return personCustomeMap;
    }

    private Address mapToAddress(AddressInput addressInput) {
        Address address = new Address();
        address.setStreet(addressInput.getStreet());
        address.setCity(addressInput.getCity());
        return address;
    }

    private List<Book> mapToBooks(List<BookInput> bookInputs) {
        return bookInputs.stream().map(bookInput -> {
            Book book = new Book();
            book.setTitle(bookInput.getTitle());
            book.setAuthor(bookInput.getAuthor());
            return book;
        }).collect(Collectors.toList());
    }
}
