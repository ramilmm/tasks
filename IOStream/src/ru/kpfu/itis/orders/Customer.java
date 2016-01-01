package ru.kpfu.itis.orders;

import java.io.Serializable;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:15:16
 */
public class Customer implements Comparable, Serializable {
    private long id;
    private String name;
    private String email;
    private Address address;

    public Customer() {
    }

    public Customer(long id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int compareTo(Object o) {
        Customer c = (Customer) o;
        return (int) (id - c.getId());
    }
}
