import com.sunyx.dao.impl.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo3 {
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void Test1(){
        studentDao.save();
        studentDao.delete();
        studentDao.find();
        studentDao.update();
    }
}
