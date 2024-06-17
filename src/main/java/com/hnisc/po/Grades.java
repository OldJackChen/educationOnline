package com.hnisc.po;

public class Grades {
    private int id;
    private float grade;
    private String name;
    private int user_id;
    private int course_id;

    public Grades() {
    }

    public Grades(int id, float grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    public Grades(int id, float grade, String name, int user_id, int course_id) {
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "成绩表：" +
                "成绩id=" + id +
                ", 分数=" + grade;
    }
}
