package ru.kpfu.itis.orders;

/**
 * @author Gataullin Kamil
 * 16.08.2014 22:12:57
 */
public class Address {
    private long id;
    private String city;
    private String street;
    private String house;
    private String flat;

    public Address() {
    }

    public Address(String flat, long id, String city, String street, String house) {
        this.flat = flat;
        this.id = id;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }
}
