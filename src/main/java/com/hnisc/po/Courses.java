package com.hnisc.po;

import java.util.List;

public class Courses {
    private int id;
    private String name;
    private String description;
    private int instructor_id;
    private List<Grades> gradesList;
    private List<Users> usersList;

    public Courses(int id, String name, String description, int instructor_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructor_id = instructor_id;
    }

    public Courses() {
    }

    @Override
    public String toString() {
        return "课程：" +
                "课程id=" + id +
                ", 课程名:'" + name + '\'' +
                ", 描述:'" + description ;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public List<Grades> getGradesList() {
        return gradesList;
    }

    public void setGradesList(List<Grades> gradesList) {
        this.gradesList = gradesList;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }
}

