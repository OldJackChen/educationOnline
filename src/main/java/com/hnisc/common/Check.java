package com.hnisc.common;

import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;

public class Check {
    public static Grades gradesCheck(Grades grades){
        switch(grades.getId()){
            case 1: grades.setName("Mathematics");break;
            case 2: grades.setName("Physics");break;
            case 3: grades.setName("History");break;
            case 4: grades.setName("Biology");break;
            case 5: grades.setName("Computer Science");break;
        }
        System.out.println("成绩表：{"+" 科目："+grades.getName()+" 分数："+grades.getGrade()+"}");
        return grades;
    }
    public static Users usersCheak(Users users){
        System.out.println("用户：{"+"用户id："+users.getId()+
                " 姓名："+users.getUsername()+" 邮箱："+users.getEmail()+"}");
        return users;
    }
    public static Courses coursesCheck(Courses courses){
        System.out.println("课程表：{"+"课程id："+courses.getId()+" 课程名："+courses.getName()+
                " 课程描述："+courses.getDescription()+"}");
        return courses;
    }
}
