package com.example.maintenancerequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String personname;
    private Integer apartmentnumber;
    private String phonenumber;
    private String email;
    private String checkin;
    private String checkout;

    public Person() {
    }

    public Person(Integer id, String personname, Integer apartmentnumber, String phonenumber, String email, String checkin, String checkout) {
        this.id = id;
        this.personname = personname;
        this.apartmentnumber = apartmentnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Person(String personname, Integer apartmentnumber, String phonenumber, String email, String checkin, String checkout) {
        this.personname = personname;
        this.apartmentnumber = apartmentnumber;
        this.phonenumber = phonenumber;
        this.email = email;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String name) {
        this.personname = name;
    }

    public Integer getApartmentnumber() {
        return apartmentnumber;
    }

    public void setApartmentnumber(Integer apartmentNumber) {
        this.apartmentnumber = apartmentNumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkIn) {
        this.checkin = checkIn;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkOut) {
        this.checkout = checkOut;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + personname + '\'' +
                ", apartmentNumber=" + apartmentnumber +
                ", phoneNumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", checkIn='" + checkin + '\'' +
                ", checkOut='" + checkout + '\'' +
                '}';
    }
}
