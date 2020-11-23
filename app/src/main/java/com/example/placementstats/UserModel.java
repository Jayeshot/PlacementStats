package com.example.placementstats;

public class UserModel {
    private String Id,userName,userPhone,userCollege,userCGPA;
    private int genderFlag;

    public UserModel() {
    }

    public UserModel(String id, String userPhone) {
        Id = id;
        this.userPhone = userPhone;
    }

    public UserModel(String id, String userName, String userPhone, String userCollege, String userCGPA, int genderFlag) {
        Id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userCollege = userCollege;
        this.userCGPA = userCGPA;
        this.genderFlag = genderFlag;
    }

    public int getGenderFlag() {
        return genderFlag;
    }

    public void setGenderFlag(int genderFlag) {
        this.genderFlag = genderFlag;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    public String getUserCGPA() {
        return userCGPA;
    }

    public void setUserCGPA(String userCGPA) {
        this.userCGPA = userCGPA;
    }
}
