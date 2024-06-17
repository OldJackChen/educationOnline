import com.hnisc.common.Check;
import com.hnisc.common.MybatisUtils;
import com.hnisc.po.Courses;
import com.hnisc.po.Grades;
import com.hnisc.po.Users;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class GradesTest {


    //    <!--获取所有成绩的所有信息-->
    @Test
    public void findGradesByUserNameAndEmail(){
        SqlSession sqlSession= MybatisUtils.getSession();

        Users users=new Users();
        users.setUsername("user1");
        users.setEmail("user1@example.com");
        Grades grades=sqlSession.selectOne("com.hnisc.mapper.GradesMapper.findGradesByUserNameAndEmail",users);
        Check.usersCheak(users);
        Check.gradesCheck(grades);

        sqlSession.close();
    }


}
