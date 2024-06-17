package com.hnisc.common;

import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class UsersUtils {
    public static Scanner sc=new Scanner(System.in);

//  ("1.所有用户信息（模糊）");
    public static void findAllUser(){
        //1.使用MybatisUtils生成sqlsession对象
        SqlSession sqlSession= MybatisUtils.getSession();
        //2.使用sqlSession执行sql语句
        List<Users> usersList=sqlSession.selectList("com.hnisc.mapper.UsersMapper." +
                 "findAllUser");
        //输出查询结果
        for(Users user:usersList){
            Check.usersCheak(user);
        }
        //4.关闭Sqlsession对象
        sqlSession.close();
}

//            System.out.println("2.所有用户信息（精确）");
public static void findAllUsersWithGradesWithCourses(){
    //1.使用MybatisUtils生成sqlsession对象
    SqlSession sqlSession= MybatisUtils.getSession();
    //2.使用sqlSession执行sql语句
    List<Users> usersList=sqlSession.selectList("com.hnisc.mapper.UsersMapper." +
            "findAllUsersWithGradesWithCourses");
    //输出查询结果
    for(Users user:usersList){
        Check.usersCheak(user);
        for(Courses courses:user.getCoursesList()){
            Check.coursesCheck(courses);
        }
        for(Grades grades: user.getGradesList()){
            Check.gradesCheck(grades);
        }
        System.out.println();
    }
    //4.关闭Sqlsession对象
    sqlSession.close();
}

//  ("3.根据用户id查询");
public static void findUsersById(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.print("请输入要查询的用户id:");
    int id = sc.nextInt();
    Users user=sqlSession.selectOne("com.hnisc.mapper.UsersMapper.findUsersById",id);
    Check.usersCheak(user);
    sqlSession.close();
}
public static Users getUsersById(int id){
    SqlSession sqlSession=MybatisUtils.getSession();
    Users user=sqlSession.selectOne("com.hnisc.mapper.UsersMapper.findUsersById",id);
    Check.usersCheak(user);
    sqlSession.close();
    return user;
}

//  ("4.增加用户信息");
public static void insertUser(){
    SqlSession sqlSession=MybatisUtils.getSession();
    Users user=new Users();
    System.out.print("请输入用户的姓名：");
    String userName=sc.nextLine();
    user.setUsername(userName);
    System.out.print("请输入用户的密码：");
    String pwd=sc.nextLine();
    user.setPassword(pwd);
    System.out.print("请输入用户的邮箱：");
    String emila=sc.nextLine();
    user.setEmail(emila);
    int row=sqlSession.insert("com.hnisc.mapper.UsersMapper.insertUser",user);
    if(row>0){
        System.out.println("添加成功!");
    }else{
        System.out.println("添加失败!");
    }
    sqlSession.commit();
    sqlSession.close();
}
//  ("5.删除用户信息");
public static void delUserById(){
    SqlSession sqlSession=MybatisUtils.getSession();
    System.out.print("请输入要删除的用户id:");
    int id = sc.nextInt();
    Users oldUser=UsersUtils.getUsersById(id);
    System.out.println("原用户信息：");
    System.out.println("姓名\t密码\t邮箱");
    System.out.println(oldUser.getUsername()+"\t"+ oldUser.getPassword()+"\t"+oldUser.getEmail());
    System.out.println("你确认要删除吗？(0:No 1:Yes)");
    while(true){
        sc=new Scanner(System.in);
        String pd=sc.nextLine();
        if(pd.equals("0")||pd.equals("no")||pd.equals("NO")||pd.equals("No")||pd.equals("oN")){
            System.out.println("删除失败");
            break;
        } else if(pd.equals("1")||pd.equals("yes")||pd.equals("y")||pd.equals("Yes")){
            int row=sqlSession.delete("com.hnisc.mapper.UsersMapper.delUserById",id);
            if(row>0){
                System.out.println("删除成功！");
                break;
            }else{
                System.out.println("删除失败！");
                break;
            }
        }else {
            System.out.print("你的输入有误，请重新输入：");
        }
    }
    sqlSession.commit();
    sqlSession.close();
}

//  ("6.修改用户信息");
public static void updateUserById(){
    SqlSession sqlSession=MybatisUtils.getSession();
    Users newUser=new Users();
    System.out.print("请输入要修改的用户id:");
    sc=new Scanner(System.in);
    int id=sc.nextInt();
    newUser.setId(id);
    Users oldUser=UsersUtils.getUsersById(id);
    System.out.println("输入no表示不修改！");
    System.out.print("请输入要修改的用户姓名"+"(原姓名："+oldUser.getUsername()+")：");
    String userName=sc.nextLine();
    if (userName.equals("no")||userName.equals("No")||userName.equals("NO")||userName.equals("nO")){
        newUser.setUsername(oldUser.getUsername());
    }else{
        newUser.setUsername(userName);
    }

    System.out.print("请输入要修改的用户密码"+"(原密码："+oldUser.getPassword()+")：");
    String pwd=sc.nextLine();
    if (pwd.equals("no")||pwd.equals("No")||pwd.equals("NO")||pwd.equals("nO")){
        newUser.setPassword(oldUser.getPassword());
    }else{
        newUser.setPassword(pwd);
    }

    System.out.print("请输入要修改的用户邮箱"+"(原邮箱："+oldUser.getEmail()+")：");
    String email=sc.nextLine();
    if (email.equals("no")||email.equals("No")||email.equals("NO")||email.equals("nO")){
        newUser.setEmail(oldUser.getEmail());
    }else{
        newUser.setEmail(email);
    }

    int row = sqlSession.update("com.hnisc.mapper.UsersMapper.updateUserById",newUser);
    if(row>0){
        System.out.println("修改成功!");
    }else{
        System.out.println("修改失败!");
    }
    sqlSession.commit();
    sqlSession.close();
}
}
