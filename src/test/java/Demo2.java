import com.sunyx.dao.CustomerDao;
import com.sunyx.dao.impl.CustomerDaoImpl;
import com.sunyx.dao.impl.StudentDao;
import com.sunyx.proxy.CustomerDaoProxy;
import com.sunyx.proxy.StudentProxy;
import org.junit.Test;

/**
 * Created by liuli on 2019/1/18.
 */
public class Demo2 {
    @Test
      public void test1(){
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }
    @Test
    public void test2(){
        CustomerDao customerDao = new CustomerDaoProxy(new CustomerDaoImpl()).createProxy();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }
    @Test
    public void test3(){
        StudentDao studentDao = new StudentProxy(new StudentDao()).createProxy();
        studentDao.save();
        studentDao.update();
        studentDao.delete();
        studentDao.find();
    }


}
