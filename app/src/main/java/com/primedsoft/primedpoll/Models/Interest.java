package com.primedsoft.primedpoll.Models;

import com.google.gson.annotations.SerializedName;

public class Interest {
    @SerializedName("interest")
    private String interest;
    @SerializedName("title")
    private String title;
    @SerializedName("id")
    private String id;

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
