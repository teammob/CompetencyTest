package com.test.scrumconnect.CompetencyTest.model;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="nodetest")
public class UserData implements Serializable {
    private final static long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="sex")
    private String sex;

    @Column(name="age")
    private int age;

    @Column(name="country")
    private String country;

    @Column(name="createdDate")
    private Date dateCreated;

    public UserData(String name, String sex, int age, String country, Date dateCreated) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.country = country;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("sex", sex)
                .add("age", age)
                .add("country", country)
                .add("createdDate", dateCreated)
                .toString();
    }
}
