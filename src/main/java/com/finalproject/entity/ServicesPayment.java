package com.finalproject.entity;

public class ServicesPayment {
    int id;
    int serviceId;
    int operationTypeId;
    int operationId;

    public ServicesPayment(int id, int serviceId, int operationTypeId, int operationId) {
        this.id = id;
        this.serviceId = serviceId;
        this.operationTypeId = operationTypeId;
        this.operationId = operationId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
        return "ServicesPayment{" +
                "id=" + id +
                ", serviceId=" + serviceId +
                ", operationTypeId=" + operationTypeId +
                ", operationId=" + operationId +
                '}';
    }
}
