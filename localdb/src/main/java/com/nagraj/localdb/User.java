package com.nagraj.localdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Peoples")
public class User {
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    public int uid;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "age")
    public int age;

    public User(int uid, String firstName, String lastName, int age) {
        this.uid = uid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getUid() {
        return uid;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public int getAge() {
        return age;
    }

}