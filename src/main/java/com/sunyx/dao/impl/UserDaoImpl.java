package com.sunyx.dao.impl;

import com.sunyx.dao.UserDao;
import com.sunyx.domain.User;
import com.sunyx.util.MyDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liuli on 2019/1/17.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    private MyDataSource myDataSource;

    public UserDaoImpl() {
    }

    public UserDaoImpl(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public MyDataSource getMyDataSource() {
        return myDataSource;
    }
    @Resource
    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    public User findByName(String userName) {
        String sql="select username,password,iphone from tt_user where username=?";
        User user = new User();
        try {
            Connection connection=myDataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,userName);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setIphone(resultSet.getString("iphone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public void save() {
        System.out.println("userDao save.....");
    }
}
