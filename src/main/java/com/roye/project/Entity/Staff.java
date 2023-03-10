package com.roye.project.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Staff {
    private String id;
    private String name;
    private String sex;
    private String department;
    private Date birth;
    private BigDecimal salary;
    private BigDecimal perks;

    private Department departmentName;
    private User type;
    private User user;
    private Evaluate evaluate;

    public Evaluate getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Evaluate evaluate) {
        this.evaluate = evaluate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getType() {
        return type;
    }

    public void setType(User type) {
        this.type = type;
    }

    public Department getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Department departmentName) {
        this.departmentName = departmentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getPerks() {
        return perks;
    }

    public void setPerks(BigDecimal perks) {
        this.perks = perks;
    }
}
