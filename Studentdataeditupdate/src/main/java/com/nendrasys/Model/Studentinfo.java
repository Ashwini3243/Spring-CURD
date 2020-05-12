package com.nendrasys.Model;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Studentinfo implements Serializable {
    private int id;
    private String name;
    private int age;
    private String country;

    public int getId()
    {
        return id;
    }
    @XmlElement
    public void setId(int id) {

        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    @XmlElement
    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {
        return age;
    }
    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {

        return country;
    }

    @Override
    public String toString() {
        return "Studentinfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
    @XmlElement
    public void setCountry(String country) {

        this.country = country;
    }
}
