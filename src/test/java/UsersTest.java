import com.hnisc.common.MybatisUtils;
import com.hnisc.common.Check;
import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class UsersTest {
    @Test
    public void findAllUser(){
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

    @Test
    public void findAllUsersWithGradesWithCourses(){
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

    @Test
    public void findUsersById(){
        SqlSession sqlSession=MybatisUtils.getSession();
        Users user=sqlSession.selectOne("com.hnisc.mapper.UsersMapper.findUsersById",3);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession=MybatisUtils.getSession();
        Users user=new Users();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setEmail("123456@163.com");
        int row=sqlSession.insert("com.hnisc.mapper.UsersMapper.insertUser",user);
        if(row>0){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUserById(){
        SqlSession sqlSession=MybatisUtils.getSession();
        int row=sqlSession.delete("com.hnisc.mapper.UsersMapper.delUserById",1);
        if(row>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserById(){
        SqlSession sqlSession=MybatisUtils.getSession();

        Users users=new Users();
        users.setId(5);
        users.setUsername("李四");
        users.setPassword("654123");
        users.setEmail("654123@qq.com");
        int row = sqlSession.update("com.hnisc.mapper.UsersMapper.updateUserById",users);
        if(row>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
