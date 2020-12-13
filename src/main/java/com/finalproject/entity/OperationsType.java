package com.finalproject.entity;

public class OperationsType {
    int id;
    String operationType;

    public OperationsType(int id, String operationType) {
        this.id = id;
        this.operationType = operationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "OperationsType{" +
                "id=" + id +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
