package com.karankulx.von.Models;

public class Users {

    String profilePic, name, email, password, rePassword, phoneNumber, status, uid;

    public Users() {};

    public Users(String profilePic, String name, String email, String password, String rePassword, String phoneNumber, String status, String uid) {
        this.profilePic = profilePic;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.uid = uid;
    }

    public Users(String email, String password, String rePassword) {
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public Users(String profilePic, String name, String phoneNumber, String status) {
        this.profilePic = profilePic;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
