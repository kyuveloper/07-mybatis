package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAO {
    public List<UserDTO> selectAllUser(SqlSession sqlSession) {
        return sqlSession.selectList("UserMapper.selectAllUser");
    }

    public int registUser(SqlSession session, UserDTO user) {
        return session.insert("UserMapper.insert", user);
    }

    public int editUser(SqlSession session, UserDTO user) {
        return session.update("UserMapper.editUser", user);
    }
}
