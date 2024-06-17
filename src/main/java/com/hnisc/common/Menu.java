package com.hnisc.common;

import com.hnisc.po.Courses;

import java.util.Scanner;

public class Menu {
    //总菜单
    public static void getMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.flush();
            System.out.println("在线教育平台");

            System.out.println("1.用户管理");
            System.out.println("2.课程管理");
            System.out.println("3.成绩管理");
            System.out.println("4.退出");
            System.out.print("请输入你需要进行的操作：");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    Menu.getUserManageMenu();
                    break;
                case 2:
                    Menu.getCoursesManageMenu();
                    break;
                case 3:
                    System.out.println("成绩管理");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.print("你的输入有误，请重新输入：");
            }

        }

    }

    //用户菜单
    public static void getUserManageMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.flush();//清空
            System.out.println("用户管理");
            System.out.println("1.所有用户信息（模糊）");
            System.out.println("2.所有用户信息（精确）");
            System.out.println("3.根据用户id查询");
            System.out.println("4.增加用户信息");
            System.out.println("5.删除用户信息");
            System.out.println("6.修改用户信息");
            System.out.println("7.返回主菜单");
            System.out.println("8.退出程序");
            System.out.println("请输入你需要进行的操作：");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    UsersUtils.findAllUser();
                    MySystem.pause();
                    break;
                case 2:
                    UsersUtils.findAllUsersWithGradesWithCourses();
                    MySystem.pause();
                    break;
                case 3:
                    UsersUtils.findUsersById();
                    MySystem.pause();
                    break;
                case 4:
                    UsersUtils.insertUser();
                    MySystem.pause();
                    break;
                case 5:
                    UsersUtils.delUserById();
                    MySystem.pause();
                    break;
                case 6:
                    UsersUtils.updateUserById();
                    MySystem.pause();
                    break;
                case 7:
                    Menu.getMenu();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    //课程菜单
    public static void getCoursesManageMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.flush();//清空
            System.out.println("课程管理");
            System.out.println("1.所有课程信息（模糊）");
            System.out.println("2.所有课程信息（精确）");
            System.out.println("3.根据课程id查询（模糊）");
            System.out.println("4.增加课程信息");
            System.out.println("5.删除课程信息");
            System.out.println("6.修改课程信息");
            System.out.println("7.返回主菜单");
            System.out.println("8.退出程序");
            System.out.println("请输入你需要进行的操作：");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    CoursesUtils.findAllCourses();
                    MySystem.pause();
                    break;
                case 2:
                    CoursesUtils.findCoursesWithGradesWithUsers();
                    MySystem.pause();
                    break;
                case 3:
                    CoursesUtils.findCoursesById();
                    MySystem.pause();
                    break;
                case 4:
                    CoursesUtils.insertCourse();
                    MySystem.pause();
                    break;
                case 5:
                    CoursesUtils.delCourse();
                    MySystem.pause();
                    break;
                case 6:
                    CoursesUtils.updateCourseById();
                    MySystem.pause();
                    break;
                case 7:
                    Menu.getMenu();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    //成绩菜单
    public static void getGradesManageMenu() {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.flush();//清空
            System.out.println("成绩管理");
            System.out.println("1.所有成绩信息");
            System.out.println("2.根据用户id查询");
            System.out.println("3.增加成绩信息");
            System.out.println("4.删除成绩信息");
            System.out.println("5.修改成绩信息");
            System.out.println("6.返回主菜单");
            System.out.println("7.退出程序");
            System.out.println("请输入你需要进行的操作：");
            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("所有成绩信息");
                    break;
                case 2:
                    System.out.println("根据用户id查询");
                    break;
                case 3:
                    System.out.println("增加成绩信息");
                    break;
                case 4:
                    System.out.println("删除成绩信息");
                    break;
                case 5:
                    System.out.println("修改成绩信息");
                    break;
                case 6:
                    Menu.getMenu();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}
