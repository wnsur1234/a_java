package com.grepp.library.c_collection.z_domain;

public class School implements Comparable<School> {

    private String name;
    private String address;
    private Integer level;

    public School(String name, String address, Integer level) {
        this.name = name;
        this.address = address;
        this.level = level;
    }

    @Override
    public String toString() {
        return "School{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", level=" + level +
            '}';
    }

    @Override
    public int compareTo(School o) {
        return this.level - o.level;
    }
}
