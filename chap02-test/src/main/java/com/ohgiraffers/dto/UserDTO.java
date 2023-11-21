package com.ohgiraffers.dto;


public class UserDTO {
    private int code;
    private String name;
    private String changedName;
    private String tier;

    public UserDTO() {
    }

    public UserDTO(String name, String tier) {
        this.name = name;
        this.tier = tier;
    }

    public UserDTO(String name, String changedName, String tier) {
        this.name = name;
        this.changedName = changedName;
        this.tier = tier;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChangedName() {
        return changedName;
    }

    public void setChangedName(String changedName) {
        this.changedName = changedName;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", changedName='" + changedName + '\'' +
                ", tier='" + tier + '\'' +
                '}';
    }
}
