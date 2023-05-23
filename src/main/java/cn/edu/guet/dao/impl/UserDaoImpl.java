package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int saveUser(User user) {
        Connection conn= DBConnection.getConn();
        PreparedStatement ps;
        //int save=0;
        String url = "jdbc:oracle:thin:@43.136.123.137:1521:orcl";
        String sql ="INSERT INTO " +
                "USERS  (USERNAME,ADDRESS) " +
                "VALUES(?,?)";
        try {
            /*Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "yzt", "Yzt276984");*/
            conn.setAutoCommit(false);//不让他自动提交
            ps=conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2, user.getAddress());
            int save=ps.executeUpdate();
            conn.commit();//提交
            return save;
        }catch (/*ClassNotFoundException | */SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
  /*          try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
            DBConnection.closeConn(conn);
        }
        return 0;
    }

/*    @Override
    public List<User> viewUser() {
        Connection conn=DBConnection.getConn();
        PreparedStatement ps;
        ResultSet rs=null;
        String url = "jdbc:oracle:thin:@43.136.123.137:1521:orcl";
        String sql ="select * from users";
        List<User> userList=new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "yzt", "Yzt276984");
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                int id= rs.getInt("id");
                String username= rs.getString("USERNAME");
                String address= rs.getString("ADDRESS");
                User user = new User(id,username,address);
                userList.add(user);
            }
            conn.setAutoCommit(false);//不让他自动提交
            ps=conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.commit();//提交
        }catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnection.closeConn(conn);
        }
        return userList;
    }

    @Override
    public int deleteUser(int id) {
        Connection conn = DBConnection.getConn();
        PreparedStatement ps;
        String url = "jdbc:oracle:thin:@43.136.123.137:1521:orcl";
        String sql = "DELETE " +
                "FROM users " +
                "where id = ? ";
        int delete=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "yzt", "Yzt276984");
            conn.setAutoCommit(false);//不让他自动提交
            ps = conn.prepareStatement(sql);
            ps.setInt(1, deleteUser(id));
            delete=ps.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();//关闭数据库连接
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            DBConnection.closeConn(conn);
        }
        return delete;
    }

    @Override
    public int updateUser(User user) {
        Connection conn = null;
        PreparedStatement ps;
        String url = "jdbc:oracle:thin:@43.136.123.137:1521:orcl";
        String sql = "INSERT INTO " +
                "users (id,username,address) " +
                "VALUES(?,?,?)";
        int update=0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "yzt", "Yzt276984");
            conn.setAutoCommit(false);//不让他自动提交
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setString(2,user.getUsername());
            ps.setString(3, user.getAddress());
            update=ps.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();//关闭数据库连接
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return update;
    }*/
}
