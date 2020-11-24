package com.example.placementstats.HomeScreen.Models;

public class ValuableTIpModel {
    private String tipId,userName,userProfile,userTip;
    private int upVote,downVote;

    public ValuableTIpModel() {
    }

    public ValuableTIpModel(String tipId, String userName, String userProfile, String userTip, int upVote, int downVote) {
        this.tipId = tipId;
        this.userName = userName;
        this.userProfile = userProfile;
        this.userTip = userTip;
        this.upVote = upVote;
        this.downVote = downVote;
    }

    public String getTipId() {
        return tipId;
    }

    public void setTipId(String tipId) {
        this.tipId = tipId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserTip() {
        return userTip;
    }

    public void setUserTip(String userTip) {
        this.userTip = userTip;
    }

    public int getUpVote() {
        return upVote;
    }

    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    public int getDownVote() {
        return downVote;
    }

    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }
}
