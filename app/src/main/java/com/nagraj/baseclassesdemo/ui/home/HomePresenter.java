package com.nagraj.baseclassesdemo.ui.home;

import com.nagraj.base.BasePresenter;
import com.nagraj.model.Model;
import javax.inject.Inject;

public class HomePresenter extends BasePresenter<HomeView> {
    public final Model model;
    @Inject HomePresenter(Model model){
        this.model=model;
    }

    void insertUser(String firstName,String lastName,int userId,int age){
        view.setInsertResult(model.insertUser(firstName,lastName,userId,age));
    }
    void deleteId(int userId){
        view.setDeleteResult(model.deleteId(userId));
    }

    void searchByName(String firstName, String lastName){
       view.setSearchByNameResult(model.searchByName(firstName,lastName));
    }
    void searchById(int Id){
        view.setSearchByIdResult(model.searchById(Id));
    }
    void reload(){
        view.setReloadResult(model.reload());
    }

}
