package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;

import static com.ohgiraffers.common.Template.*;

public class Application01 {
    public static void main(String[] args) {
        System.out.println(getSqlSession());

        /*MenuController menuController = new MenuController();
        menuController.selectAllMenu();*/

        /*MenuController menuController = new MenuController();
        Map<String, String> test = new HashMap<>();
        test.put("code", "4");
        menuController.selectMenuByCode(test);*/

        /*MenuController menuController = new MenuController();
        Map<String, String> test = new HashMap<>();
        test.put("name", "테스트 메뉴");
        test.put("price", "3000");
        test.put("category", "4");
        menuController.registMenu(test);*/

        MenuController menuController = new MenuController();
        Map<String, String> test = new HashMap<>();
        test.put("name", "테스트 메뉴");
        test.put("code", "4");
        test.put("status", "Y");
        test.put("price", "3000");
        test.put("category", "4");
        /*menuController.modifyMenu(test);*/
        menuController.selectAllMenu();
        /*menuController.deleteMenu(4);*/
    }
}
