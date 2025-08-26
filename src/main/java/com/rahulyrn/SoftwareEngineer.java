package com.rahulyrn;

import java.util.Objects;

public class SoftwareEngineer {

    private int id;
    private String name;
    private String tech;

    public SoftwareEngineer() {

    }

    public SoftwareEngineer(int id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTech() {
        return tech;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(tech, that.tech);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tech);
    }
}
