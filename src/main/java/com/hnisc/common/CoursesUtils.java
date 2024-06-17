package com.hnisc.common;

import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class CoursesUtils {
    private static Scanner sc;
//            System.out.println("1.所有课程信息（模糊）");
public static void findAllCourses() {
    SqlSession sqlSession = MybatisUtils.getSession();
    List<Courses> listCourses = sqlSession.selectList("com.hnisc.mapper.CoursesMapper.findAllCourses");
    sqlSession.close();
    for (Courses course : listCourses) {
        System.out.println(course);
    }
}
//      <!--获取所有课程的所有信息-->;
public static void findCoursesWithGradesWithUsers() {
    SqlSession sqlSession = MybatisUtils.getSession();
    List<Courses> courses = sqlSession.selectList("com.hnisc.mapper.CoursesMapper.findCoursesWithGradesWithUsers");
    sqlSession.close();
    String cid=String.format("%-7s","课程id");
    String cname=String.format("%-14s","课程名");
    String cgrade=String.format("%-10s","成绩");
    String uname=String.format("%-8s","用户名");
    String email=String.format("%-20s","邮箱");
    String cs=String.format("%-20s","课程描述");
    System.out.println(cid+cname+cgrade+uname+email+cs);
    for (Courses course:courses){
        cid=String.format("%-7s",course.getId());
        cname=String.format("%-14s",course.getName());
        System.out.print(cid+cname);
        for (Grades grades : course.getGradesList()) {
            cgrade=String.format("%-10s",grades.getGrade());
            System.out.print(cgrade);
        }
        for (Users users : course.getUsersList()) {
            uname=String.format("%-8s",users.getUsername());
            email=String.format("%-20s",users.getEmail());
            System.out.print(uname+email);
        }
        cs=String.format("%-20s",course.getDescription());
        System.out.println(cs);
    }
}
//  ("3.根据课程id查询");
public static void findCoursesById(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.print("请输入要查询的课程id:");
    sc=new Scanner(System.in);
    int id = sc.nextInt();
    Courses courses=sqlSession.selectOne("com.hnisc.mapper.CoursesMapper.findCoursesById",id);
    sqlSession.close();
    Check.coursesCheck(courses);
}
public static Courses getCoursesById(int id){
    SqlSession sqlSession=MybatisUtils.getSession();
    Courses courses=sqlSession.selectOne("com.hnisc.mapper.CoursesMapper.findCoursesById",id);
    sqlSession.close();
    Check.coursesCheck(courses);
    return courses;
}

//  ("4.增加课程信息");
public static void insertCourse(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.print("请输入课程id：");
    sc=new Scanner(System.in);
    int cid = sc.nextInt();
    System.out.print("请输入课程名：");
    sc=new Scanner(System.in);
    String cname=sc.nextLine();
    System.out.println("请输入课程描述：");
    String cdescription=sc.nextLine();
    System.out.println("请输入用户id：");
    sc=new Scanner(System.in);
    int uid=sc.nextInt();
    Courses courses=new Courses(cid,cname,cdescription,uid);
    int row = sqlSession.insert("com.hnisc.mapper.CoursesMapper.insertCourse", courses);
    if(row>0){
        System.out.println("添加成功");
    }else{
        System.out.println("添加失败");
    }
    sqlSession.commit();
    sqlSession.close();
}

//  ("5.删除课程信息");
public static void delCourse(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.print("请输入课程id：");
    int cid = sc.nextInt();
    int row = sqlSession.delete("com.hnisc.mapper.CoursesMapper.delCourse", cid);
    if(row>0){
        System.out.println("删除成功");
    }else{
        System.out.println("删除失败");
    }
    sqlSession.commit();
    sqlSession.close();
}
//  ("6.修改课程信息");
public static void updateCourseById(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.println("请输入要修改的课程的id：");
    sc=new Scanner(System.in);
    int id = sc.nextInt();
    Courses oldCourse=CoursesUtils.getCoursesById(id);
    Courses newCourse=new Courses();

    System.out.println("输入no表示不修改！");
    System.out.print("请输入要修改的课程id"+"(原课程id："+oldCourse.getId()+")：");
    sc=new Scanner(System.in);
    String cid=sc.nextLine();
    if (cid.equals("no")||cid.equals("No")||cid.equals("NO")||cid.equals("nO")){
        newCourse.setId(oldCourse.getId());
    }else{
        newCourse.setId(Integer.parseInt(cid));
    }

    System.out.print("请输入要修改的课程名"+"(原课程名："+oldCourse.getName()+")：");
    sc=new Scanner(System.in);
    String cname=sc.nextLine();
    if (cname.equals("no")||cname.equals("No")||cname.equals("NO")||cname.equals("nO")){
        newCourse.setName(oldCourse.getName());
    }else{
        newCourse.setName(cname);
    }

    System.out.print("请输入要修改的课程描述"+"(原描述："+oldCourse.getDescription()+")：");
    sc=new Scanner(System.in);
    String cdescription=sc.nextLine();
    if (cdescription.equals("no")||cdescription.equals("No")||cdescription.equals("NO")||cdescription.equals("nO")){
        newCourse.setDescription(oldCourse.getDescription());
    }else{
        newCourse.setDescription(cdescription);
    }

    System.out.print("请输入要修改的用户id"+"(原用户id："+oldCourse.getInstructor_id()+")：");
    sc=new Scanner(System.in);
    String uid=sc.nextLine();
    if (uid.equals("no")||uid.equals("No")||uid.equals("NO")||uid.equals("nO")){
        newCourse.setInstructor_id(oldCourse.getInstructor_id());
    }else{
        newCourse.setInstructor_id(Integer.parseInt(uid));
    }

    int row = sqlSession.update("com.hnisc.mapper.CoursesMapper.updateCourseById",newCourse);
    if(row>0){
        System.out.println("修改成功");
    }else{
        System.out.println("修改失败");
    }
    sqlSession.commit();
    sqlSession.close();
}
}
