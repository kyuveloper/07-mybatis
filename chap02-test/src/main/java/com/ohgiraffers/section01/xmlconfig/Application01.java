package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.UserController;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;

public class Application01 {
    public static void main(String[] args) {
        // 연결 여부 확인
        /*System.out.println(getSqlSession());*/

        UserController userController = new UserController();
        // 전체 유저 조회
        userController.selectAllUser();

        /*Map<String, String> regist = new HashMap<>();
        regist.put("name", "샤오후");
        regist.put("tier", "브론즈");
        userController.registUser(regist);*/

        Map<String, String> edit = new HashMap<>();
        edit.put("name", "샤오후");
        edit.put("changedName", "레클레스");
        edit.put("tier", "플레티넘");
        userController.editUser(edit);
    }
}
