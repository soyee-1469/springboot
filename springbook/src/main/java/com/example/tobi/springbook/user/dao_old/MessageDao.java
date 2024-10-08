package com.example.tobi.springbook.user.dao_old;

import com.example.tobi.springbook.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDao {
    //  private SimpleConnectionMaker simpleConnectionMaker;
    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
//        simpleConnectionMaker = new SimpleConnectionMaker();
        this.connectionMaker = connectionMaker;

    }

    public void add(User user) throws ClassNotFoundException, SQLException {
//        Connection c = getConnection(); SimpleConnectionMaker로 뺌
//        Connection c = simpleConnectionMaker.makeNewConnection();
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();
        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        //        Connection c = getConnection(); SimpleConnectionMaker로 뺌
//        Connection c = simpleConnectionMaker.makeNewConnection();
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        c.close();
        return user;
    }

//    private Connection getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection c = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/springbook", "root", "1234");
//        return c;
//    } -> SimpleConnectionMaker로 뺌


}
