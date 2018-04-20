package gamification.kitty.hackathon.kittybank.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class User implements Serializable {
    private int id;
    private String accountNumber;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private byte gender;
    private int age;
    private Date dob;
    private double balance;
    private int creditPoint;
    private Double savingBalance;
    private int rankId;
    private boolean hasCreditCard;
    private boolean hasInternetBanking;
    private boolean useVPP;
    private boolean useDream;
    private byte isDeleted;

    public User(String accountNumber, String password) {
        this.accountNumber = accountNumber;
        this.password = password;
    }

    public User(int id, String accountNumber, String password, String email, String phone,
                String fullName, byte gender, int age, Date dob, double balance, int creditPoint,
                Double savingBalance, int rankId, boolean hasCreditCard, boolean hasInternetBanking,
                boolean useVPP, boolean useDream, byte isDeleted) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.dob = dob;
        this.balance = balance;
        this.creditPoint = creditPoint;
        this.savingBalance = savingBalance;
        this.rankId = rankId;
        this.hasCreditCard = hasCreditCard;
        this.hasInternetBanking = hasInternetBanking;
        this.useVPP = useVPP;
        this.useDream = useDream;
        this.isDeleted = isDeleted;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    public Double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(Double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public boolean isHasCreditCard() {
        return hasCreditCard;
    }

    public void setHasCreditCard(boolean hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public boolean isHasInternetBanking() {
        return hasInternetBanking;
    }

    public void setHasInternetBanking(boolean hasInternetBanking) {
        this.hasInternetBanking = hasInternetBanking;
    }

    public boolean isUseVPP() {
        return useVPP;
    }

    public void setUseVPP(boolean useVPP) {
        this.useVPP = useVPP;
    }

    public boolean isUseDream() {
        return useDream;
    }

    public void setUseDream(boolean useDream) {
        this.useDream = useDream;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
