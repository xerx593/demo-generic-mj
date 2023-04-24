package com.stackoverflow.demogenericmj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Emp implements BaseEntity {
    @Id
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    private Dep department;

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

    public Dep getDepartment() {
        return department;
    }

    public void setDepartment(Dep department) {
        this.department = department;
    }

}
