package com.primedsoft.primedpoll;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("password_confirmation")
    private String passwordConfirmation;
    @SerializedName("verifycode")
    private String verifyCode;
    @SerializedName("newpassword")
    private String newPassword;
    @SerializedName("verifypassword")
    private String verifyPassword;

    public Data(String email, String password, String cnf_password) {
        this.email = email;
        this.password = password;
        passwordConfirmation = cnf_password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
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

    public Data(String email, String verifyCode, String newPassword, String verifyPassword) {
        this.email = email;
        this.verifyCode = verifyCode;
        this.newPassword = newPassword;
        this.verifyPassword = verifyPassword;
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
}
