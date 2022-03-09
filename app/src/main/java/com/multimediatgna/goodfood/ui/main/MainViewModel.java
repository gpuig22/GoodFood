package com.multimediatgna.goodfood.ui.main;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public String getMycurrentuser() {
        return mycurrentuser;
    }

    public void setMycurrentuser(String mycurrentuser) {
        this.mycurrentuser = mycurrentuser;
    }

    public String mycurrentuser;


    // TODO: Implement the ViewModel
}