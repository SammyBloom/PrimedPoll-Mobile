package com.primedsoft.primedpoll;

public class User {

    private float id;
    private String first_name = null;
    private String last_name = null;
    private String email;
    private String verifycode;
    private String phone = null;
    private String bio = null;
    private String image = null;
    private String dob = null;
    private String created_at;
    private String updated_at;

    public User(float id, String first_name, String last_name, String email, String phone, String bio, String image, String dob, String created_at, String updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.bio = bio;
        this.image = image;
        this.dob = dob;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    // Getter Methods

    public float getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public String getPhone() {
        return phone;
    }

    public String getBio() {
        return bio;
    }

    public String getImage() {
        return image;
    }

    public String getDob() {
        return dob;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    // Setter Methods

    public void setId(float id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
