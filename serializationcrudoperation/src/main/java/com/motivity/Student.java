package com.motivity;

import java.io.Serializable;

class Student implements Serializable {
    private int id;
    private String name;
    private String branch;
    private String gender;

    public Student(int id, String name, String branch, String gender) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.gender = gender;
    }

    public Student() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {

        return branch;
    }

    public void setBranch(String branch) {

        this.branch = branch;
    }

    public String getGender() {

        return gender;
    }

    public void setGender(String gender) {

        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
