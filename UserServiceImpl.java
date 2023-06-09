package cn.edu.guet.service.impl;

import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    //依赖注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseData saveUser(Users user) {
        int save =0;
        try {
            save = userDao.save(user);
        }catch (SQLException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        //判断是否保存成功
        if (save==1){
            return new ResponseData("保存成功",200);
        }
        return ResponseData.fail("保存失败", 400);
        //return null;
    }

   /* public UserServiceImpl() {
        userDao =new UserDaoImpl();
    }

    @Override
    public String saveUser(User user) {
        userDao.saveUser(user);
        return null;
    }

    @Override
    public List<User> viewUser() {
        return userDao.viewUser();
    }

    @Override
    public String deleteUser(int id) {
        int delete = userDao.deleteUser(id);
        if (delete == 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateUser(User user) {
        userDao.updateUser(user);
        return null;
    }*/
}
