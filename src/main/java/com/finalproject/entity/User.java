package com.finalproject.entity;

import com.finalproject.enums.SecurityAccess;

public class User {
    int id;
    String login;
    String password;
    String name;
    String surname;
    int accountId;
    SecurityAccess securityAccess;

    public User() {
    }

    public User(int id, String login, String password,
                String name, String surname, int accountId, SecurityAccess securityAccess) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.accountId = accountId;
        this.securityAccess = securityAccess;
    }

    public User(String login, String password,
                String name, String surname, int accountId, SecurityAccess securityAccess) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.accountId = accountId;
        this.securityAccess = securityAccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public SecurityAccess getSecurityAccess() {
        return securityAccess;
    }

    public void setSecurityAccess(SecurityAccess securityAccess) {
        this.securityAccess = securityAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountId=" + accountId +
                ", securityAccess=" + securityAccess +
                '}';
    }
}
