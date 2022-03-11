package com.multimediatgna.goodfood.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String mycurrentuser;

    public String getMycurrentpassword() {
        return mycurrentpassword;
    }

    public void setMycurrentpassword(String mycurrentpassword) {
        this.mycurrentpassword = mycurrentpassword;
    }

    private String mycurrentpassword;

    public String getMycurrentuser() {
        return mycurrentuser;
    }
    public void setMycurrentuser(String mycurrentuser) {
        this.mycurrentuser = mycurrentuser;
    }


}