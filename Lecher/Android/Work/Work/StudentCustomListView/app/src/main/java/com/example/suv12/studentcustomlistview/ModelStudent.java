package com.example.suv12.studentcustomlistview;

import android.graphics.Movie;
import android.support.annotation.NonNull;

import java.util.Comparator;

/**
 * Created by suv12 on 2018-01-01.
 */

public class ModelStudent implements Comparable<ModelStudent> {

    private String name;
    private String number;
    private String department;
    private int uniquekey;

    public int getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(int uniquekey) {
        this.uniquekey = uniquekey;
    }

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
        return "ModelStudent{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", department='" + department + '\'' +
                ", uniquekey=" + uniquekey +
                '}';
    }

    public ModelStudent() {
    }

    public ModelStudent(String name, String number, String department, int uniquekey) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.uniquekey = uniquekey;
    }

    @Override
    public int compareTo(@NonNull ModelStudent s) {
        return 0;
    }

    public static class NameCompare implements Comparator<ModelStudent> {
        private int mode = 1;

        public NameCompare() {
            super();
            mode = 1;
        }

        public NameCompare(boolean desc) {
            super();
            if (desc == true) this.mode = -1;
        }

        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getName().compareTo(o2.getName()) * mode;
        }
    }

    public static class NumberCompare implements Comparator<ModelStudent> {
        private int mode = 1;

        public NumberCompare() {
            super();
            mode = 1;
        }

        public NumberCompare(boolean desc) {
            super();
            if (desc == true) this.mode = -1;
        }

        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getNumber().compareTo(o2.getNumber()) * mode;
        }
    }

    public static class DeptCompare implements Comparator<ModelStudent> {
        private int mode = 1;

        public DeptCompare() {
            super();
            mode = 1;
        }

        public DeptCompare(boolean desc) {
            super();
            if (desc == true) this.mode = -1;
        }

        @Override
        public int compare(ModelStudent o1, ModelStudent o2) {
            return o1.getDepartment().compareTo(o2.getDepartment()) * mode;
        }
    }
}