package com.example.maintenancerequest;

import jakarta.persistence.*;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer apartmentnumber;
    private String area;
    private String descrip;
    private String fulldatetime;
    private String image;
    private boolean completed;

    public Request() {
    }

    public Request(Integer apartmentnumber, String area, String descrip, String fulldatetime, String image) {
        this.apartmentnumber = apartmentnumber;
        this.area = area;
        this.descrip = descrip;
        this.fulldatetime = fulldatetime;
        this.image = image;
        this.completed = false;
    }

    public Request(Integer apartmentnumber, String area, String descrip, String fulldatetime, String image, boolean completed) {
        this.apartmentnumber = apartmentnumber;
        this.area = area;
        this.descrip = descrip;
        this.fulldatetime = fulldatetime;
        this.image = image;
        this.completed = completed;
    }

    public Request(Integer id, Integer apartmentnumber, String area, String descrip, String fulldatetime, String image, boolean completed) {
        this.id = id;
        this.apartmentnumber = apartmentnumber;
        this.area = area;
        this.descrip = descrip;
        this.fulldatetime = fulldatetime;
        this.image = image;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentnumber() {
        return apartmentnumber;
    }

    public void setApartmentnumber(Integer apartmentNumber) {
        this.apartmentnumber = apartmentNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String desc) {
        this.descrip = desc;
    }

    public String getFulldatetime() {
        return fulldatetime;
    }

    public void setFulldatetime(String dateTime) {
        this.fulldatetime = dateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) { this.completed = !completed; }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", apartmentNumber=" + apartmentnumber +
                ", area='" + area + '\'' +
                ", desc='" + descrip + '\'' +
                ", datetime='" + fulldatetime + '\'' +
                ", image='" + image + '\'' +
                ", completed=" + completed +
                '}';
    }
}
