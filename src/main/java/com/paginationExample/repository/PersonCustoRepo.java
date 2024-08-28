package com.paginationExample.repository;

import com.paginationExample.model.Person;
import com.paginationExample.model.PersonCustome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonCustoRepo extends JpaRepository<PersonCustome, Long>{



}
