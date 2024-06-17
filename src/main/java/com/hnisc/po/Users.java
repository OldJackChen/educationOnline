package com.hnisc.po;

import java.util.List;

public class Users {
    private int id;
    private String username;
    private String password;
    private String email;
    private List<Courses> coursesList;
    private List<Grades> gradesList;

    @Override
    public String toString() {
        return "用户详情：" +
                "用户id：" + id +
                ", 用户名：'" + username + '\'' +
                ", 密码：'" + password + '\'' +
                ", 邮箱：'" + email + '\'' ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }

    public List<Grades> getGradesList() {
        return gradesList;
    }

    public void setGradesList(List<Grades> gradesList) {
        this.gradesList = gradesList;
    }
}