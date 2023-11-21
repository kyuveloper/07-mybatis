package com.ohgiraffers.common;

import com.ohgiraffers.dto.UserDTO;

import java.util.List;

public class PrintResult {
    public void printUserList(List<UserDTO> userList) {
        for (UserDTO user : userList) {
            System.out.println(user);
        }
    }

    public void printUser(UserDTO userDTO) {
        System.out.println(userDTO);
    }

    public void printSuccessMessage(String code) {
        String message = null;
        switch (code){
            case "insert" : message = "유저 등록 성공"; break;
            case "update" : message = "유저 수정 성공"; break;
            case "delete" : message = "유저 삭제 성공"; break;
            default: message = "잘못된 처리"; break;
        }
        System.out.println(message);
    }

    public void printErrorMessage(String code) {
        String message = null;
        switch (code) {
            case "selectUser" : message = "유저 전체 조회 실패"; break;
            case "selectOne" : message = "유저 조회 실패"; break;
            case "insert" : message = "유저 등록 실패"; break;
            case "update" : message = "유저 수정 실패"; break;
            case "delete" : message = "유저 삭제 실패"; break;
            default: message = "잘못된 처리"; break;
        }
        System.out.println(message);
    }
}
