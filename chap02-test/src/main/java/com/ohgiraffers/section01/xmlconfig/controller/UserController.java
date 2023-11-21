package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.common.PrintResult;
import com.ohgiraffers.dto.UserDTO;
import com.ohgiraffers.section01.xmlconfig.service.UserService;

import java.util.List;
import java.util.Map;

public class UserController {
    private final PrintResult printResult;
    private final UserService userService;

    public UserController() {
        this.printResult = new PrintResult();
        this.userService = new UserService();
    }

    public void selectAllUser() {
        List<UserDTO> userList = userService.selectAllUser();
        if (userList != null) {
            printResult.printUserList(userList);
        } else {
            printResult.printErrorMessage("selectUser");
        }
    }

    public void registUser(Map<String, String> parameter) {
        String name = parameter.get("name");
        String tier = parameter.get("tier");

        UserDTO user = new UserDTO();
        user.setName(name);
        user.setTier(tier);

        if (userService.registUser(user)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    public void editUser(Map<String, String> parameter) {
        String name = parameter.get("name");

        String tier = parameter.get("tier");

        UserDTO user = new UserDTO(name, tier);

        if (userService.editUser(user)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    /*public void deleteMenu(int code) {
        if (userService.deleteUser(code)) {
            printResult.printSuccessMessage("delete");
        } else {
            printResult.printErrorMessage("delete");
        }
    }*/
}
