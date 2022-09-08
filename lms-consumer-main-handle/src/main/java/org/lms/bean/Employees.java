package org.lms.bean;

import java.util.List;

public class Employees {

    List<Employee> list;

    public Employees() {
    }

    public Employees(List<Employee> list) {
        this.list = list;
    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }
}
