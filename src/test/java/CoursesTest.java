import com.hnisc.common.Check;
import com.hnisc.common.MybatisUtils;
import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class CoursesTest {

    //  <!--    查询所有课程-->
    @Test
    public void findAllCourses() {
        SqlSession sqlSession = MybatisUtils.getSession();
        List<Courses> listCourses = sqlSession.selectList("com.hnisc.mapper.CoursesMapper.findAllCourses");
        sqlSession.close();
        for (Courses course : listCourses) {
            System.out.println(course);
        }
    }

    //    <!--获取所有课程的所有信息-->
    @Test
    public void findCoursesWithGradesWithUsers() {
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

    //    <!--    根据用户编号获取用户信息-->
    @Test
    public void findCoursesById(){
        SqlSession sqlSession=MybatisUtils.getSession();
        Courses courses=sqlSession.selectOne("com.hnisc.mapper.CoursesMapper.findCoursesById",3);
        sqlSession.close();
        Check.coursesCheck(courses);
    }

    //    <!--    增加课程信息-->
    @Test
    public void insertCourse(){
        SqlSession sqlSession=MybatisUtils.getSession();
        Courses courses=new Courses(6,"语文","文化，博大精深",4);
        int row = sqlSession.insert("com.hnisc.mapper.CoursesMapper.insertCourse", courses);
        if(row>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    //    <!--    删除课程信息-->
    @Test
    public void delCourse(){
        SqlSession sqlSession=MybatisUtils.getSession();
        int row = sqlSession.delete("com.hnisc.mapper.CoursesMapper.delCourse", 8);
        if(row>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //    <!--    修改用课程信息-->
    @Test
    public void updateCourseById(){
        SqlSession sqlSession=MybatisUtils.getSession();

        Courses course=new Courses();
        course.setId(5);
        course.setName("数学");
        course.setDescription("逻辑，脑洞大开");
        course.setInstructor_id(1);
        int row = sqlSession.update("com.hnisc.mapper.CoursesMapper.updateCourseById",course);
        if(row>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}



