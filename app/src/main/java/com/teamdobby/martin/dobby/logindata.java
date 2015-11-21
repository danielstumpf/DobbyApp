package com.teamdobby.martin.dobby;

import java.util.ArrayList;

/**
 * Created by Martin on 03.11.2015.
 */
class logindata {

    static String curruser;
    static boolean logged;
    String name;
    String pass;
    static ArrayList<logindata> user = new ArrayList<logindata>();

    static void main() {
        user.add(new logindata("Dobby", "123"));
        user.add(new logindata("Test", "123"));
        user.add(new logindata("User", "test"));
    }

    public logindata(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    static boolean isValidName(String name) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i) != null) {
                if (user.get(i).name.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValidPass(String name, String pass) {
        int id;
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i).name.equals(name)) {
                if (user.get(i).pass.equals(pass)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void setCurrUser(String Name){
        curruser=Name;
    }

    static String getCurrUser(){
        if (curruser != null||curruser!="") {
            return curruser;
        }
        else return "ERROR";
    }

    static void setLogged(){
        logged=true;
    }
    static void notLogged(){
        logged=false;
    }
    static boolean getLogged(){
        return logged;
    }
}