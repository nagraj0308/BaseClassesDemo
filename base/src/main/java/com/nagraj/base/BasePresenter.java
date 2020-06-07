package com.nagraj.base;

public abstract class BasePresenter<V extends BaseView> {
    protected V view;

    public void attachView(V view){
        this.view=view;
    }
    public void detachView() {
        this.view = null;
    }
}
