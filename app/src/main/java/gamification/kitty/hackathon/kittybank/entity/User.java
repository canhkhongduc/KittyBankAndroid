package gamification.kitty.hackathon.kittybank.entity;

import java.io.Serializable;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class User implements Serializable {
    private int id;
    private String accountNumber;
    private String password;

    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
