package com.primedsoft.primedpoll.Models;

import com.google.gson.annotations.SerializedName;
import com.primedsoft.primedpoll.User;

import java.util.ArrayList;

public class Data {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String passwordConfirmation;
    @SerializedName("verified")
    private boolean verified;
    @SerializedName("verifycode")
    private String verifyCode;
    @SerializedName("message")
    private String message;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("image")
    private String image;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("dob")
    private String dob;
    @SerializedName("success")
    private boolean success;
    @SerializedName("phone")
    private String phone;
    @SerializedName("token")
    private String token;
    @SerializedName("user")
    User UserObject;
    private Data data;
    private ArrayList<Data> dataArrayList;
    @SerializedName("interest")
    private ArrayList<Interest> interestArrayList;


    public ArrayList<Data> getDataArrayList() {
        return dataArrayList;
    }

    public void setDataArrayList(ArrayList<Data> dataArrayList) {
        this.dataArrayList = dataArrayList;
    }

    public ArrayList<Interest> getInterestArrayList() {
        return interestArrayList;
    }

    public void setInterestArrayList(ArrayList<Interest> interestArrayList) {
        this.interestArrayList = interestArrayList;
    }

    public Data(Boolean success, String token, User UserOject){
        this.success = success;
        this.token = token;
        this.UserObject = UserOject;
    }

    public Data(String message, Boolean verified){
        this.message = message;
        this.verified = verified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public Data() {

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Data(String firstName, String lastName, String dob, String phone, String interests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
    }

    public Data(String verifyCode, String password, String cnf_password) {
        this.verifyCode = verifyCode;
        this.password = password;
        this.passwordConfirmation = cnf_password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public Data(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Data(String email) {
        this.email = email;

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

    public String getConfirmPassword() {
        return passwordConfirmation;
    }

    public void setConfirmPassword(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Data getData() {
        return data;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public User getUser() {
        return UserObject;
    }

    public void setUser(User userObject) {
        UserObject = userObject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
