package com.example.stephend.model;

/**
 * Created by stephend on 4/24/19.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts {

    @SerializedName("contacts")
    @Expose
    private Contact[] con;

    public Contact[] getContacts() {
        return con;
    }
}

