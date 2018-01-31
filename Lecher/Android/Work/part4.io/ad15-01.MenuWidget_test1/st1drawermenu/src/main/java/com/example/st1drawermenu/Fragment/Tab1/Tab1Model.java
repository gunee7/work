package com.example.st1drawermenu.Fragment.Tab1;

public class Tab1Model {

    private String name;
    private String number;
    private String department;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Tab1Model{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Tab1Model() {
    }

    public Tab1Model(String name, String number, String department) {
        this.name = name;
        this.number = number;
        this.department = department;
    }
}
