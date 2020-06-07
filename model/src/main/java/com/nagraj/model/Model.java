package com.nagraj.model;

import com.nagraj.localdb.User;
import com.nagraj.localdb.UserDatabase;
import java.util.List;
import javax.inject.Inject;

public class Model {

    private final UserDatabase userDatabase;

    @Inject
    public Model(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean insertUser(String firstName, String lastName, int userId, int age) {
        try {
            userDatabase.userDao().insertAll(new User(userId, firstName, lastName, age));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteId(int userId) {
        try {
            userDatabase.userDao().delete(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<User> searchByName(String firstName, String lastName) {
        try {
            return userDatabase.userDao().findByName(firstName, lastName);
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> reload() {
        try {
            return userDatabase.userDao().getAll();
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> searchById(int Id) {
        try {
            return userDatabase.userDao().loadAllByIds(Id);
        } catch (Exception e) {
            return null;
        }
    }
}
