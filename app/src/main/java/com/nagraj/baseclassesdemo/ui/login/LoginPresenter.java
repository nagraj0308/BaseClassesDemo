package com.nagraj.baseclassesdemo.ui.login;

import com.nagraj.base.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter<LoginView> {
    @Inject LoginPresenter(){

    }
    void getMessage(String message){
        view.setMessage(message);
    }
}
