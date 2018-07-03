package com.codecool.jpaexample.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "Class")
public class Klass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();

    @Enumerated(EnumType.ORDINAL)
    private CCLocation location;

    public Klass() {}

    public Klass(String name, CCLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public CCLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Klass{" +
                "name='" + name + "'" +
                "location='" + location + "'" +
                ", students=" + students.stream().map(Student::getName).collect(Collectors.toList()) +
                '}';
    }
}