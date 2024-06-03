package org.example.services;

import org.example.dao.UserDAO;
import org.example.model.User;


import java.sql.SQLException;

public class UserService {

    public static Integer saveUser(User user){

        try {
            if (UserDAO.isUserExist(user.getEmail())){
                return 0;
            }else {
                UserDAO.saveUser(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}