package com.finalproject.entity;

public class Services {
    int id;
    String title;
    int accountId;

    public Services(int id, String title, int accountId) {
        this.id = id;
        this.title = title;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
