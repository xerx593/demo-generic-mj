package com.stackoverflow.demogenericmj.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Dep implements BaseEntity {
    @Id
    private Long id;

    private String name;
    @OneToOne(optional = true)
    private Emp director;

    @OneToMany(mappedBy = "department")
    Set<Emp> members = new HashSet<>();

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

    public Emp getDirector() {
        return director;
    }

    public void setDirector(Emp director) {
        this.director = director;
    }

    public Set<Emp> getMembers() {
        return members;
    }

    public void setMembers(Set<Emp> members) {
        this.members = members;
    }

}
