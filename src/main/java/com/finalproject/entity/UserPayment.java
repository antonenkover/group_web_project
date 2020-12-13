package com.finalproject.entity;

public class UserPayment {
    int id;
    int receiverId;
    int operationTypeId;
    int operationId;

    public UserPayment(int id, int receiverId, int operationTypeId, int operationId) {
        this.id = id;
        this.receiverId = receiverId;
        this.operationTypeId = operationTypeId;
        this.operationId = operationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(int operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    @Override
    public String toString() {
        return "UserPayment{" +
                "id=" + id +
                ", receiverId=" + receiverId +
                ", operationTypeId=" + operationTypeId +
                ", operationId=" + operationId +
                '}';
    }
}
