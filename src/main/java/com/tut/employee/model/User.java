package com.tut.employee.model;

public class User {
    private Integer user_id;

    private String password;

    private String role;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer userid) {
        this.user_id = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}