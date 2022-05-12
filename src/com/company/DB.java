package com.company;

import java.util.ArrayList;
import java.util.List;

public class DB extends DBConnection {
    protected List<String> profile;



    public DB() {
        checkDB();

    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

    public List<String> getProfile() {
        return profile;
    }

    public void checkDB() {
        setProfile(super.getUser());
    }


}
