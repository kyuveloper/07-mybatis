package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.section02.javaconfig.controller.MenuController;


public class Application01 {
    public static void main(String[] args) {

        MenuController menu = new MenuController();
        menu.selectAllMenu();

        /*Map<String, String> value = new HashMap<>();
        value.put("code", "6");
        menu.selectMenuByCode(value);*/

        /*Map<String, String> value = new HashMap<>();
        value.put("name", "민트 떡볶이");
        value.put("price", "9999");
        value.put("category", "5");
        menu.registMenu(value);*/
    }
}
