package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/22/2018.
 */

public class Provider {
    private int id;
    private String name;
    private String accountNumber;
    private double rewardRate;

    public Provider(int id, String name, String accountNumber, double rewardRate) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.rewardRate = rewardRate;
    }

    public Provider(String name, String accountNumber, double rewardRate) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.rewardRate = rewardRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(double rewardRate) {
        this.rewardRate = rewardRate;
    }
}
