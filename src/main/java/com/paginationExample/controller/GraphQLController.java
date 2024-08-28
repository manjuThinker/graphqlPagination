package com.paginationExample.controller;

import com.paginationExample.dto.PersonResponse;
import com.paginationExample.model.Person;
import com.paginationExample.paginationUtilites.PageInfo;
import com.paginationExample.paginationUtilites.PersonResponseConnection;
import com.paginationExample.paginationUtilites.PersonResponseEdge;
import com.paginationExample.request.PersonInput;
import com.paginationExample.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private PersonService personService;

    @QueryMapping
    public PersonResponse getPerson(@Argument("id") Long id) {

        return personService.getPersonById(id);
    }
    @QueryMapping
    public PersonResponseConnection getAllPerson(@Argument Integer first, @Argument Integer last, @Argument String before, @Argument String after) {
        List<PersonResponse> persons = personService.getAllPerson();
        List<PersonResponseEdge> edges = new ArrayList<>();
        PageInfo pageInfo = new PageInfo();

        int startIndex = 0;
        int endIndex = persons.size();

        if (after != null) {
            startIndex = findIndexByCursor(persons, after) + 1;
        } else if (before != null) {
            endIndex = findIndexByCursor(persons, before);
        }

        if (first != null) {
            endIndex = Math.min(startIndex + first, endIndex);
        } else if (last != null) {
            startIndex = Math.max(endIndex - last, startIndex);
        }

        for (int i = startIndex; i < endIndex; i++) {
            PersonResponse person = persons.get(i);
            PersonResponseEdge edge = new PersonResponseEdge();
            edge.setNode(person);
            edge.setCursor(generateCursor(person));
            edges.add(edge);
        }

        pageInfo.setStartCursor(edges.isEmpty() ? null : edges.get(0).getCursor());
        pageInfo.setEndCursor(edges.isEmpty() ? null : edges.get(edges.size() - 1).getCursor());
        pageInfo.setHasNextPage(endIndex < persons.size());
        pageInfo.setHasPreviousPage(startIndex > 0);

        PersonResponseConnection connection = new PersonResponseConnection();
        connection.setEdges(edges);
        connection.setPageInfo(pageInfo);
        return connection;
    }

    private int findIndexByCursor(List<PersonResponse> persons, String cursor) {
        for (int i = 0; i < persons.size(); i++) {
            if (generateCursor(persons.get(i)).equals(cursor)) {
                return i;
            }
        }
        return -1;
    }

    private String generateCursor(PersonResponse person) {
        return Base64.getEncoder().encodeToString(person.getId().toString().getBytes());
    }




    @MutationMapping
    public PersonResponse createPerson(@Argument("person") PersonInput personInput) {
        System.out.println("manju   " + personInput);
        return personService.createPerson(personInput);
    }
}

