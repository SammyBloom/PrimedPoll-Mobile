package com.primedsoft.primedpoll;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("message")
    private String message;
    @SerializedName("verified")
    private boolean verified;
    @SerializedName("password_confirmation")
    private String passwordConfirmation;
    @SerializedName("verifycode")
    private String verifyCode;
    @SerializedName("newpassword")
    private String newPassword;
    @SerializedName("verifypassword")
    private String verifyPassword;
    @SerializedName("success")
    private boolean success;
    @SerializedName("user")
    User UserObject;
    @SerializedName("token")
    private String token;

    public Data(Boolean success, String token, User UserOject){
        this.success = success;
        this.token = token;
        this.UserObject = UserOject;
    }

    public Data(String message, Boolean verified){
        this.message = message;
        this.verified = verified;
    }

    public Data(String email, String password, String cnf_password) {
        this.email = email;
        this.password = password;
        this.passwordConfirmation = cnf_password;
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

    public String getMessage() {
        return message;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public boolean getSuccess() {
        return success;
    }

    public User getUser() {
        return UserObject;
    }

    public String getToken() {
        return token;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void setUser(User userObject) {
        this.UserObject = userObject;
    }

    public void setToken(String token) {
        this.token = token;
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
