package com.ohgiraffers.section01.xmlconfig.service;

import com.ohgiraffers.dto.UserDTO;
import com.ohgiraffers.section01.xmlconfig.model.UserDAO;
import org.apache.ibatis.session.SqlSession;
import static com.ohgiraffers.common.Template.*;

import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<UserDTO> selectAllUser() {
        SqlSession session = getSqlSession();

        List<UserDTO> userList = userDAO.selectAllUser(session);

        session.close();

        return userList;
    }

    public boolean registUser(UserDTO user) {
        SqlSession session = getSqlSession();

        int result = userDAO.registUser(session, user);

        if (result > 0) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();

        return result > 0 ? true:false;
    }

    public boolean editUser(UserDTO user) {
        SqlSession session = getSqlSession();

        int result = userDAO.editUser(session, user);

        if (result > 0) {
            session.commit();
        } else {
            session.rollback();
        }
        session.close();

        return result > 0 ? true:false;
    }
}
