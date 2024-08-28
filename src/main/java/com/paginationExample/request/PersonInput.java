package com.paginationExample.request;

import java.util.HashMap;
import java.util.List;

public class PersonInput {
    private Boolean flag;
    private float value;
    private HashMap<String, List<String>> custome;
    private AddressInput address;
    private List<BookInput> books;



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

    public AddressInput getAddress() {
        return address;
    }

    public void setAddress(AddressInput address) {
        this.address = address;
    }

    public List<BookInput> getBooks() {
        return books;
    }

    public void setBooks(List<BookInput> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "PersonInput{" +
                "flag=" + flag +
                ", value=" + value +
                ", custome=" + custome +
                ", address=" + address +
                ", books=" + books +
                '}';
    }
}