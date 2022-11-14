package model;

import constants.Type;

public class Account {
    private String userName;
    private String password;



    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        System.out.printf("Tên tài khoản: %s \n Mật khẩu: %s ",userName,password + "\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
