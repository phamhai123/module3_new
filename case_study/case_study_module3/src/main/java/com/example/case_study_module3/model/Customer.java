package com.example.case_study_module3.model;

public class Customer extends Person{
    private int typeID;
    private int gender;

    public Customer() {
    }

    public Customer(int id, int typeID, String name, String birthday, int gender, String idCard, String phone, String email, String address) {
        super(id, name, birthday, idCard, phone, email, address);
        this.typeID = typeID;
        this.gender = gender;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
}
