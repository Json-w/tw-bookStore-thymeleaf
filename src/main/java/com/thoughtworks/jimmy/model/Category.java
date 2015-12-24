package com.thoughtworks.jimmy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private String code;
    private String name;
    private String descirb;

    public Category(String code, String name, String descirb) {
        this.code = code;
        this.name = name;
        this.descirb = descirb;
    }

    public Category() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescirb() {
        return descirb;
    }

    public void setDescirb(String descirb) {
        this.descirb = descirb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
