package de.vilkas.emailingrid;

import java.time.LocalDate;

public class Person {

    private Long id;
    private String name;
    private String email;
    private LocalDate bday;

    public Person(final LocalDate bday) {
        this.bday = bday;
    }

    public Person(final Long id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(final LocalDate bday) {
        this.bday = bday;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
