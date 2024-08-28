package com.paginationExample.dto;

import com.paginationExample.model.Address;
import com.paginationExample.model.Book;

import java.util.HashMap;
import java.util.List;

public class PersonResponse {
    private Long id;
    private Boolean flag;
    private float value;
    private HashMap<String, List<String>> custome;
    private Address address;
    private List<Book> books;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public HashMap<String, List<String>> getCustome() {
        return custome;
    }

    public void setCustome(HashMap<String, List<String>> custome) {
        this.custome = custome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "id='" + id + '\'' +
                ", flag=" + flag +
                ", value=" + value +
                ", custome=" + custome +
                ", address=" + address +
                ", books=" + books +
                '}';
    }
}
